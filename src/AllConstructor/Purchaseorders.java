package AllConstructor;

public class Purchaseorders {

    private int purchaseOrderId;
    private String poNumber;
    private int supplierId;
    private String orderDate;
    private String expectedDate;
    private String status;
    private double subtotal;
    private double tax;
    private double discount;
    private double totalAmount;
    private String notes;


    // =========================
    // PURCHASE ORDER ID
    // =========================

    public int getPurchaseOrderId() {
        return purchaseOrderId;
    }

    public void setPurchaseOrderId(int purchaseOrderId) {
        this.purchaseOrderId = purchaseOrderId;
    }


    // =========================
    // PO NUMBER
    // =========================

    public String getPoNumber() {
        return poNumber;
    }

    public void setPoNumber(String poNumber) {
        this.poNumber = poNumber;
    }


    // =========================
    // SUPPLIER ID
    // =========================

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }


    // =========================
    // ORDER DATE
    // =========================

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }


    // =========================
    // EXPECTED DATE
    // =========================

    public String getExpectedDate() {
        return expectedDate;
    }

    public void setExpectedDate(String expectedDate) {
        this.expectedDate = expectedDate;
    }


    // =========================
    // STATUS
    // =========================

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    // =========================
    // SUBTOTAL
    // =========================

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }


    // =========================
    // TAX
    // =========================

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }


    // =========================
    // DISCOUNT
    // =========================

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }


    // =========================
    // TOTAL AMOUNT
    // =========================

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }


    // =========================
    // NOTES
    // =========================

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }


    // =========================
    // TO STRING
    // =========================

    @Override
    public String toString() {

        return "Purchaseorders{" +
                "purchaseOrderId=" + purchaseOrderId +
                ", poNumber='" + poNumber + '\'' +
                ", supplierId=" + supplierId +
                ", orderDate='" + orderDate + '\'' +
                ", expectedDate='" + expectedDate + '\'' +
                ", status='" + status + '\'' +
                ", subtotal=" + subtotal +
                ", tax=" + tax +
                ", discount=" + discount +
                ", totalAmount=" + totalAmount +
                ", notes='" + notes + '\'' +
                '}';
    }
}
