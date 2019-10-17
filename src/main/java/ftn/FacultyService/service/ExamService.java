package ftn.FacultyService.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import ftn.FacultyService.dto.ExamDTO;
import ftn.FacultyService.entity.Exam;
import ftn.FacultyService.entity.ExamPeriod;
import ftn.FacultyService.entity.Professor;
import ftn.FacultyService.entity.Subject;
import ftn.FacultyService.entity.TypeOfExam;
import ftn.FacultyService.entity.User;
import ftn.FacultyService.repository.ExamPeriodRepository;
import ftn.FacultyService.repository.ExamRepository;
import ftn.FacultyService.repository.SubjectRepository;
import ftn.FacultyService.repository.UserRepository;

@Service
public class ExamService {

	@Autowired
	ExamRepository examRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	SubjectRepository subjectRepository;
	
	@Autowired
	ExamPeriodRepository expRepository;

	public Page<ExamDTO> getAllPage(Integer page, Integer size) {
		PageRequest pr = PageRequest.of(page, size);
		Page<Exam> e = examRepository.findAll(pr);
		Page<ExamDTO> eDTO = e.map(ExamDTO::new);
		return eDTO;
	}

	public boolean addExam(ExamDTO examDTO) {
		if (examDTO != null) {
			Exam exam = new Exam();
			exam.setType(examDTO.getType());
			exam.setClassroom(examDTO.getClassroom());
			exam.setDate(examDTO.getDate());
			System.out.println(examDTO.getExamPeriod() == null);
			exam.setSubject(subjectRepository.findByName(examDTO.getSubject().getName()));
			exam.setExamPeriod(expRepository.findByName(examDTO.getExamPeriod().getName()));
			examRepository.save(exam);
			return true;
		} else {
			return false;
		}
	}

	public boolean updateExam(ExamDTO examDTO) {
		if (examDTO != null) {
			Exam exam = examRepository.getOne(examDTO.getId());
			exam.setType(examDTO.getType());
			exam.setClassroom(examDTO.getClassroom());
			exam.setDate(examDTO.getDate());
			exam.setSubject(new Subject(examDTO.getSubject()));
			exam.setExamPeriod(new ExamPeriod(examDTO.getExamPeriod()));
			examRepository.save(exam);
			return true;
		} else {
			return false;
		}
	}

	public boolean deleteExam(int id) {
		Exam exam = examRepository.getOne(id);
		try {
			examRepository.delete(exam);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public List<ExamDTO> getAllProfesorExams(int id) {
		List<ExamDTO> professorExamsDTO = new ArrayList<>();
		List<Exam> exams = examRepository.findAll();
		User u = userRepository.getOne(id);
		for (Exam e : exams) {
			if (e.getType() == TypeOfExam.Ispit) {
				for (Professor professor : e.getSubject().getProfessors()) {
					if (professor.getId() == u.getProfessor().getId()) {
						professorExamsDTO.add(new ExamDTO(e));
					}
				}
			}
		}
		return professorExamsDTO;
	}
	
	public List<ExamDTO> getAllProfesorTests(int id) {
		List<ExamDTO> professorExamsDTO = new ArrayList<>();
		List<Exam> exams = examRepository.findAll();
		User u = userRepository.getOne(id);
		for (Exam e : exams) {
			if (e.getType() == TypeOfExam.Kolokvijum) {
				for (Professor professor : e.getSubject().getProfessors()) {
					if (professor.getId() == u.getProfessor().getId()) {
						professorExamsDTO.add(new ExamDTO(e));
					}
				}
			}
		}
		return professorExamsDTO;
	}

	public List<ExamDTO> getUnreviewedExams(int id) {
		List<ExamDTO> professorExamsDTO = new ArrayList<>();
		/*List<Exam> exams = examRepository.findAll();

		for (Exam e : exams) {
			if (e.getType() == TypeOfExam.TEST) {
				for (Professor professor : e.getSubject().getProfessors()) {
					if (professor.getId() == id) {
						professorExamsDTO.add(new ExamDTO(e));
					}
				}
			}
		}*/
		return professorExamsDTO;
	}
}
