package AllConstructor;

public class Purchaseorderitems {

    private int poItemId;
    private int purchaseOrderId;
    private int medicineId;
    private int quantityOrdered;
    private double unitPrice;
    private double tax;
    private double discount;
    private double totalAmount;

    // =========================
    // CONSTRUCTOR
    // =========================

    public Purchaseorderitems() {
    }

    public Purchaseorderitems(
            int poItemId,
            int purchaseOrderId,
            int medicineId,
            int quantityOrdered,
            double unitPrice,
            double tax,
            double discount,
            double totalAmount) {

        this.poItemId = poItemId;
        this.purchaseOrderId = purchaseOrderId;
        this.medicineId = medicineId;
        this.quantityOrdered = quantityOrdered;
        this.unitPrice = unitPrice;
        this.tax = tax;
        this.discount = discount;
        this.totalAmount = totalAmount;
    }

    // =========================
    // GETTER AND SETTER
    // =========================

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

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
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
