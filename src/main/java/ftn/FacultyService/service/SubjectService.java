package ftn.FacultyService.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import ftn.FacultyService.dto.ExamDTO;
import ftn.FacultyService.dto.SubjectDTO;
import ftn.FacultyService.entity.Exam;
import ftn.FacultyService.entity.ExamParticipation;
import ftn.FacultyService.entity.FieldsOfStudy;
import ftn.FacultyService.entity.Professor;
import ftn.FacultyService.entity.Student;
import ftn.FacultyService.entity.Subject;
import ftn.FacultyService.entity.User;
import ftn.FacultyService.repository.ExamRepository;
import ftn.FacultyService.repository.StudentRepository;
import ftn.FacultyService.repository.SubjectRepository;
import ftn.FacultyService.repository.UserRepository;

@Service
public class SubjectService {

	@Autowired
	SubjectRepository subjectRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	ExamRepository examRepository;

	public Page<SubjectDTO> getAllPage(Integer page, Integer size) {
		PageRequest pr = PageRequest.of(page, size);
		Page<Subject> s = subjectRepository.findAll(pr);
		Page<SubjectDTO> sDTO = s.map(SubjectDTO::new);
		return sDTO;
	}

	public SubjectDTO getById(int id) {
		Subject subject = subjectRepository.getOne(id);
		if (subject == null)
			return null;
		else
			return new SubjectDTO(subject);
	}

	public boolean addSubject(SubjectDTO subjectDTO) {
		if (subjectDTO != null) {
			Subject subject = new Subject();
			subject.setEspb(subjectDTO.getEspb());
			subject.setName(subjectDTO.getName());
			subject.setSubjectNo(subjectDTO.getSubjectNo());
			subject.setYear(subjectDTO.getYear());
			subject.setFieldsOfStudy(new FieldsOfStudy(subjectDTO.getFieldsOfStudyDTO()));
			subjectRepository.save(subject);
			return true;
		} else {
			return false;
		}
	}

	public boolean updateSubject(SubjectDTO subjectDTO) {
		if (subjectDTO != null) {
			Subject subject = subjectRepository.getOne(subjectDTO.getId());
			subject.setEspb(subjectDTO.getEspb());
			subject.setName(subjectDTO.getName());
			subject.setSubjectNo(subjectDTO.getSubjectNo());
			subject.setYear(subjectDTO.getYear());
			subject.setFieldsOfStudy(new FieldsOfStudy(subjectDTO.getFieldsOfStudyDTO()));
			subjectRepository.save(subject);
			return true;
		} else {
			return false;
		}
	}

	public boolean deleteSubject(int id) {
		Subject subject = subjectRepository.getOne(id);
		try {
			subjectRepository.delete(subject);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean isSubjectPassed(int studentId, int subjectId) {
		boolean passed = false;
		Student student = studentRepository.getOne(studentId);
		Subject subject = subjectRepository.getOne(subjectId);
		for (ExamParticipation ep : student.getExamsParticipation()) {
			if (ep.getExam().getSubject().getId() == subject.getId()) {
				if (ep.getPassed()) {
					passed = true;
				}
			}
		}
		return passed;
	}
	
	public boolean isExamRegistered(int studentId, int examId) {
		boolean registered = false;
		Student student = studentRepository.getOne(studentId);
		for (ExamParticipation ep : student.getExamsParticipation()) {
			if (ep.getExam().getId() == examId) {
				if (ep.getPoints() == -1) {
					registered = true;
				}
			}
		}
		return registered;
	}

	public List<ExamDTO> getStudentsNextExams(int studentId, int subjectId) {
		List<ExamDTO> exams = new ArrayList<ExamDTO>();
		List<Exam> allExams = examRepository.findAll();
		for(Exam e : allExams) {
			if(e.getSubject().getId() == subjectId && e.getDate().compareTo(new Date()) > 0) {
				ExamDTO examDTO = new ExamDTO(e);
				examDTO.setRegistered(isExamRegistered(studentId, e.getId()));
				exams.add(examDTO);
			}
		}
		
		return exams;
	}
	public List<SubjectDTO> getAllStudentSubjects(int id) {
		List<SubjectDTO> studentSubjectsDTO = new ArrayList<>();
		List<Subject> subjects = subjectRepository.findAll();
		User u = userRepository.getOne(id);
		for (Subject s : subjects) {
			for (Student student : s.getStudents()) {
				if (student.getId() == u.getStudent().getId()) {
					SubjectDTO subjectDTO = new SubjectDTO(s);
					List<ExamDTO> exams = new ArrayList<ExamDTO>();
					boolean passed = isSubjectPassed(student.getId(), s.getId());
					
					if(!passed) {
						exams = getStudentsNextExams(student.getId(), s.getId());
					}
					
					subjectDTO.setPassed(passed);
					subjectDTO.setExams(exams);
					studentSubjectsDTO.add(subjectDTO);
				}
			}
		}
		return studentSubjectsDTO;
	}

	public List<ExamDTO> getProfessorsPastExams(int profId, int subjectId) {
        List<ExamDTO> exams = new ArrayList<ExamDTO>();
        List<Exam> allExams = examRepository.findAll();
        for(Exam e : allExams) {
            if(e.getSubject().getId() == subjectId && e.getDate().compareTo(new Date()) < 0) {
                ExamDTO examDTO = new ExamDTO(e);
                // examDTO.setRegistered(isExamRegistered(studentId, e.getId()));
                exams.add(examDTO);
            }
        }
       
        return exams;
    }
   
 
	public List<SubjectDTO> getAllProfessorSubjects(int id) {
        List<SubjectDTO> professorSubjectsDTO = new ArrayList<>();
        List<Subject> subjects = subjectRepository.findAll();
        User u = userRepository.getOne(id);
        for (Subject s : subjects) {
            for (Professor professor : s.getProfessors()) {
                if (professor.getId() == u.getProfessor().getId()) {
                    SubjectDTO subjectDTO = new SubjectDTO(s);
                    List<ExamDTO> exams = new ArrayList<ExamDTO>();
                    exams = getProfessorsPastExams(professor.getId(), s.getId());
                    subjectDTO.setExams(exams);
                    professorSubjectsDTO.add(subjectDTO);
 
                }
            }
        }
        return professorSubjectsDTO;
    }
}
