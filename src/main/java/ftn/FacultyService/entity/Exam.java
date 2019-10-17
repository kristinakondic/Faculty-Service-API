package ftn.FacultyService.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "exam")
public class Exam {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
	@Column(name = "type")
    private TypeOfExam type;
	
	@Column(name = "classroom")
    private String classroom;
	
	@Column(name = "date")
	private Date date;
	
	@ManyToOne
	@JoinColumn(name = "subject_id", referencedColumnName = "id", nullable = true)
	private Subject subject;
	
	@ManyToOne
	@JoinColumn(name = "exam_period_id", referencedColumnName = "id", nullable = true)
	private ExamPeriod examPeriod;
	
	@OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY, mappedBy = "exam")
	private Set<ExamParticipation> examParticipations = new HashSet<ExamParticipation>();

	public Exam() {
	}

	public Exam(int id, TypeOfExam type, String classroom, Date date, Subject subject, ExamPeriod examPeriod) {
		super();
		this.id = id;
		this.type = type;
		this.classroom = classroom;
		this.date = date;
		this.subject = subject;
		this.examPeriod = examPeriod;
	}

	public int getId() {
		return id;
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

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public ExamPeriod getExamPeriod() {
		return examPeriod;
	}

	public void setExamPeriod(ExamPeriod examPeriod) {
		this.examPeriod = examPeriod;
	}

	public Set<ExamParticipation> getExamParticipations() {
		return examParticipations;
	}

	public void setExamParticipations(Set<ExamParticipation> examParticipations) {
		this.examParticipations = examParticipations;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
