package ftn.FacultyService.dto;

import java.util.Date;

import ftn.FacultyService.entity.Role;
import ftn.FacultyService.entity.User;

public class UserDTO {
	private int id;
	private String name;
	private String surname;
	private String email;
	private String password;
	private Date creationDate;
	private Role role;
	private String identityNo;
	private String address;

	public UserDTO() {

	}

	public UserDTO(int id, String name, String surname, String email, String password, Date creationDate, Role role,
			String identityNo, String address) {
		super();
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

	public UserDTO(User user) {
		this(user.getId(), user.getName(), user.getSurname(), user.getEmail(), user.getPassword(),
				user.getCreationDate(), user.getRole(), user.getIdentityNo(), user.getAddress());
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
}
