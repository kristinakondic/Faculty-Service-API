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
import ftn.FacultyService.dto.ProfessorDTO;
import ftn.FacultyService.service.ProfessorService;

@RestController
@RequestMapping(value = "/api/professor")
public class ProfessorController {

	@Autowired
	ProfessorService professorService;
	
	@GetMapping
	@RequestMapping(value = "/{page}/{size}")
    public ResponseEntity<Page<ProfessorDTO>> getAllPage(@PathVariable("page") Integer page,
			@PathVariable("size") Integer size) {
        Page<ProfessorDTO> professors = professorService.getAllPage(page, size);
        return new ResponseEntity<Page<ProfessorDTO>>(professors, HttpStatus.OK);
    }
	
	@GetMapping(value = "/{id}")
    public ResponseEntity<ProfessorDTO> getById(@PathVariable("id") int id){
		ProfessorDTO professor = professorService.getById(id);
        if(professor == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<ProfessorDTO>(professor, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/register", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<MessageDTO> register(@RequestBody ProfessorDTO professorDTO) {
		MessageDTO msg = professorService.register(professorDTO);
		if (msg.isSuccess()) {
			return new ResponseEntity<>(msg, HttpStatus.CREATED);
		}
		return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
	}
	
	@PutMapping(value = "/update")
	public ResponseEntity<HttpStatus> update(@RequestBody ProfessorDTO professorDTO) {
    	if(professorService.updateProfessor(professorDTO)) {
    		return new ResponseEntity<>(HttpStatus.CREATED);
    	}
    	else {
    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	}
    }
	
	@DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int id) {
    	if(professorService.deleteProfessor(id)) {
    		return new ResponseEntity<>(HttpStatus.CREATED);
    	}
    	else {
    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	}
    }
}