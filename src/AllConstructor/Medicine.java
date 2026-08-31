package AllConstructor;

public class Medicine {

    private int id;
    private String medicineCode;
    private String name;
    private String genericName;
    private int categoryId;
    private String dosageForm;
    private String strength;
    private String unit;
    private int recordLevel;
    private String description;
    private String status;

    public Medicine() {
    }

    public Medicine(
            int id,
            String medicineCode,
            String name,
            String genericName,
            int categoryId,
            String dosageForm,
            String strength,
            String unit,
            int recordLevel,
            String description,
            String status) {

        this.id = id;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMedicineCode() {
        return medicineCode;
    }

    public void setMedicineCode(String medicineCode) {
        this.medicineCode = medicineCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenericName() {
        return genericName;
    }

    public void setGenericName(String genericName) {
        this.genericName = genericName;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getDosageForm() {
        return dosageForm;
    }

    public void setDosageForm(String dosageForm) {
        this.dosageForm = dosageForm;
    }

    public String getStrength() {
        return strength;
    }

    public void setStrength(String strength) {
        this.strength = strength;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getRecordLevel() {
        return recordLevel;
    }

    public void setRecordLevel(int recordLevel) {
        this.recordLevel = recordLevel;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {

        return "Medicine{" +
                "id=" + id +
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
