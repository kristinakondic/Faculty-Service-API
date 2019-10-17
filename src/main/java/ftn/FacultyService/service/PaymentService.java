package ftn.FacultyService.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import ftn.FacultyService.dto.PaymentDTO;
import ftn.FacultyService.entity.Payment;
import ftn.FacultyService.entity.Student;
import ftn.FacultyService.entity.User;
import ftn.FacultyService.repository.PaymentRepository;
import ftn.FacultyService.repository.UserRepository;

@Service
public class PaymentService {

	@Autowired
	PaymentRepository paymentRepository;
	
	@Autowired
	UserRepository userRepository;
	
	public Page<PaymentDTO> getAllStudnetPaymentsPage(Integer page, Integer size, int id) {
		PageRequest pr = PageRequest.of(page, size);
		Page<Payment> p = paymentRepository.findAll(pr);
		Page<PaymentDTO> pDTO = null;
		User u = userRepository.getOne(id);
		System.out.println(u.getStudent().getId());
		for(Payment sp : p) {
			System.out.println(u.getStudent().getId());
			if(sp.getStudent().getId() == u.getStudent().getId()) {
				System.out.println("id od studenta "+u.getStudent().getId());
				pDTO = p.map(PaymentDTO::new);
			}
		}
		return pDTO;
	}

	public boolean addPayment(PaymentDTO paymentDTO) {
		if(paymentDTO != null) {
			Payment p = new Payment();
			p.setValue(paymentDTO.getValue());
			p.setDate(new Date());
			p.setStudent(new Student(paymentDTO.getStudent()));
			paymentRepository.save(p);
			return true;
		}
		else {
			return false;
		}
	}

}
