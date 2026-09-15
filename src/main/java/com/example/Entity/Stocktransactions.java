package com.example.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "stock_transactions")
public class Stocktransactions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private int transactionId;

    @Column(name = "medicine_id")
    private int medicineId;

    @Column(name = "batch_id")
    private int batchId;

    @Column(name = "transaction_type")
    private String transactionType;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "reference_type")
    private String referenceType;

    @Column(name = "reference_id")
    private int referenceId;

    @Column(name = "transaction_date")
    private LocalDateTime transactionDate;

    @Column(name = "notes")
    private String notes;

    @Column(name = "created_by")
    private int createdBy;


    // Default Constructor
    public Stocktransactions() {
    }


    // Constructor
    public Stocktransactions(int medicineId,
                             int batchId,
                             String transactionType,
                             int quantity,
                             String referenceType,
                             int referenceId,
                             LocalDateTime transactionDate,
                             String notes,
                             int createdBy) {

        this.medicineId = medicineId;
        this.batchId = batchId;
        this.transactionType = transactionType;
        this.quantity = quantity;
        this.referenceType = referenceType;
        this.referenceId = referenceId;
        this.transactionDate = transactionDate;
        this.notes = notes;
        this.createdBy = createdBy;
    }


    // Getters and Setters

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public int getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(int medicineId) {
        this.medicineId = medicineId;
    }

    public int getBatchId() {
        return batchId;
    }

    public void setBatchId(int batchId) {
        this.batchId = batchId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getReferenceType() {
        return referenceType;
    }

    public void setReferenceType(String referenceType) {
        this.referenceType = referenceType;
    }

    public int getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(int referenceId) {
        this.referenceId = referenceId;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }


    @Override
    public String toString() {
        return "Stocktransactions{" +
                "transactionId=" + transactionId +
                ", medicineId=" + medicineId +
                ", batchId=" + batchId +
                ", transactionType='" + transactionType + '\'' +
                ", quantity=" + quantity +
                ", referenceType='" + referenceType + '\'' +
                ", referenceId=" + referenceId +
                ", transactionDate=" + transactionDate +
                ", notes='" + notes + '\'' +
                ", createdBy=" + createdBy +
                '}';
    }
}
