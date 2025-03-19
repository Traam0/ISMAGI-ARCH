package common;

import interfaces.EmployeDeRisque;

import java.util.Date;

public final class ManutentionnaireRisque extends Manutentionnaire implements EmployeDeRisque {
    public ManutentionnaireRisque(String lastName, String firstName, int age, Date entryDate, int hoursWorked) {
        super(lastName, firstName, age, entryDate, hoursWorked);
    }

    public ManutentionnaireRisque(Manutentionnaire employe) {
        super(employe);
    }

    @Override
    public double calculateSalary() {
        return super.calculateSalary() + PRIME_DE_RISQUE;
    }
}
