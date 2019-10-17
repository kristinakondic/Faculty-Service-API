package ftn.FacultyService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ftn.FacultyService.dto.ExamPeriodDTO;
import ftn.FacultyService.service.ExamPeriodService;

@RestController
@RequestMapping(value = "/api/examPeriod")
public class ExamPeriodContoller {

	@Autowired
	ExamPeriodService examPeriodService;
	
	@GetMapping
	public ResponseEntity<List<ExamPeriodDTO>> getAll() {
		List<ExamPeriodDTO> examPeriods = examPeriodService.getAll();
		return new ResponseEntity<List<ExamPeriodDTO>>(examPeriods, HttpStatus.OK);
	}
}
