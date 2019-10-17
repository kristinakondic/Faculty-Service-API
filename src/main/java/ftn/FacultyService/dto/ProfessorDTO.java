package ftn.FacultyService.dto;

import ftn.FacultyService.entity.Professor;

public class ProfessorDTO {

	private int id;
	private String type;
	private UserDTO user;

	public ProfessorDTO(int id, String type, UserDTO user) {
		this.id = id;
		this.type = type;
		this.user = user;
	}

	public ProfessorDTO() {

	}
	
	public ProfessorDTO(Professor professor) {
		this(professor.getId(), professor.getType(), new UserDTO(professor.getUser()));
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public UserDTO getUserDTO() {
		return user;
	}

	public void setUserDTO(UserDTO userDTO) {
		this.user = userDTO;
	}
}
