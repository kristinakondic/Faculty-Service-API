package ftn.FacultyService.entity;

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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import ftn.FacultyService.dto.StudentDTO;

@Entity
@Table(name = "student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "index_no")
	private String indexNo;

	@Column(name = "year_of_study")
	private int yearOfStudy;

	@OneToOne(mappedBy = "student")
	private User user;

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "student_subject", joinColumns = @JoinColumn(name = "student_id"), inverseJoinColumns = @JoinColumn(name = "subject_id"))
	private Set<Subject> studentSubjects = new HashSet<>();

	@OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY, mappedBy = "student")
	private Set<ExamParticipation> examsParticipation = new HashSet<ExamParticipation>();

	@OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY, mappedBy = "student")
	private Set<Document> documents = new HashSet<Document>();

	@OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY, mappedBy = "student")
	private Set<Payment> payments = new HashSet<Payment>();

	public Student() {
	}

	public Student(int id, String indexNo, int yearOfStudy, User user) {
		this.id = id;
		this.indexNo = indexNo;
		this.yearOfStudy = yearOfStudy;
		this.user = user;
	}

	public Student(StudentDTO studentDTO) {
		this(studentDTO.getId(), studentDTO.getIndexNo(), studentDTO.getYearOfStudy(), new User(studentDTO.getUserDTO()));
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIndexNo() {
		return indexNo;
	}

	public void setIndexNo(String indexNo) {
		this.indexNo = indexNo;
	}

	public int getYearOfStudy() {
		return yearOfStudy;
	}

	public void setYearOfStudy(int yearOfStudy) {
		this.yearOfStudy = yearOfStudy;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<Subject> getStudentSubjects() {
		return studentSubjects;
	}

	public void setStudentSubjects(Set<Subject> studentSubjects) {
		this.studentSubjects = studentSubjects;
	}

	public Set<ExamParticipation> getExamsParticipation() {
		return examsParticipation;
	}

	public void setExamsParticipation(Set<ExamParticipation> examsParticipation) {
		this.examsParticipation = examsParticipation;
	}

	public Set<Document> getDokuments() {
		return documents;
	}

	public void setDokuments(Set<Document> dokuments) {
		this.documents = dokuments;
	}

	public Set<Payment> getPayments() {
		return payments;
	}

	public void setPayments(Set<Payment> payments) {
		this.payments = payments;
	}
}
