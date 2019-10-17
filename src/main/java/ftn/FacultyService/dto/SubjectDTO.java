package ftn.FacultyService.dto;

import java.util.List;

import ftn.FacultyService.entity.Subject;

public class SubjectDTO {

	private int id;
	private String name;
	private String espb;
	private String subjectNo;
	private int year;
	private FieldsOfStudyDTO fieldsOfStudyDTO;
	private boolean passed;
	private List<ExamDTO> exams;
	
	public SubjectDTO() {
		
	}
	
	public SubjectDTO(int id, String name, String espb, String subjectNo, int year, FieldsOfStudyDTO fieldsOfStudyDTO, boolean passed) {
		super();
		this.id = id;
		this.name = name;
		this.espb = espb;
		this.subjectNo = subjectNo;
		this.year = year;
		this.fieldsOfStudyDTO = fieldsOfStudyDTO;
		this.passed = passed;
	}
	
	public SubjectDTO(Subject subject) {
		this(subject.getId(),subject.getName(), subject.getEspb(), subject.getSubjectNo(), subject.getYear(), new FieldsOfStudyDTO(subject.getFieldsOfStudy()), false);
	}
	
	
	
	
	public List<ExamDTO> getExams() {
		return exams;
	}

	public void setExams(List<ExamDTO> exams) {
		this.exams = exams;
	}

	public boolean isPassed() {
		return passed;
	}

	public void setPassed(boolean passed) {
		this.passed = passed;
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

	public FieldsOfStudyDTO getFieldsOfStudyDTO() {
		return fieldsOfStudyDTO;
	}

	public void setFieldsOfStudyDTO(FieldsOfStudyDTO fieldsOfStudyDTO) {
		this.fieldsOfStudyDTO = fieldsOfStudyDTO;
	}
}
