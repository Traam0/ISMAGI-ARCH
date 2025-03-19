package Exercice3;

public class Employe {
    private static int instances = 0;
    private int number;
    private String fname;
    private String lname;
    private double salary;

    public  Employe(int number, String fname, String lname, double salary){
        this.number = number;
        this.fname = fname;
        this.lname = lname;
        this.salary = salary;

        Employe.instances++;
    }

    public static int getInstances() {
        return instances;
    }

    public String afficher(){
        StringBuilder builder = new StringBuilder();
        builder.append("Employe Number: ").append(this.number).append("\n")
                .append("\t-First Name: ").append(this.fname).append("\n")
                .append("\t-Last Name: ").append(this.lname).append("\n")
                .append("\t-Salary: ").append(this.salary).append("\n");

        return builder.toString();
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
