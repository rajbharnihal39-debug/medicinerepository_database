package AllConstructor;

import java.time.LocalDate;

public class Expiryalerts {

    // =========================
    // VARIABLES
    // =========================

    private int alertId;
    private int batchId;
    private String alertType;
    private LocalDate alertDate;
    private String status;


    // =========================
    // DEFAULT CONSTRUCTOR
    // =========================

    public Expiryalerts() {

    }


    // =========================
    // PARAMETERIZED CONSTRUCTOR
    // =========================

    public Expiryalerts(
            int alertId,
            int batchId,
            String alertType,
            LocalDate alertDate,
            String status
    ) {

        this.alertId = alertId;
        this.batchId = batchId;
        this.alertType = alertType;
        this.alertDate = alertDate;
        this.status = status;
    }


    // =========================
    // GETTER AND SETTER
    // =========================

    public int getAlertId() {
        return alertId;
    }

    public void setAlertId(int alertId) {
        this.alertId = alertId;
    }


    public int getBatchId() {
        return batchId;
    }

    public void setBatchId(int batchId) {
        this.batchId = batchId;
    }


    public String getAlertType() {
        return alertType;
    }

    public void setAlertType(String alertType) {
        this.alertType = alertType;
    }


    public LocalDate getAlertDate() {
        return alertDate;
    }

    public void setAlertDate(LocalDate alertDate) {
        this.alertDate = alertDate;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    // =========================
    // TO STRING
    // =========================

    @Override
    public String toString() {

        return "Expiryalerts{" +
                "alertId=" + alertId +
                ", batchId=" + batchId +
                ", alertType='" + alertType + '\'' +
                ", alertDate=" + alertDate +
                ", status='" + status + '\'' +
                '}';
    }
}
