package com.paf.springboot.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.paf.springboot.model.Payment;
import com.paf.springboot.repository.PaymentRepository;

public class PaymentDAO {
	@Autowired
	PaymentRepository paymentRepository;
	
	/*SAVE AN PAYMENT*/
	@Transactional(readOnly = false,isolation = Isolation.READ_COMMITTED)
	public Payment save(Payment pay) {
		return paymentRepository.save(pay);
	}
	
	
	
    /*SEARCH ALL PAYMENT*/
	public List<Payment> findAll(){
		return paymentRepository.findAll();
		
	}
	
	
	/* GET AN PAYMENT*/
	public Payment findOne(Long  pid) {
		Optional<Payment> op = paymentRepository.findById(pid);
		if(op.isPresent()) {
			return op.get();
			}
			else {
			return null;
			//@Transactional(readOnly = false,isolation = Isolation.READ_COMMITTED)
			}
	}
	
	/*DELETE AN PAYMENT*/
	public void delete(Payment payment) {
		paymentRepository.delete(payment);
		}
}
