package com.neri.pedro.orderwebapp.modules.payment.repository;

import com.neri.pedro.orderwebapp.comum.repository.JpaBaseRepository;
import com.neri.pedro.orderwebapp.modules.payment.domain.Payment;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PaymentRepository extends JpaBaseRepository<Payment, Long>, JpaSpecificationExecutor<Payment> {
}