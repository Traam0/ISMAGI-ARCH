package common;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class Hospital {
    private static int patientsCount = 0;
    private final List<Patient> patients;

    public Hospital() {
        this.patients = new ArrayList<>();
    }

    public Hospital(List<Patient> patients) {
        this.patients = patients;
    }

    public static int getPatientsCount() {
        return Hospital.patientsCount;
    }

    public boolean addPatient(Patient patient) {
        for (Patient p : this.patients) {
            if (p.equals(patient))
                return false;
        }

        this.patients.add(patient);
        Hospital.patientsCount++;
        return true;
    }

    public boolean removePatient(int code) {
        Patient patient = this.getPatient(code);
        if (patient == null)
            return false;
        this.patients.remove(patient);
        return true;
    }

    public boolean updatePatient(Patient newP, int code) {
        for (int i = 0; i < this.patients.size(); i++) {
            Patient patient = this.patients.get(i);
            if (patient.getCode() != code)
                continue;
            this.patients.set(i, newP);
            return true;
        }
        return false;
    }

    public Patient getPatient(int code) {
        for (Patient patient : this.patients) {
            if (patient.getCode() == code)
                return patient;
        }

        return null;
    }

    @Override
    public String toString() {
        return patients.stream().map(Object::toString).collect(Collectors.joining("\n"));
    }
}
