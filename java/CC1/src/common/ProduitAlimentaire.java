package common;

import abstraction.Product;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public final class ProduitAlimentaire extends Product {
    private LocalDate expiryDate;

    public ProduitAlimentaire() {
        super();
    }

    public ProduitAlimentaire(String designation, double cout, LocalDate expiryDate) {
        super(designation, cout);
        this.expiryDate = expiryDate;
    }

    public ProduitAlimentaire(ProduitAlimentaire produit) {
        super(produit);
        this.setExpiryDate(produit.getExpiryDate());
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate value) {
        if (value.equals(this.expiryDate))
            return;
        this.expiryDate = value;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("\t-Expires at: ").append(formatter.format(this.expiryDate)).append(".\n");
        return sb.toString();
    }
}
