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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import ftn.FacultyService.dto.FieldsOfStudyDTO;

@Entity
@Table(name = "fields_of_study")
public class FieldsOfStudy {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "name")
	private String name;

	@OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY, mappedBy = "fieldsOfStudy")
	private Set<Subject> subjects = new HashSet<Subject>();

	public FieldsOfStudy() {
	}

	public FieldsOfStudy(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public FieldsOfStudy(FieldsOfStudyDTO fieldsOfStudyDTO) {
		this(fieldsOfStudyDTO.getId(), fieldsOfStudyDTO.getName());
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

	public Set<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(Set<Subject> subjects) {
		this.subjects = subjects;
	}

}
