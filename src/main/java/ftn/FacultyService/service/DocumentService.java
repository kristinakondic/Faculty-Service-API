package ftn.FacultyService.service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import ftn.FacultyService.dto.DocumentDTO;
import ftn.FacultyService.entity.Document;
import ftn.FacultyService.entity.Student;
import ftn.FacultyService.repository.DocumentRepository;

@Service
public class DocumentService {

	@Autowired
	DocumentRepository documentRepository;

	@Autowired
	StudentService studentService;

	public List<DocumentDTO> getAllStudentDocumentsPage(int id) {
		List<Document> d = documentRepository.findByStudent_Id(id);
		List<DocumentDTO> dDTO = d.stream().map(doc -> new DocumentDTO(doc)).collect(Collectors.toList());
		return dDTO;
	}

	public DocumentDTO getById(int id) {
		Document document = documentRepository.getOne(id);
		if (document == null) {
			return null;
		} else {
			return new DocumentDTO(document);
		}
	}

	public Document storeFile(MultipartFile file, int id) throws IOException {

		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		Student student = new Student(studentService.getById(id));

		Document dbFile = new Document(fileName, file.getContentType(), file.getBytes(), student);

		return documentRepository.save(dbFile);
	}

	public Document findByName(String name) {
		return documentRepository.findByName(name);
	}

}
