package ftn.FacultyService.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.FacultyService.dto.FieldsOfStudyDTO;
import ftn.FacultyService.entity.FieldsOfStudy;
import ftn.FacultyService.repository.FieldsOfStudyRepository;

@Service
public class FieldsOfStudyService {

	@Autowired 
	FieldsOfStudyRepository fieldsOfStudyRepository;
	
	public List<FieldsOfStudyDTO> getAll() {
		List<FieldsOfStudy> f = fieldsOfStudyRepository.findAll();
		List<FieldsOfStudyDTO> fDTO = f.stream().map(fos -> new FieldsOfStudyDTO(fos)).collect(Collectors.toList());
		return fDTO;
	}
}
