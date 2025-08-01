package com.cg.demoBank.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Document(collection = "payments")
public class Payment {

    @Id
    private String id;
    private int paymentId;
    private int accountId;
    private String beneficiary;
    private String beneficiaryAccNo;
    private double amount;
    private String referenceNo;
    private String status;
    private String reasonCode;
    private LocalDateTime createdAt;

    // removed old snake_case getter/setter for payment_id
    // removed old snake_case getter/setter for account_id

    public String getBeneficiaryAccNo() {
        return beneficiaryAccNo;
    }

    public void setBeneficiaryAccNo(String beneficiaryAccNo) {
        this.beneficiaryAccNo = beneficiaryAccNo;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getReferenceNo() {
        return referenceNo;
    }

    public void setReferenceNo(String referenceNo) {
        this.referenceNo = referenceNo;
    }
    // ...existing code...
}
