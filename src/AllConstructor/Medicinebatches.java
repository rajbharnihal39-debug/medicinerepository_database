package AllConstructor;

import java.time.LocalDate;

public class Medicinebatches {

    private int batchId;
    private int medicineId;
    private int supplierId;
    private String batchNumber;
    private LocalDate manufactureDate;
    private LocalDate expiryDate;
    private double purchasePrice;
    private double sellingPrice;
    private int quantityReceived;
    private int quantityAvailable;


    // =========================================================
    // DEFAULT CONSTRUCTOR
    // =========================================================

    public Medicinebatches() {
    }


    // =========================================================
    // PARAMETERIZED CONSTRUCTOR
    // =========================================================

    public Medicinebatches(
            int batchId,
            int medicineId,
            int supplierId,
            String batchNumber,
            LocalDate manufactureDate,
            LocalDate expiryDate,
            double purchasePrice,
            double sellingPrice,
            int quantityReceived,
            int quantityAvailable
    ) {

        this.batchId = batchId;
        this.medicineId = medicineId;
        this.supplierId = supplierId;
        this.batchNumber = batchNumber;
        this.manufactureDate = manufactureDate;
        this.expiryDate = expiryDate;
        this.purchasePrice = purchasePrice;
        this.sellingPrice = sellingPrice;
        this.quantityReceived = quantityReceived;
        this.quantityAvailable = quantityAvailable;
    }


    public int getBatchId() {
        return batchId;
    }

    public void setBatchId(int batchId) {
        this.batchId = batchId;
    }


    public int getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(int medicineId) {
        this.medicineId = medicineId;
    }


    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }


    public String getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber;
    }


    public LocalDate getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(LocalDate manufactureDate) {
        this.manufactureDate = manufactureDate;
    }


    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }


    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }


    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }


    public int getQuantityReceived() {
        return quantityReceived;
    }

    public void setQuantityReceived(int quantityReceived) {
        this.quantityReceived = quantityReceived;
    }


    public int getQuantityAvailable() {
        return quantityAvailable;
    }

    public void setQuantityAvailable(int quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
    }


    @Override
    public String toString() {

        return "Medicinebatches{" +
                "batchId=" + batchId +
                ", medicineId=" + medicineId +
                ", supplierId=" + supplierId +
                ", batchNumber='" + batchNumber + '\'' +
                ", manufactureDate=" + manufactureDate +
                ", expiryDate=" + expiryDate +
                ", purchasePrice=" + purchasePrice +
                ", sellingPrice=" + sellingPrice +
                ", quantityReceived=" + quantityReceived +
                ", quantityAvailable=" + quantityAvailable +
                '}';
    }
}
