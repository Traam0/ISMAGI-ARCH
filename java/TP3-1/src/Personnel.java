import abstraction.Employe;

import java.util.ArrayList;
import java.util.List;

public class Personnel {
    private List<Employe> employes;

    public Personnel() {
        this.employes = new ArrayList<>();
    }

    public void addEmploye(Employe employe) {
        this.employes.add(employe);
    }

    public void showSalary() {
        for (Employe employe : this.employes) {
            System.out.println(
                    String.format("%s has a salary of: %.2f DH", employe.getName(), employe.calculateSalary())
            );
        }
    }

    public void showAvgSalary() {
        if (employes.isEmpty()) return;

        double accumulatedSalary = 0;
        for (Employe employe : this.employes) {
            accumulatedSalary += employe.calculateSalary();
        }

        System.out.println(
                String.format("Average Salary of the employees is: %.2f DH", (accumulatedSalary / this.employes.size())) // to show 2 numbers after comma,  example: (1.2656 => 1.26)
        );
    }
}

