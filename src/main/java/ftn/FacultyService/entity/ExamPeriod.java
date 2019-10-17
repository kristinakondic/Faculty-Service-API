package ftn.FacultyService.entity;

import java.util.Date;
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

import ftn.FacultyService.dto.ExamPeriodDTO;

@Entity
@Table(name = "exam_period")
public class ExamPeriod {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
	@Column(name = "name")
    private String name;
	
	@Column(name = "start_date")
    private Date startDate;
	
	@Column(name = "end_date")
    private Date endDate;
	
	@OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY, mappedBy = "examPeriod")
	private Set<Exam> exams = new HashSet<Exam>();

	public ExamPeriod() {
	}

	public ExamPeriod(int id, String name, Date startDate, Date endDate) {
		super();
		this.id = id;
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	public ExamPeriod(ExamPeriodDTO examPeriod) {
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

	public Set<Exam> getExams() {
		return exams;
	}

	public void setExams(Set<Exam> exams) {
		this.exams = exams;
	}
}
