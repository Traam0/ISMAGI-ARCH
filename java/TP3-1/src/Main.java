import common.*;

import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Personnel personnel = new Personnel();

        personnel.addEmploye(new Vendeur("John", "doe1", 30,new Date(), 20000));
        personnel.addEmploye(new Representant("John", "doe2", 28, new Date(), 15000));
        personnel.addEmploye(new ProductionEmploye("John", "doe3", 40, new Date(), 300));
        personnel.addEmploye(new Manutentionnaire("John", "doe4", 35, new Date(), 160));
        personnel.addEmploye(new ProductionEmployeRisque("John", "doe5", 45, new Date(), 300));
        personnel.addEmploye(new ManutentionnaireRisque("John", "doe6", 29, new Date(), 170));

        personnel.showSalary();
        System.out.println("==================================");
        personnel.showAvgSalary();
    }
}