package common;

import abstraction.Commercial;

import java.util.Date;

public final class Representant extends Commercial {

    public Representant(String lastName, String firstName, int age, Date entryDate, double chiffreAffaire) {
        super(lastName, firstName, age, entryDate, chiffreAffaire);
    }

    public Representant(Representant employe) {
        super(employe);
    }

    @Override
    public double calculateSalary() {
        return 800 + (0.2 * this.chiffreAffaire); // 20% ( chiffreAffaire ) + 800 DH
    }
}
