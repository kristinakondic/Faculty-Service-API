package ftn.FacultyService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ftn.FacultyService.entity.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Integer> {

}
