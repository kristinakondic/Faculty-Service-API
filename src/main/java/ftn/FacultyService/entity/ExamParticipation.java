package ftn.FacultyService.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "exam_participation")
public class ExamParticipation {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
	@Column(name = "passed")
    private Boolean passed;
	
	@Column(name = "grade")
    private int grade;
	
	@Column(name = "points")
    private double points;
	
	@ManyToOne
	@JoinColumn(name = "exam_id", referencedColumnName = "id", nullable = true)
	private Exam exam;
	
	@ManyToOne
	@JoinColumn(name = "student_id", referencedColumnName = "id", nullable = true)
	private Student student;

	public ExamParticipation() {
		super();
	}

	public ExamParticipation(int id, Boolean passed, int grade, double points, Exam exam, Student student) {
		super();
		this.id = id;
		this.passed = passed;
		this.grade = grade;
		this.points = points;
		this.exam = exam;
		this.student = student;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Boolean getPassed() {
		return passed;
	}

	public void setPassed(Boolean passed) {
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

	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
}
