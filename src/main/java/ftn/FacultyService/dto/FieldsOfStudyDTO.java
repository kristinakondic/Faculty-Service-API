package ftn.FacultyService.dto;

import ftn.FacultyService.entity.FieldsOfStudy;

public class FieldsOfStudyDTO {

	private int id;
	private String name;
	
	public FieldsOfStudyDTO() {
		
	}
	
	public FieldsOfStudyDTO(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public FieldsOfStudyDTO(FieldsOfStudy fieldsOfStudy) {
		this(fieldsOfStudy.getId(), fieldsOfStudy.getName());
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
}
