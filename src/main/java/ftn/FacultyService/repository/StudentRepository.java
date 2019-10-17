package ftn.FacultyService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ftn.FacultyService.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}