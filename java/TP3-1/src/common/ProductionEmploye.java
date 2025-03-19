package common;

import abstraction.Employe;

import java.util.Date;

public class ProductionEmploye extends Employe {
    public int unitsNumber;

    public ProductionEmploye(String lastName, String firstName, int age, Date entryDate, int unitsNumber) {
        super(lastName, firstName, age, entryDate);
        this.unitsNumber = unitsNumber;
    }

    public ProductionEmploye(ProductionEmploye employe) {
        super(employe);
        this.setUnitsNumber(employe.getUnitsNumber());
    }

    @Override
    public double calculateSalary() {
        return this.unitsNumber * 5;
    }

    public int getUnitsNumber() {
        return this.unitsNumber;
    }

    public void setUnitsNumber(int value) {
        this.unitsNumber = value;
    }
}
