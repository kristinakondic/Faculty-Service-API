package ftn.FacultyService.dto;

import java.util.Date;

import ftn.FacultyService.entity.ExamPeriod;

public class ExamPeriodDTO {

	private int id;
	private String name;
	private Date startDate;
	private Date endDate;
	
	public ExamPeriodDTO() {
		
	}

	public ExamPeriodDTO(int id, String name, Date startDate, Date endDate) {
		super();
		this.id = id;
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	public ExamPeriodDTO(ExamPeriod examPeriod) {
		this(examPeriod.getId(), examPeriod.getName(), examPeriod.getStartDate(), examPeriod.getEndDate());
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

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
}
