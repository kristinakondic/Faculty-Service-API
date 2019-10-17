package ftn.FacultyService.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import ftn.FacultyService.dto.DocumentDTO;
import ftn.FacultyService.entity.Document;
import ftn.FacultyService.entity.UploadFileResponse;
import ftn.FacultyService.service.DocumentService;

@RestController
@RequestMapping(value = "/api/document")
@CrossOrigin(origins = "http://localhost:4200")
public class DocumentController {

	@Autowired
	DocumentService documentService;

	@GetMapping
	@RequestMapping(value = "/{id}")
	public ResponseEntity<List<DocumentDTO>> getAllPage(@PathVariable("id") int id) {
		List<DocumentDTO> documents = documentService.getAllStudentDocumentsPage(id);
		return new ResponseEntity<List<DocumentDTO>>(documents, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<DocumentDTO> getById(@PathVariable("id") int id) {
		DocumentDTO document = documentService.getById(id);
		if (document == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<DocumentDTO>(document, HttpStatus.OK);
	}

	@PostMapping("/upload/{id}")
	public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file, @PathVariable("id") int id)
			throws IOException {
		Document dbFile = documentService.storeFile(file, id);

		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/downloadFile/")
				.path(String.valueOf(dbFile.getId())).toUriString();

		return new UploadFileResponse(dbFile.getName(), fileDownloadUri, file.getContentType(), file.getSize());
	}

	@GetMapping("/download/{name}")
	public ResponseEntity<byte[]> getFile(@PathVariable String name) {
		Document fileOptional = documentService.findByName(name);

		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileOptional.getName() + "\"")
				.body(fileOptional.getData());

	}
}
