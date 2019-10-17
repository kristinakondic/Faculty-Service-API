package ftn.FacultyService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ftn.FacultyService.entity.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Integer> {
	Subject findByName(String name);

}