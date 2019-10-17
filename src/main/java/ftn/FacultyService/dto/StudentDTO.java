package ftn.FacultyService.dto;

import ftn.FacultyService.entity.Student;

public class StudentDTO {

	private int id;
	private String indexNo;
	private int yearOfStudy;
	private UserDTO userDTO;

	public StudentDTO() {

	}

	public StudentDTO(int id, String indexNo, int yearOfStudy, UserDTO userDTO) {
		this.id = id;
		this.indexNo = indexNo;
		this.yearOfStudy = yearOfStudy;
		this.userDTO = userDTO;
	}

	public StudentDTO(Student student) {
		this(student.getId(), student.getIndexNo(), student.getYearOfStudy(), new UserDTO(student.getUser()));
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

	public UserDTO getUserDTO() {
		return userDTO;
	}

	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
	}
}
