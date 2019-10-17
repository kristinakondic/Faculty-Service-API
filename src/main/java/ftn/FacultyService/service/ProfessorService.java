package ftn.FacultyService.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ftn.FacultyService.dto.MessageDTO;
import ftn.FacultyService.dto.ProfessorDTO;
import ftn.FacultyService.entity.Professor;
import ftn.FacultyService.entity.Role;
import ftn.FacultyService.entity.User;
import ftn.FacultyService.repository.ProfessorRepository;
import ftn.FacultyService.repository.UserRepository;

@Service
public class ProfessorService {

	@Autowired
	ProfessorRepository professorRepository;

	@Autowired
	UserRepository userRepository;

	public Page<ProfessorDTO> getAllPage(Integer page, Integer size) {
		PageRequest pr = PageRequest.of(page, size);
		Page<Professor> p = professorRepository.findAll(pr);
		Page<ProfessorDTO> pDTO = p.map(ProfessorDTO::new);
		return pDTO;
	}

	public ProfessorDTO getById(int id) {
		Professor professor = professorRepository.getOne(id);
		if (professor == null) {
			return null;
		} else {
			return new ProfessorDTO(professor);
		}
	}

	public MessageDTO register(ProfessorDTO professorDTO) {
		User checkProfessor = userRepository.findByEmail(professorDTO.getUserDTO().getEmail());
		if (checkProfessor == null) {
			try {
				BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

				Professor professor = new Professor();
				User user = new User();
				user.setName(professorDTO.getUserDTO().getName());
				user.setSurname(professorDTO.getUserDTO().getSurname());
				user.setEmail(professorDTO.getUserDTO().getEmail());
				user.setPassword(encoder.encode("fakultet"));
				user.setCreationDate(new Date());
				user.setRole(Role.PROFESSOR);
				user.setIdentityNo(professorDTO.getUserDTO().getIdentityNo());
				user.setAddress(professorDTO.getUserDTO().getAddress());
				userRepository.save(user);
				professor.setUser(user);
				professor.setType(professorDTO.getType());
				professorRepository.save(professor);
				user.setProfessor(professor);
				userRepository.save(user);
				return new MessageDTO("Uspesna registracija", true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return new MessageDTO("Email is already taken", false);
	}

	public boolean updateProfessor(ProfessorDTO professorDTO) {
		if (professorDTO != null) {
			Professor professor = professorRepository.getOne(professorDTO.getId());
			User user = new User();
			user.setId(professorDTO.getUserDTO().getId());
			user.setName(professorDTO.getUserDTO().getName());
			user.setSurname(professorDTO.getUserDTO().getSurname());
			user.setEmail(professorDTO.getUserDTO().getEmail());
			user.setPassword(professorDTO.getUserDTO().getPassword());
			user.setCreationDate(professorDTO.getUserDTO().getCreationDate());
			user.setRole(professorDTO.getUserDTO().getRole());
			user.setIdentityNo(professorDTO.getUserDTO().getIdentityNo());
			user.setAddress(professorDTO.getUserDTO().getAddress());
			professor.setType(professorDTO.getType());
			professor.setUser(user);
			userRepository.save(user);
			professorRepository.save(professor);
			return true;
		} else {
			return false;
		}
	}

	public boolean deleteProfessor(int id) {
		Professor professor = professorRepository.getOne(id);
		try {
			professorRepository.delete(professor);
			userRepository.delete(professor.getUser());
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
