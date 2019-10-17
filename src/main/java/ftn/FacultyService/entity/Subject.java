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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import ftn.FacultyService.dto.SubjectDTO;

@Entity
@Table(name = "subject")
public class Subject {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "espb")
	private String espb;

	@Column(name = "subject_no")
	private String subjectNo;

	@Column(name = "year")
	private int year;

	@OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY, mappedBy = "subject")
	private Set<Exam> exams = new HashSet<Exam>();

	@ManyToOne
	@JoinColumn(name = "field_id", nullable = true)
	private FieldsOfStudy fieldsOfStudy;

	@ManyToMany(mappedBy = "studentSubjects")
	private Set<Student> students = new HashSet<>();

	@ManyToMany(mappedBy = "subjects")
	private Set<Professor> professors = new HashSet<>();

	public Subject() {

	}

	public Subject(int id, String name, String espb, String subjectNo, int year) {
		super();
		this.id = id;
		this.name = name;
		this.espb = espb;
		this.subjectNo = subjectNo;
		this.year = year;
	}

	public Subject(SubjectDTO subject) {
		this(subject.getId(), subject.getName(), subject.getEspb(), subject.getSubjectNo(), subject.getYear());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEspb() {
		return espb;
	}

	public void setEspb(String espb) {
		this.espb = espb;
	}

	public String getSubjectNo() {
		return subjectNo;
	}

	public void setSubjectNo(String subjectNo) {
		this.subjectNo = subjectNo;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Set<Exam> getExams() {
		return exams;
	}

	public void setExams(Set<Exam> exams) {
		this.exams = exams;
	}

	public FieldsOfStudy getFieldsOfStudy() {
		return fieldsOfStudy;
	}

	public void setFieldsOfStudy(FieldsOfStudy fieldsOfStudy) {
		this.fieldsOfStudy = fieldsOfStudy;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	public Set<Professor> getProfessors() {
		return professors;
	}

	public void setProfessors(Set<Professor> professors) {
		this.professors = professors;
	}

}
