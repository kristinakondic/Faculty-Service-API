package ftn.FacultyService.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "document")
public class Document {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "name")
	private String name;

	@Column
	private String type;

	@Lob
	private byte[] data;

	@ManyToOne
	@JoinColumn(name = "student_id", referencedColumnName = "id", nullable = true)
	private Student student;

	public Document(int id, String name, String type, byte[] data, Student student) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.data = data;
		this.student = student;
	}

	public Document(String fileName, String string, byte[] bs, Student student2) {
		this.name = fileName;
		this.type = string;
		this.data = bs;
		this.student = student2;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
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

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
}
