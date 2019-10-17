package ftn.FacultyService.dto;

import java.util.Date;

import ftn.FacultyService.entity.Payment;

public class PaymentDTO {

	private int id;
	private double value;
	private Date date;
	private StudentDTO student;

	public PaymentDTO() {

	}

	public PaymentDTO(int id, double value, Date date, StudentDTO student) {
		super();
		this.id = id;
		this.value = value;
		this.date = date;
		this.student = student;
	}
	
	public PaymentDTO(Payment payment) {
		this(payment.getId(), payment.getValue(), payment.getDate(), new StudentDTO(payment.getStudent()));
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public StudentDTO getStudent() {
		return student;
	}

	public void setStudent(StudentDTO student) {
		this.student = student;
	}
}
