package Exercice3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public  class EmployeTest {
    public static void run() {
        System.out.println("====================<< Start of Exercice3: Employe >>====================");
        List<Employe> employees = getEmployes();
        employees.sort(Comparator.comparing(Employe::getSalary));
        System.out.println("Total number of employees: " + Employe.getInstances());
        for (Employe employee : employees) {
            System.out.println(employee.afficher());
        }

        System.out.println("=========================<< End of Exercice3 >>==========================");

    }

    private static List<Employe> getEmployes() {
        Random gen = new Random();

        Employe emp1 = new Employe(gen.nextInt(), "Femp1", "Lemp1", gen.nextDouble());
        Employe emp2 = new Employe(gen.nextInt(), "Femp2", "Lemp2", gen.nextDouble());
        Employe emp3 = new Employe(gen.nextInt(), "Femp3", "Lemp3", gen.nextDouble());
        Employe emp4 = new Employe(gen.nextInt(), "Femp4", "Lemp4", gen.nextDouble());
        Employe emp5 = new Employe(gen.nextInt(), "Femp5", "Lemp5", gen.nextDouble());

        List<Employe> employees = new ArrayList<>(List.of(emp1, emp2, emp3, emp4, emp5));
        return employees;
    }
}
