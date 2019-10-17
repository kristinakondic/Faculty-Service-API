package ftn.FacultyService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ftn.FacultyService.dto.PaymentDTO;
import ftn.FacultyService.service.PaymentService;

@RestController
@RequestMapping(value = "/api/payment")
public class PaymentContorller {

	@Autowired
	PaymentService paymentService;
	
	@GetMapping
	@RequestMapping(value = "/{page}/{size}/{id}")
    public ResponseEntity<Page<PaymentDTO>> getAllStudnetsPaymentsPage(@PathVariable("page") Integer page,
			@PathVariable("size") Integer size, @PathVariable("id") int id) {
        Page<PaymentDTO> studentPayments = paymentService.getAllStudnetPaymentsPage(page, size, id);
        return new ResponseEntity<Page<PaymentDTO>>(studentPayments, HttpStatus.OK);
    }
	
	@PostMapping(value = "/add")
	public ResponseEntity<PaymentDTO> addPayment(@RequestBody PaymentDTO paymentDTO){
		if(paymentService.addPayment(paymentDTO)) {
    		return new ResponseEntity<>(HttpStatus.CREATED);
    	}
    	else {
    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	}
	}
}
