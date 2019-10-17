package ftn.FacultyService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ftn.FacultyService.dto.ExamDTO;
import ftn.FacultyService.dto.ExamParticipationDTO;
import ftn.FacultyService.service.ExamParticipationService;

@RestController
@RequestMapping(value = "/api/examParticipation")
public class ExamParticipationController {

	@Autowired
	ExamParticipationService examParticipationService;
	
	@PostMapping(value = "/register")
	public ResponseEntity<ExamDTO> registerExam(@RequestBody ExamParticipationDTO examParticipationDTO) {
		if (examParticipationService.register(examParticipationDTO)) {
			return new ResponseEntity<>(HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping
	@RequestMapping(value = "/{examId}")
	public ResponseEntity<List<ExamParticipationDTO>> getExamParticipations(@PathVariable("examId") int examId) {
		List<ExamParticipationDTO> examPart = examParticipationService.getExamParticipations(examId);
		return new ResponseEntity<List<ExamParticipationDTO>>(examPart, HttpStatus.OK);
	}
	
	
}
