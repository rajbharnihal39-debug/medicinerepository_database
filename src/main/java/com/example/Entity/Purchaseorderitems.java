package com.example.Entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "purchase_order_items")
public class Purchaseorderitems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "po_item_id")
    private int poItemId;

    @Column(name = "purchase_order_id")
    private int purchaseOrderId;

    @Column(name = "medicine_id")
    private int medicineId;

    @Column(name = "quantity_ordered")
    private int quantityOrdered;

    @Column(name = "unit_price")
    private BigDecimal unitPrice;

    @Column(name = "tax")
    private BigDecimal tax;

    @Column(name = "discount")
    private BigDecimal discount;

    @Column(name = "total_amount")
    private BigDecimal totalAmount;


    // Default Constructor
    public Purchaseorderitems() {
    }


    // Constructor
    public Purchaseorderitems(int purchaseOrderId,
                              int medicineId,
                              int quantityOrdered,
                              BigDecimal unitPrice,
                              BigDecimal tax,
                              BigDecimal discount,
                              BigDecimal totalAmount) {

        this.purchaseOrderId = purchaseOrderId;
        this.medicineId = medicineId;
        this.quantityOrdered = quantityOrdered;
        this.unitPrice = unitPrice;
        this.tax = tax;
        this.discount = discount;
        this.totalAmount = totalAmount;
    }


    // Getters and Setters

    public int getPoItemId() {
        return poItemId;
    }

    public void setPoItemId(int poItemId) {
        this.poItemId = poItemId;
    }

    public int getPurchaseOrderId() {
        return purchaseOrderId;
    }

    public void setPurchaseOrderId(int purchaseOrderId) {
        this.purchaseOrderId = purchaseOrderId;
    }

    public int getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(int medicineId) {
        this.medicineId = medicineId;
    }

    public int getQuantityOrdered() {
        return quantityOrdered;
    }

    public void setQuantityOrdered(int quantityOrdered) {
        this.quantityOrdered = quantityOrdered;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }


    @Override
    public String toString() {
        return "Purchaseorderitems{" +
                "poItemId=" + poItemId +
                ", purchaseOrderId=" + purchaseOrderId +
                ", medicineId=" + medicineId +
                ", quantityOrdered=" + quantityOrdered +
                ", unitPrice=" + unitPrice +
                ", tax=" + tax +
                ", discount=" + discount +
                ", totalAmount=" + totalAmount +
                '}';
    }
}
