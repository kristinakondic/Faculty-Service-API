package ftn.FacultyService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ftn.FacultyService.entity.Exam;

public interface ExamRepository extends JpaRepository<Exam, Integer> {
}
