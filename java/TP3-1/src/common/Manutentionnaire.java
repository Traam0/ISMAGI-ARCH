package common;

import abstraction.Employe;

import java.util.Date;

public class Manutentionnaire extends Employe {
    protected int hoursWorked;

    public Manutentionnaire(String lastName, String firstName, int age, Date entryDate, int hoursWorked) {
        super(lastName, firstName, age, entryDate);
        this.hoursWorked = hoursWorked;
    }

    public Manutentionnaire(Manutentionnaire employe) {
        super(employe);
        this.setHoursWorked(this.getHoursWorked());
    }

    @Override
    public double calculateSalary() {
        return this.hoursWorked * 65;
    }

    public int getHoursWorked() {
        return this.hoursWorked;
    }

    public void setHoursWorked(int value) {
        this.hoursWorked = value;
    }
}
