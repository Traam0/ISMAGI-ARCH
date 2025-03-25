import abstraction.Product;
import common.Chariot;
import common.ProduitAlimentaire;
import common.ProduitElectro;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Chariot chariot = new Chariot();
        ProduitElectro prod1 = new ProduitElectro("Television 4K", 12_000, "LG", "Class A");
        chariot.addProduct(prod1, 1);
        ProduitElectro prod2 = new ProduitElectro("Frigo", 8_000, "Whirlpool", "Class A++");
        chariot.addProduct(prod2, 1);
        ProduitAlimentaire prod3 = new ProduitAlimentaire("Fromage", 3.50, LocalDate.of(2025, 4, 15));
        chariot.addProduct(prod3, 4);
        ProduitAlimentaire prod4 = new ProduitAlimentaire("Lait", 2, LocalDate.of(2025, 3, 30));
        chariot.addProduct(prod4, 8);

        chariot.showProducts();
        System.out.printf("montant total Chariot avant reduction est >> %.2f%n", chariot.totalChariotBeforeReduction());
        System.out.printf("montant final Chariot apres reduction est >> %.2f%n ", chariot.totalChariotAfterReduction());
        System.out.println("Nombre point fidelite accumules le Chariot  >> " + chariot.getPointFidel());
        System.out.println("============================================");
        System.out.println("Produits beneficie de promotions: ");
        for (Product product : chariot.getProductsBenefPromotion()) {
            System.out.println(product);
        }
    }
}