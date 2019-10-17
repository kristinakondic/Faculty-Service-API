package ftn.FacultyService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ftn.FacultyService.entity.Document;

public interface DocumentRepository extends JpaRepository<Document, Integer> {

	Document findByName(String name);
	List<Document> findByStudent_Id(int id);
}
