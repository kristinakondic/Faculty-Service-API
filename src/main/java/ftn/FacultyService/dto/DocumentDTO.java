package ftn.FacultyService.dto;

import ftn.FacultyService.entity.Document;

public class DocumentDTO {

	private int id;
	private String name;
	private StudentDTO studentDTO;
	
	public DocumentDTO() {
		
	}

	public DocumentDTO(int id, String name, StudentDTO studentDTO) {
		super();
		this.id = id;
		this.name = name;
		this.studentDTO = studentDTO;
	}
	
	public DocumentDTO(Document document) {
		this(document.getId(), document.getName(), new StudentDTO(document.getStudent()));
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

	public StudentDTO getStudentDTO() {
		return studentDTO;
	}

	public void setStudentDTO(StudentDTO studentDTO) {
		this.studentDTO = studentDTO;
	}
}
