package com.paf.springboot.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.paf.springboot.model.Payment;


public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
