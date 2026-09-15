package com.example.Entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "sale_items")
public class Saleitems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sale_item_id")
    private int saleItemId;

    @Column(name = "sale_id")
    private int saleId;

    @Column(name = "medicine_id")
    private int medicineId;

    @Column(name = "batch_id")
    private int batchId;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "unit_price")
    private BigDecimal unitPrice;

    @Column(name = "discount")
    private BigDecimal discount;

    @Column(name = "tax")
    private BigDecimal tax;

    @Column(name = "total_amount")
    private BigDecimal totalAmount;


    // Default Constructor
    public Saleitems() {
    }


    // Constructor
    public Saleitems(int saleId,
                     int medicineId,
                     int batchId,
                     int quantity,
                     BigDecimal unitPrice,
                     BigDecimal discount,
                     BigDecimal tax,
                     BigDecimal totalAmount) {

        this.saleId = saleId;
        this.medicineId = medicineId;
        this.batchId = batchId;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.discount = discount;
        this.tax = tax;
        this.totalAmount = totalAmount;
    }


    // Getters and Setters

    public int getSaleItemId() {
        return saleItemId;
    }

    public void setSaleItemId(int saleItemId) {
        this.saleItemId = saleItemId;
    }

    public int getSaleId() {
        return saleId;
    }

    public void setSaleId(int saleId) {
        this.saleId = saleId;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }


    @Override
    public String toString() {
        return "Saleitems{" +
                "saleItemId=" + saleItemId +
                ", saleId=" + saleId +
                ", medicineId=" + medicineId +
                ", batchId=" + batchId +
                ", quantity=" + quantity +
                ", unitPrice=" + unitPrice +
                ", discount=" + discount +
                ", tax=" + tax +
                ", totalAmount=" + totalAmount +
                '}';
    }
}
