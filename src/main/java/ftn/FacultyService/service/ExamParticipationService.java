package ftn.FacultyService.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.FacultyService.dto.ExamParticipationDTO;
import ftn.FacultyService.entity.ExamParticipation;
import ftn.FacultyService.entity.User;
import ftn.FacultyService.repository.ExamParticipationRepository;
import ftn.FacultyService.repository.ExamRepository;
import ftn.FacultyService.repository.StudentRepository;
import ftn.FacultyService.repository.UserRepository;

@Service
public class ExamParticipationService {

	@Autowired
	StudentRepository studentRepo;
	
	@Autowired
	ExamRepository examRepo;
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	ExamParticipationRepository examPartRepo;
	
	public boolean register(ExamParticipationDTO examParticipationDTO) {
		ExamParticipation examPart = new ExamParticipation();
		User thisUser = userRepo.getOne(examParticipationDTO.getStudent().getId()); 
		examPart.setStudent(studentRepo.getOne(thisUser.getStudent().getId()));
		examPart.setExam(examRepo.getOne(examParticipationDTO.getExam().getId()));
		examPart.setPoints(-1);
		examPart.setPassed(false);
		System.out.println(examPart.toString());
		examPartRepo.save(examPart);
		return true;
	}

	public List<ExamParticipationDTO> getExamParticipations(int examId) {
		List<ExamParticipation> epl = examPartRepo.findAll();
		List<ExamParticipationDTO> eplDTO = new ArrayList<ExamParticipationDTO>();
		for(ExamParticipation e: epl) {
			if(e.getExam().getId() == examId) {
				eplDTO.add(new ExamParticipationDTO(e));
			}
		}
		return eplDTO;
	}

}
