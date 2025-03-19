package common;

import interfaces.EmployeDeRisque;

import java.util.Date;

public final class ProductionEmployeRisque extends ProductionEmploye implements EmployeDeRisque {
    public ProductionEmployeRisque(String lastName, String firstName, int age, Date entryDate, int unitsNumber) {
        super(lastName, firstName, age, entryDate, unitsNumber);
    }

    public ProductionEmployeRisque(ProductionEmploye employe) {
        super(employe);
    }


    @Override
    public double calculateSalary() {
        return super.calculateSalary() + PRIME_DE_RISQUE;
    }
}
