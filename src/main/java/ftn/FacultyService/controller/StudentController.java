package ftn.FacultyService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ftn.FacultyService.dto.MessageDTO;
import ftn.FacultyService.dto.StudentDTO;
import ftn.FacultyService.service.StudentService;

@RestController
@RequestMapping(value = "/api/student")
public class StudentController {

	@Autowired
	StudentService studentService;

	@GetMapping
	@RequestMapping(value = "/{page}/{size}")
	public ResponseEntity<Page<StudentDTO>> getAllPage(@PathVariable("page") Integer page,
			@PathVariable("size") Integer size) {
		Page<StudentDTO> students = studentService.getAllPage(page, size);
		return new ResponseEntity<Page<StudentDTO>>(students, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<StudentDTO> getById(@PathVariable("id") int id) {
		StudentDTO student = studentService.getById(id);
		if (student == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<StudentDTO>(student, HttpStatus.OK);
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<MessageDTO> register(@RequestBody StudentDTO studentDTO) {
		MessageDTO msg = studentService.register(studentDTO);
		if (msg.isSuccess()) {
			return new ResponseEntity<>(msg, HttpStatus.CREATED);
		}
		return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
	}

	@PutMapping(value = "/update")
	public ResponseEntity<HttpStatus> update(@RequestBody StudentDTO studentDTO) {
		if (studentService.updateStudent(studentDTO)) {
			return new ResponseEntity<>(HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") int id) {
		if (studentService.deleteStudent(id)) {
			return new ResponseEntity<>(HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
