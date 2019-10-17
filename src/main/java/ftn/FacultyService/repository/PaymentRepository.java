package ftn.FacultyService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ftn.FacultyService.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer>  {

	
}
