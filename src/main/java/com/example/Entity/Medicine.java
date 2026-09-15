package com.example.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "medicine")
public class Medicine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "medicine_id")
    private int medicineId;

    @Column(name = "medicine_code", length = 100)
    private String medicineCode;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "generic_name", length = 100)
    private String genericName;

    @Column(name = "category_id")
    private int categoryId;

    @Column(name = "dosage_form", length = 100)
    private String dosageForm;

    @Column(name = "strength", length = 100)
    private String strength;

    @Column(name = "unit", length = 50)
    private String unit;

    @Column(name = "record_level")
    private int recordLevel;

    @Column(name = "description", length = 200)
    private String description;

    @Column(name = "status", length = 20)
    private String status;


    // Default Constructor
    public Medicine() {
    }


    // Parameterized Constructor
    public Medicine(String medicineCode,
                    String name,
                    String genericName,
                    int categoryId,
                    String dosageForm,
                    String strength,
                    String unit,
                    int recordLevel,
                    String description,
                    String status) {

        this.medicineCode = medicineCode;
        this.name = name;
        this.genericName = genericName;
        this.categoryId = categoryId;
        this.dosageForm = dosageForm;
        this.strength = strength;
        this.unit = unit;
        this.recordLevel = recordLevel;
        this.description = description;
        this.status = status;
    }


    // Getter and Setter for medicineId
    public int getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(int medicineId) {
        this.medicineId = medicineId;
    }


    // Getter and Setter for medicineCode
    public String getMedicineCode() {
        return medicineCode;
    }

    public void setMedicineCode(String medicineCode) {
        this.medicineCode = medicineCode;
    }


    // Getter and Setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    // Getter and Setter for genericName
    public String getGenericName() {
        return genericName;
    }

    public void setGenericName(String genericName) {
        this.genericName = genericName;
    }


    // Getter and Setter for categoryId
    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }


    // Getter and Setter for dosageForm
    public String getDosageForm() {
        return dosageForm;
    }

    public void setDosageForm(String dosageForm) {
        this.dosageForm = dosageForm;
    }


    // Getter and Setter for strength
    public String getStrength() {
        return strength;
    }

    public void setStrength(String strength) {
        this.strength = strength;
    }


    // Getter and Setter for unit
    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }


    // Getter and Setter for recordLevel
    public int getRecordLevel() {
        return recordLevel;
    }

    public void setRecordLevel(int recordLevel) {
        this.recordLevel = recordLevel;
    }


    // Getter and Setter for description
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    // Getter and Setter for status
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    // toString()
    @Override
    public String toString() {
        return "Medicine{" +
                "medicineId=" + medicineId +
                ", medicineCode='" + medicineCode + '\'' +
                ", name='" + name + '\'' +
                ", genericName='" + genericName + '\'' +
                ", categoryId=" + categoryId +
                ", dosageForm='" + dosageForm + '\'' +
                ", strength='" + strength + '\'' +
                ", unit='" + unit + '\'' +
                ", recordLevel=" + recordLevel +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
