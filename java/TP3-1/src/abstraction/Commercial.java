package abstraction;

import java.util.Date;

public abstract class Commercial extends Employe {
    protected double chiffreAffaire;

    public Commercial(String lastName, String firstName, int age, Date entryDate, double chiffreAffaire) {
        super(lastName, firstName, age, entryDate);
        this.chiffreAffaire = chiffreAffaire;
    }

    public Commercial(Commercial employe) {
        super(employe);
        this.setChiffreAffaire(this.getChiffreAffaire());
    }

    public double getChiffreAffaire() {
        return this.chiffreAffaire;
    }

    public void setChiffreAffaire(double value) {
        this.chiffreAffaire = value;
    }
}
