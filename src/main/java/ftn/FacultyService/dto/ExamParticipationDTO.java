package ftn.FacultyService.dto;

import ftn.FacultyService.entity.ExamParticipation;

public class ExamParticipationDTO {

	private int id;
	private boolean passed;
	private int grade;
	private double points;
	private ExamDTO exam;
	private StudentDTO student;
	
	
	public ExamParticipationDTO() {
	}

	public ExamParticipationDTO(int id, boolean passed, int grade, double points, ExamDTO exam, StudentDTO student) {
		this.id = id;
		this.passed = passed;
		this.grade = grade;
		this.points = points;
		this.exam = exam;
		this.student = student;
	}
	
	public ExamParticipationDTO(ExamParticipation ep) {
		this(ep.getId(), ep.getPassed(), ep.getGrade(), ep.getPoints(), new ExamDTO(ep.getExam()), new StudentDTO(ep.getStudent()));
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isPassed() {
		return passed;
	}

	public void setPassed(boolean passed) {
		this.passed = passed;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public double getPoints() {
		return points;
	}

	public void setPoints(double points) {
		this.points = points;
	}

	public ExamDTO getExam() {
		return exam;
	}

	public void setExam(ExamDTO exam) {
		this.exam = exam;
	}

	public StudentDTO getStudent() {
		return student;
	}

	public void setStudent(StudentDTO student) {
		this.student = student;
	}
}
