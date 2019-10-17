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

import ftn.FacultyService.dto.ExamDTO;
import ftn.FacultyService.service.ExamService;

@RestController
@RequestMapping(value = "/api/exam")
public class ExamController {

	@Autowired
	ExamService examService;

	@GetMapping
	@RequestMapping(value = "/{page}/{size}")
	public ResponseEntity<Page<ExamDTO>> getAllPage(@PathVariable("page") Integer page,
			@PathVariable("size") Integer size) {
		Page<ExamDTO> exams = examService.getAllPage(page, size);
		return new ResponseEntity<Page<ExamDTO>>(exams, HttpStatus.OK);
	}

	@PostMapping(value = "/add")
	public ResponseEntity<ExamDTO> addExam(@RequestBody ExamDTO examDTO) {
		if (examService.addExam(examDTO)) {
			return new ResponseEntity<>(HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping(value = "/update")
	public ResponseEntity<HttpStatus> update(@RequestBody ExamDTO examDTO) {
		if (examService.updateExam(examDTO)) {
			return new ResponseEntity<>(HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") int id) {
		if (examService.deleteExam(id)) {
			return new ResponseEntity<>(HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping
	@RequestMapping(value = "/professorExams/{professorId}")
	public ResponseEntity<List<ExamDTO>> getProfessorExams(@PathVariable("professorId") int id) {
		List<ExamDTO> exams = examService.getAllProfesorExams(id);
		return new ResponseEntity<List<ExamDTO>>(exams, HttpStatus.OK);
	}

	@GetMapping
	@RequestMapping(value = "/professorTests/{professorId}")
	public ResponseEntity<List<ExamDTO>> getProfessorTests(@PathVariable("professorId") int id) {
		List<ExamDTO> exams = examService.getAllProfesorTests(id);
		return new ResponseEntity<List<ExamDTO>>(exams, HttpStatus.OK);
	}
	
	@GetMapping
	@RequestMapping(value = "/unreviewedExams/{professorId}")
	public ResponseEntity<List<ExamDTO>> getUnreviewedExams(@PathVariable("professorId") int id) {
		List<ExamDTO> exams = examService.getUnreviewedExams(id);
		return new ResponseEntity<List<ExamDTO>>(exams, HttpStatus.OK);
	}
	
}
