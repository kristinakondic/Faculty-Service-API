package ftn.FacultyService.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ftn.FacultyService.dto.ChangePasswordDTO;
import ftn.FacultyService.dto.LoginDTO;
import ftn.FacultyService.dto.UserDTO;
import ftn.FacultyService.entity.User;
import ftn.FacultyService.repository.UserRepository;
import ftn.FacultyService.security.TokenUtils;

@Service
public class UserService {
	@Autowired
	UserRepository userRepo;

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserDetailsService userDetailsService;

	@Autowired
	TokenUtils tokenUtils;

	public List<UserDTO> getUsers() {
		List<UserDTO> users = userRepo.findAll().stream().map(user -> new UserDTO(user)).collect(Collectors.toList());
		return users;
	}

	public Map<String, Object> login(LoginDTO loginDTO) {
		Map<String, Object> cookie = new HashMap<>();

		try {
			UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(loginDTO.getEmail(),
					loginDTO.getPassword());
			Authentication authentication = authenticationManager.authenticate(token);
			SecurityContextHolder.getContext().setAuthentication(authentication);

			UserDetails details = userDetailsService.loadUserByUsername(loginDTO.getEmail());

			cookie.put("jwt", tokenUtils.generateToken(details));

			return cookie;
		} catch (NullPointerException nullException) {
			System.out.println("User doesn't exist.");
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return null;
	}
	
	public UserDTO getUser(String email) {
		User u = userRepo.findByEmail(email);
		if (u == null)
			return null;
		else
			return new UserDTO(u);
	}

	public boolean changePass(ChangePasswordDTO changePassDTO) {
		User u = userRepo.findByEmail(changePassDTO.getUserEmail());
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		if(encoder.matches(changePassDTO.getOldPassword(), u.getPassword())) {
			String newPass = encoder.encode(changePassDTO.getNewPassword());
			u.setPassword(newPass);
			userRepo.save(u);
			return true;
		}
		else {
			return false;
		}
	}
}
