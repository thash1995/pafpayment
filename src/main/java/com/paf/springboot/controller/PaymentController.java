package com.paf.springboot.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paf.springboot.dao.PaymentDAO;
import com.paf.springboot.model.Payment;

@RestController
@RequestMapping("/payment")
public class PaymentController {
	@Autowired
	PaymentDAO paymentDAO;
	
	/*to save an payment*/
	@PostMapping("/payments")
	public Payment createPayment(@Valid @RequestBody Payment pay) {
		return paymentDAO.save(pay);
	}
	/*get all payments*/
	@GetMapping("/payments")
	public List<Payment> getAllPayments(){
		return paymentDAO.findAll();
	}
	/*get payments by pid*/
	@GetMapping("/notes/{id}")
	public ResponseEntity<Payment> getPaymentById(@PathVariable(value="id") Long pid){
		Payment pay = paymentDAO.findOne(pid);
		if(pay==null) {
		return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(pay);
		
	}
	
	/*update payment*/
	@PutMapping("/payments/{id}")
	public ResponseEntity<Payment> updatePayment(@PathVariable(value="id") Long pid,
			@Valid @RequestBody Payment payDetails){
		Payment pay=paymentDAO.findOne(pid);
		if(pay==null) {
		return ResponseEntity.notFound().build();
		}
		pay.setCustomer_number(payDetails.getCustomer_number());
		pay.setDescription(payDetails.getDescription());
		pay.setDate(payDetails.getDate());
		//pay.setDate(payDetails.getDate());
		pay.setAmount(payDetails.getAmount());
		pay.setQuanty(payDetails.getQuanty());
		
		Payment updaPayment=paymentDAO.save(pay);
		return ResponseEntity.ok().body(updaPayment);
		
	}
	/*delete payment*/
	
	@DeleteMapping("/payments/{id}")
	public ResponseEntity<Payment> deletePayment(@PathVariable(value="id") Long pid){
	Payment pay = paymentDAO.findOne(pid);
	if(pay==null) {
	return ResponseEntity.notFound().build();
	}
	paymentDAO.delete(pay);
	return ResponseEntity.ok().build();
	}
	
}
