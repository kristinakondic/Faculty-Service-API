package ftn.FacultyService.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import ftn.FacultyService.dto.UserDTO;

@Entity
@Table(name = "user")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "surname")
	private String surname;

	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;

	@Column(name = "creation_date")
	private Date creationDate;

	@Column(name = "role")
	private Role role;

	@Column(name = "identity_no")
	private String identityNo;

	@Column(name = "address")
	private String address;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "student_id", referencedColumnName = "id")
	private Student student;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "professor_id", referencedColumnName = "id")
	private Professor professor;

	public User() {
	}

	public User(int id, String name, String surname, String email, String password, Date creationDate, Role role,
			String identityNo, String address) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
		this.creationDate = creationDate;
		this.role = role;
		this.identityNo = identityNo;
		this.address = address;
	}

	public User(UserDTO userDTO) {
		this(userDTO.getId(), userDTO.getName(), userDTO.getSurname(), userDTO.getEmail(), userDTO.getPassword(),
				userDTO.getCreationDate(), userDTO.getRole(), userDTO.getIdentityNo(), userDTO.getAddress());
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

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getIdentityNo() {
		return identityNo;
	}

	public void setIdentityNo(String identityNo) {
		this.identityNo = identityNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
}
