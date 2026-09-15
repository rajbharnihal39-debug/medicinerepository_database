package AllConstructor;

public class Saleitems {

    private int saleItemId;
    private int saleId;
    private int medicineId;
    private int batchId;
    private int quantity;
    private double unitPrice;
    private double discount;
    private double tax;
    private double totalAmount;


    // =========================================================
    // DEFAULT CONSTRUCTOR
    // =========================================================

    public Saleitems() {
    }


    // =========================================================
    // PARAMETERIZED CONSTRUCTOR
    // =========================================================

    public Saleitems(
            int saleItemId,
            int saleId,
            int medicineId,
            int batchId,
            int quantity,
            double unitPrice,
            double discount,
            double tax,
            double totalAmount) {

        this.saleItemId = saleItemId;
        this.saleId = saleId;
        this.medicineId = medicineId;
        this.batchId = batchId;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.discount = discount;
        this.tax = tax;
        this.totalAmount = totalAmount;
    }


    // =========================================================
    // GETTER AND SETTER - SALE ITEM ID
    // =========================================================

    public int getSaleItemId() {
        return saleItemId;
    }

    public void setSaleItemId(int saleItemId) {
        this.saleItemId = saleItemId;
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
    // GETTER AND SETTER - QUANTITY
    // =========================================================

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    // =========================================================
    // GETTER AND SETTER - UNIT PRICE
    // =========================================================

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
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
    // GETTER AND SETTER - TAX
    // =========================================================

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
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
    // TO STRING
    // =========================================================

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
