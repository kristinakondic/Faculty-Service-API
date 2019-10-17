package ftn.FacultyService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ftn.FacultyService.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByEmail(String email);
}
