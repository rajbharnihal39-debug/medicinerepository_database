package com.example.Entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "expiry_alerts")
public class Expiryalerts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "alert_id")
    private int alertId;

    @Column(name = "batch_id")
    private int batchId;

    @Column(name = "alert_type")
    private String alertType;

    @Column(name = "alert_date")
    private LocalDate alertDate;

    @Column(name = "status")
    private String status;


    // Default Constructor
    public Expiryalerts() {
    }


    // Constructor
    public Expiryalerts(int batchId,
                        String alertType,
                        LocalDate alertDate,
                        String status) {

        this.batchId = batchId;
        this.alertType = alertType;
        this.alertDate = alertDate;
        this.status = status;
    }


    // Getters and Setters

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
