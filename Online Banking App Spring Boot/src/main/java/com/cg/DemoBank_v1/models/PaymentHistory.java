package com.cg.demoBank.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Document(collection = "payment_history")
public class PaymentHistory {
    @Id
    private String id;
    private int paymentId;
    private String accountId;
    private String beneficiary;
    private String beneficiaryAccNo;
    private double amount;
    private String referenceNo;
    private String status;
    private String reasonCode;
    private LocalDateTime createdAt;

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getBeneficiary() {
        return beneficiary;
    }

    public void setBeneficiary(String beneficiary) {
        this.beneficiary = beneficiary;
    }

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
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
// end of PaymentHistory
}
