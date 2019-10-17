package ftn.FacultyService.dto;

import java.util.Date;

import ftn.FacultyService.entity.Exam;
import ftn.FacultyService.entity.TypeOfExam;

public class ExamDTO {

	private int id;
	private TypeOfExam type;
	private String classroom;
	private Date date;
	private SubjectDTO subjectDTO;
	private ExamPeriodDTO examPeriodDTO;
	private boolean registered;
	
	public ExamDTO() {
		
	}

	public ExamDTO(int id, TypeOfExam type, String classroom, Date date, SubjectDTO subject, ExamPeriodDTO examPeriod) {
		super();
		this.id = id;
		this.type = type;
		this.classroom = classroom;
		this.date = date;
		this.subjectDTO = subject;
		this.examPeriodDTO = examPeriod;
	}
	
	public ExamDTO(Exam exam) {
		this(exam.getId(), exam.getType(), exam.getClassroom(), exam.getDate(), new SubjectDTO(exam.getSubject()), new ExamPeriodDTO(exam.getExamPeriod()));
	}

	public int getId() {
		return id;
	}

	
	public boolean isRegistered() {
		return registered;
	}

	public void setRegistered(boolean registered) {
		this.registered = registered;
	}

	public void setId(int id) {
		this.id = id;
	}

	public TypeOfExam getType() {
		return type;
	}

	public void setType(TypeOfExam type) {
		this.type = type;
	}

	public String getClassroom() {
		return classroom;
	}

	public void setClassroom(String classroom) {
		this.classroom = classroom;
	}

	public SubjectDTO getSubject() {
		return subjectDTO;
	}

	public void setSubject(SubjectDTO subject) {
		this.subjectDTO = subject;
	}

	public ExamPeriodDTO getExamPeriod() {
		return examPeriodDTO;
	}

	public void setExamPeriod(ExamPeriodDTO examPeriod) {
		this.examPeriodDTO = examPeriod;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
