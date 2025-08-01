package com.cg.demoBank.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Document(collection = "transact")
public class Transact {
    @Id
    private String id;
    private int transactionId;
    private String accountId;
    private String transactionType;
    private double amount;
    private String source;
    private String status;
    private String reasonCode;

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
    public String getSource() {
        return source;
    }
    public void setSource(String source) {
        this.source = source;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getReasonCode() {
        return reasonCode;
    }
    public void setReasonCode(String reasonCode) {
        this.reasonCode = reasonCode;
    }
    public LocalDateTime getCreatedAt() {
        return null;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        // Implement if needed
    }
// end of Transact
}
