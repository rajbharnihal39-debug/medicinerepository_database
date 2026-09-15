package AllConstructor;

import java.time.LocalDateTime;

public class Sales {


    private int saleId;
    private String invoiceNumber;
    private String customerName;
    private LocalDateTime saleDate;
    private double subtotal;
    private double tax;
    private double discount;
    private double totalAmount;
    private String paymentMethod;
    private String status;
    private int createdBy;


    // =========================================================
    // DEFAULT CONSTRUCTOR
    // =========================================================

    public Sales() {

    }


    // =========================================================
    // PARAMETERIZED CONSTRUCTOR
    // =========================================================

    public Sales(
            int saleId,
            String invoiceNumber,
            String customerName,
            LocalDateTime saleDate,
            double subtotal,
            double tax,
            double discount,
            double totalAmount,
            String paymentMethod,
            String status,
            int createdBy
    ) {

        this.saleId = saleId;
        this.invoiceNumber = invoiceNumber;
        this.customerName = customerName;
        this.saleDate = saleDate;
        this.subtotal = subtotal;
        this.tax = tax;
        this.discount = discount;
        this.totalAmount = totalAmount;
        this.paymentMethod = paymentMethod;
        this.status = status;
        this.createdBy = createdBy;
    }


    // =========================================================
    // GETTER AND SETTER - SALE ID
    // =========================================================

    public int getSaleId() {
        return saleId;
    }

    public void setSaleId(int saleId) {
        this.saleId = saleId;
    }


    // =========================================================
    // GETTER AND SETTER - INVOICE NUMBER
    // =========================================================

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }


    // =========================================================
    // GETTER AND SETTER - CUSTOMER NAME
    // =========================================================

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }


    // =========================================================
    // GETTER AND SETTER - SALE DATE
    // =========================================================

    public LocalDateTime getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(LocalDateTime saleDate) {
        this.saleDate = saleDate;
    }


    // =========================================================
    // GETTER AND SETTER - SUBTOTAL
    // =========================================================

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }


    // =========================================================
    // GETTER AND SETTER - TAX
    // =========================================================

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }


    // =========================================================
    // GETTER AND SETTER - DISCOUNT
    // =========================================================

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }


    // =========================================================
    // GETTER AND SETTER - TOTAL AMOUNT
    // =========================================================

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }


    // =========================================================
    // GETTER AND SETTER - PAYMENT METHOD
    // =========================================================

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }


    // =========================================================
    // GETTER AND SETTER - STATUS
    // =========================================================

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

        return "Sales{" +
                "saleId=" + saleId +
                ", invoiceNumber='" + invoiceNumber + '\'' +
                ", customerName='" + customerName + '\'' +
                ", saleDate=" + saleDate +
                ", subtotal=" + subtotal +
                ", tax=" + tax +
                ", discount=" + discount +
                ", totalAmount=" + totalAmount +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", status='" + status + '\'' +
                ", createdBy=" + createdBy +
                '}';
    }
}
