package ftn.FacultyService.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.FacultyService.dto.ExamPeriodDTO;
import ftn.FacultyService.entity.ExamPeriod;
import ftn.FacultyService.repository.ExamPeriodRepository;

@Service
public class ExamPeriodService {

	@Autowired
	ExamPeriodRepository examPeriodRepo;
	
	public List<ExamPeriodDTO> getAll() {
		List<ExamPeriod> f = examPeriodRepo.findAll();
		List<ExamPeriodDTO> fDTO = f.stream().map(fos -> new ExamPeriodDTO(fos)).collect(Collectors.toList());
		return fDTO;
	}

}
