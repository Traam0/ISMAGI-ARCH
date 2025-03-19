package common;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public final class Patient {
    private int code;
    private String name, diseaseType;
    private LocalDate entryDate;

    public Patient() {
        super();
    }

    public Patient(int code, String name, String diseaseType, LocalDate entryDate) {
        this.setCode(code);
        this.setName(name);
        this.setDiseaseType(diseaseType);
        this.setEntryDate(entryDate);
    }

    public Patient(Patient patient) {
        this(patient.code, patient.name, patient.diseaseType, patient.entryDate);
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");
        StringBuilder sb = new StringBuilder();
        sb.append("Patient [").append(this.code).append("]");
        sb.append("[")
                .append(this.name).append(", ").append(this.diseaseType).append(", ")
                .append(formatter.format(this.entryDate))
                .append("]");

        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Patient))
            return false;

        Patient patient = (Patient) obj;

        return this.code == patient.code || (this.name.equals(patient.name)
                && this.diseaseType.equals(patient.diseaseType) && this.entryDate.equals(patient.entryDate));
    }

    public int getCode() {
        return code;
    }

    public void setCode(int value) {
        if (this.code == value)
            return;

        if (value <= 0)
            throw new IllegalArgumentException("Patient code must be strictly positive.");
        this.code = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        if (this.name == value)
            return;

        if (!Character.isLetter(value.charAt(0)))
            throw new IllegalArgumentException("Patient name must start with a letter.");
        this.name = value;
    }

    public String getDiseaseType() {
        return diseaseType;
    }

    public void setDiseaseType(String value) {
        if (this.diseaseType == value)
            return;

        if (value.length() < 10 || value.length() > 40)
            throw new IllegalArgumentException("DiseaseType must have a length between 10 and 40.");
        this.diseaseType = value;
    }

    public LocalDate getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(LocalDate value) {
        if (this.entryDate == value)
            return;

        if (value.isAfter(LocalDate.now()))
            throw new IllegalArgumentException("Entry date cannot be in the future");
        this.entryDate = value;
    }

}
