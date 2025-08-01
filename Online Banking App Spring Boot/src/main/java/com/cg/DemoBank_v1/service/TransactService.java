package com.cg.demoBank.service;

import com.cg.demoBank.models.Transact;
import com.cg.demoBank.repository.TransactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TransactService {
    @Autowired
    private TransactRepository transactRepository;

    public void logTransaction(String accountId, String transactionType, double amount, String source, String status, String reasonCode, LocalDateTime createdAt) {
        Transact transact = new Transact();
        transact.setAccountId(accountId);
        transact.setTransactionType(transactionType);
        transact.setAmount(amount);
        transact.setSource(source);
        transact.setStatus(status);
        transact.setReasonCode(reasonCode);
        transact.setCreatedAt(createdAt);
        transactRepository.save(transact);
    }
}
