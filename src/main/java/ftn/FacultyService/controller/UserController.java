package ftn.FacultyService.controller;

import java.security.Principal;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ftn.FacultyService.dto.ChangePasswordDTO;
import ftn.FacultyService.dto.LoginDTO;
import ftn.FacultyService.dto.UserDTO;
import ftn.FacultyService.service.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/api/user")
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping
	public ResponseEntity<List<UserDTO>> getAll(Principal principal) {
		if (principal == null) {
			return new ResponseEntity<List<UserDTO>>(HttpStatus.NOT_FOUND);
		}
		List<UserDTO> users = userService.getUsers();
		if (users == null)
			return new ResponseEntity<List<UserDTO>>(HttpStatus.FORBIDDEN);
		return new ResponseEntity<List<UserDTO>>(users, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{email}")
	public ResponseEntity<UserDTO> getUser(@PathVariable("email") String email) {
		UserDTO user = userService.getUser(email);
		if (user == null)
			return new ResponseEntity<UserDTO>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<UserDTO>(user, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<Map<String, Object>> login(@RequestBody LoginDTO loginDTO) {
		return Optional.ofNullable(userService.login(loginDTO))
				.map(cookie -> new ResponseEntity<Map<String, Object>>(cookie, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.UNAUTHORIZED));
	}
	
	@PutMapping(value = "/changePass")
	public ResponseEntity<HttpStatus> changePass(@RequestBody ChangePasswordDTO changePassDTO) {
		if (userService.changePass(changePassDTO)) {
			return new ResponseEntity<>(HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
