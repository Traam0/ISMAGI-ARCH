package common;

import abstraction.Commercial;

import java.util.Date;

public final class Vendeur extends Commercial {

    public Vendeur(String lastName, String firstName, int age, Date entryDate, double chiffreAffaire) {
        super(lastName, firstName, age, entryDate, chiffreAffaire);
    }

    public Vendeur(Vendeur employe) {
        super(employe);
    }

    @Override
    public double calculateSalary() {
        return 400 + (0.2 * this.chiffreAffaire); // 20% ( chiffre Affiare )  + 400 DH
    }
}
