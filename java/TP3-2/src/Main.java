import java.time.LocalDate;

import common.Hospital;
import common.Patient;

public class Main {
    public static void main(String[] args) {
        Hospital hopital = new Hospital();
        LocalDate date = LocalDate.of(2025, 3, 1);
        Patient p = new Patient();
        p.setCode(1);
        p.setName("younes");
        p.setDiseaseType("Nothing to mention");
        p.setEntryDate(date);
        Patient p2 = new Patient(p);
        p2.setCode(2);
        if (hopital.addPatient(p))
            System.out.println("added successfully");
        else
            System.out.println("patient already exists");
        if (hopital.addPatient(p2))
            System.out.println("added successfully");
        else
            System.out.println("patient already exists");
        Patient p3 = new Patient(3, "Karima", "Disease description", LocalDate.now());
        Patient p4 = new Patient(13, "Karim", "A description", LocalDate.now());
        hopital.addPatient(p3);

        System.out.println("Number of patients : " + Hospital.getPatientsCount());
        hopital.updatePatient(p4, 13);
        System.out.println(hopital);
    }
}