package ftn.FacultyService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ftn.FacultyService.dto.FieldsOfStudyDTO;
import ftn.FacultyService.service.FieldsOfStudyService;

@RestController
@RequestMapping(value = "/api/fieldsOfStudy")
public class FieldsOfStudyController {

	@Autowired
	FieldsOfStudyService fieldsOfStudyService;
	
	@GetMapping
	public ResponseEntity<List<FieldsOfStudyDTO>> getAll() {
		List<FieldsOfStudyDTO> fieldsOfStudy = fieldsOfStudyService.getAll();
		return new ResponseEntity<List<FieldsOfStudyDTO>>(fieldsOfStudy, HttpStatus.OK);
	}
}
