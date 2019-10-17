package ftn.FacultyService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ftn.FacultyService.dto.SubjectDTO;
import ftn.FacultyService.service.SubjectService;

@RestController
@RequestMapping(value = "/api/subject")
public class SubjectController {

	@Autowired
	SubjectService subjectService;

	@GetMapping
	@RequestMapping(value = "/{page}/{size}")
	public ResponseEntity<Page<SubjectDTO>> getAllPage(@PathVariable("page") Integer page,
			@PathVariable("size") Integer size) {
		Page<SubjectDTO> subjects = subjectService.getAllPage(page, size);
		return new ResponseEntity<Page<SubjectDTO>>(subjects, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<SubjectDTO> getById(@PathVariable("id") int id) {
		SubjectDTO subject = subjectService.getById(id);
		if (subject == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<SubjectDTO>(subject, HttpStatus.OK);
	}

	@PostMapping(value = "/add")
	public ResponseEntity<SubjectDTO> addSubject(@RequestBody SubjectDTO subjectDTO) {
		if (subjectService.addSubject(subjectDTO)) {
			return new ResponseEntity<>(HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping(value = "/update")
	public ResponseEntity<HttpStatus> update(@RequestBody SubjectDTO subjectDTO) {
		if (subjectService.updateSubject(subjectDTO)) {
			return new ResponseEntity<>(HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") int id) {
		if (subjectService.deleteSubject(id)) {
			return new ResponseEntity<>(HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping(value = "/student/{id}")
	public ResponseEntity<List<SubjectDTO>> getAllStudentSubjects(@PathVariable("id") int id) {
		List<SubjectDTO> subjects = subjectService.getAllStudentSubjects(id);
		return new ResponseEntity<List<SubjectDTO>>(subjects, HttpStatus.OK);
	}

	
	@GetMapping(value = "/professor/{id}")
	public ResponseEntity<List<SubjectDTO>> getAllProfessorSubjects(@PathVariable("id") int id) {
		List<SubjectDTO> subjects = subjectService.getAllProfessorSubjects(id);
		return new ResponseEntity<List<SubjectDTO>>(subjects, HttpStatus.OK);
	}
	
}
