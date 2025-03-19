package abstraction;

import java.util.Date;

public abstract class Employe {
    protected String lastName, firstName;
    protected int age;
    protected Date entryDate;

    public Employe(String lastName, String firstName, int age, Date entryDate) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
        this.entryDate = entryDate;
    }

    public Employe(Employe employe){
        this.setLastName(employe.getLastName());
        this.setFirstName(employe.getFirstName());
        this.setAge(employe.getAge());
        this.setEntryDate(employe.getEntryDate());
    }

    public abstract double calculateSalary();

    public String getName(){
        return String.format("L'employé: %s %s", this.lastName, this.firstName);
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String value){
        this.lastName = value;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public void setFirstName(String value){
        this.firstName = value;
    }

    public int getAge(){
        return this.age;
    }

    public void setAge(int value){
        this.age = value;
    }

    public Date getEntryDate() {
        return entryDate;
    }


    public void setEntryDate(Date value){
        this.entryDate = value;
    }
}
