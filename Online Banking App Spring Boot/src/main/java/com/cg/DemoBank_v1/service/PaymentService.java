package com.cg.demoBank.service;

import com.cg.demoBank.models.PaymentHistory;
import com.cg.demoBank.repository.PaymentHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PaymentService {
    @Autowired
    private PaymentHistoryRepository paymentHistoryRepository;

    public void makePayment(String accountId, String beneficiary, String accountNumber, double amount, String reference, String status, String reasonCode, LocalDateTime createdAt) {
        PaymentHistory payment = new PaymentHistory();
        payment.setAccountId(accountId);
        payment.setBeneficiary(beneficiary);
        payment.setBeneficiaryAccNo(accountNumber);
        payment.setAmount(amount);
        payment.setReferenceNo(reference);
        payment.setStatus(status);
        payment.setReasonCode(reasonCode);
        payment.setCreatedAt(createdAt);
        paymentHistoryRepository.save(payment);
    }
}
