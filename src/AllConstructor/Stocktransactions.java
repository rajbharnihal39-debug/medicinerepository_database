package AllConstructor;

import java.time.LocalDateTime;

public class Stocktransactions {

    

    private int transactionId;
    private int medicineId;
    private int batchId;
    private String transactionType;
    private int quantity;
    private String referenceType;
    private int referenceId;
    private LocalDateTime transactionDate;
    private String notes;
    private int createdBy;


    // =========================================================
    // DEFAULT CONSTRUCTOR
    // =========================================================

    public Stocktransactions() {
    }


    // =========================================================
    // PARAMETERIZED CONSTRUCTOR
    // =========================================================

    public Stocktransactions(
            int transactionId,
            int medicineId,
            int batchId,
            String transactionType,
            int quantity,
            String referenceType,
            int referenceId,
            LocalDateTime transactionDate,
            String notes,
            int createdBy
    ) {

        this.transactionId = transactionId;
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


    // =========================================================
    // GETTER AND SETTER - TRANSACTION ID
    // =========================================================

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }


    // =========================================================
    // GETTER AND SETTER - MEDICINE ID
    // =========================================================

    public int getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(int medicineId) {
        this.medicineId = medicineId;
    }


    // =========================================================
    // GETTER AND SETTER - BATCH ID
    // =========================================================

    public int getBatchId() {
        return batchId;
    }

    public void setBatchId(int batchId) {
        this.batchId = batchId;
    }


    // =========================================================
    // GETTER AND SETTER - TRANSACTION TYPE
    // =========================================================

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }


    // =========================================================
    // GETTER AND SETTER - QUANTITY
    // =========================================================

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    // =========================================================
    // GETTER AND SETTER - REFERENCE TYPE
    // =========================================================

    public String getReferenceType() {
        return referenceType;
    }

    public void setReferenceType(String referenceType) {
        this.referenceType = referenceType;
    }


    // =========================================================
    // GETTER AND SETTER - REFERENCE ID
    // =========================================================

    public int getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(int referenceId) {
        this.referenceId = referenceId;
    }


    // =========================================================
    // GETTER AND SETTER - TRANSACTION DATE
    // =========================================================

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }


    // =========================================================
    // GETTER AND SETTER - NOTES
    // =========================================================

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }


    // =========================================================
    // GETTER AND SETTER - CREATED BY
    // =========================================================

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }


    // =========================================================
    // TO STRING
    // =========================================================

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
