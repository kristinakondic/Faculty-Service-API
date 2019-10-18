package ftn.FacultyService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ftn.FacultyService.dto.MessageDTO;
import ftn.FacultyService.dto.StudentDTO;
import ftn.FacultyService.entity.ExamParticipation;
import ftn.FacultyService.entity.Payment;
import ftn.FacultyService.entity.Student;
import ftn.FacultyService.entity.User;
import ftn.FacultyService.repository.ExamParticipationRepository;
import ftn.FacultyService.repository.PaymentRepository;
import ftn.FacultyService.repository.StudentRepository;
import ftn.FacultyService.repository.UserRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	UserService userService;
	@Autowired
	PaymentRepository paymentRepo;
	@Autowired
	ExamParticipationRepository examPartRepo;

	public Page<StudentDTO> getAllPage(Integer page, Integer size) {
		PageRequest pr = PageRequest.of(page, size);
		Page<Student> s = studentRepository.findAll(pr);
		Page<StudentDTO> sDTO = s.map(StudentDTO::new);
		return sDTO;
	}

	public StudentDTO getById(int id) {
		Student student = studentRepository.getOne(id);
		if (student == null) {
			return null;
		} else {
			return new StudentDTO(student);
		}
	}
	
	public StudentDTO getByEmail(String email) {
		//User user = new User(userService.getUser(email));
		User user = userRepository.findByEmail(email);
		Student student = user.getStudent();
		double accStatus = 0;
		
		List<Payment> allPayments = paymentRepo.findAll();
		List<ExamParticipation> allParticipations = examPartRepo.findAll();
		
		for(Payment payment : allPayments) {
			if(payment.getStudent().getId() == student.getId()) {
				accStatus = accStatus + payment.getValue();
			}
		}
		
		for(ExamParticipation participation : allParticipations) {
			if(participation.getStudent().getId() == student.getId()) {
				accStatus -= 200;
			}
		}
		
		
		if (student == null) {
			return null;
		} else {
			StudentDTO studentDTO = new StudentDTO(student);
			studentDTO.setAccountStatus(accStatus);
			studentDTO.setUserDTO(null);
			return studentDTO;
		}
	}

	public MessageDTO register(StudentDTO studentDTO) {
		User checkStudent = userRepository.findByEmail(studentDTO.getUserDTO().getEmail());
		if (checkStudent == null) {
			try {
				BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

				Student student = new Student();
				User user = new User();
				user.setName(studentDTO.getUserDTO().getName());
				user.setSurname(studentDTO.getUserDTO().getSurname());
				user.setEmail(studentDTO.getUserDTO().getEmail());
				user.setPassword(encoder.encode(studentDTO.getUserDTO().getPassword()));
				user.setCreationDate(studentDTO.getUserDTO().getCreationDate());
				user.setRole(studentDTO.getUserDTO().getRole());
				user.setIdentityNo(studentDTO.getUserDTO().getIdentityNo());
				user.setAddress(studentDTO.getUserDTO().getAddress());
				userRepository.save(user);
				student.setUser(user);
				student.setIndexNo(studentDTO.getIndexNo());
				student.setYearOfStudy(studentDTO.getYearOfStudy());
				userRepository.save(user);
				studentRepository.save(student);
				return new MessageDTO("Uspesna registracija", true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return new MessageDTO("Email is already taken", false);
	}

	public boolean updateStudent(StudentDTO studentDTO) {
		if (studentDTO != null) {
			Student student = studentRepository.getOne(studentDTO.getId());
			User user = new User();
			user.setId(studentDTO.getUserDTO().getId());
			user.setName(studentDTO.getUserDTO().getName());
			user.setSurname(studentDTO.getUserDTO().getSurname());
			user.setEmail(studentDTO.getUserDTO().getEmail());
			user.setCreationDate(studentDTO.getUserDTO().getCreationDate());
			user.setRole(studentDTO.getUserDTO().getRole());
			user.setIdentityNo(studentDTO.getUserDTO().getIdentityNo());
			user.setPassword(studentDTO.getUserDTO().getPassword());
			user.setAddress(studentDTO.getUserDTO().getAddress());
			student.setUser(user);
			student.setIndexNo(studentDTO.getIndexNo());
			student.setYearOfStudy(studentDTO.getYearOfStudy());
			userRepository.save(user);
			studentRepository.save(student);
			return true;
		} else {
			return false;
		}
	}

	public boolean deleteStudent(int id) {
		Student student = studentRepository.getOne(id);
		try {
			studentRepository.delete(student);
			userRepository.delete(student.getUser());
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
