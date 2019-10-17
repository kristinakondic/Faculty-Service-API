package ftn.FacultyService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ftn.FacultyService.entity.ExamPeriod;

public interface ExamPeriodRepository extends JpaRepository<ExamPeriod, Integer> {
	
	ExamPeriod findByName(String name);
}
