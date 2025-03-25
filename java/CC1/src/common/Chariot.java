package common;

import abstraction.Product;

import java.util.*;

public final class Chariot {
    private Map<Product, Integer> products;

    public Chariot() {
        this.products = new HashMap<>();
    }

    public Chariot(Map<Product, Integer> products) {
        this();
        this.products = products;
    }

    public void addProduct(Product product, int quantity) {
        if (this.products.containsKey(product))
            throw new IllegalArgumentException("Product exist deja dans le chariot");
        this.products.put(product, quantity);
    }

    public void showProducts() {
        for (Product product : this.products.keySet()) {
            System.out.println(product);
        }
    }

    public Product getProduct(String designation) {
        for (Product product : this.products.keySet()) {
            if (product.getDesignation().equals(designation)) return product;
        }
        return null;
    }

    public double totalChariotBeforeReduction() {
        double total = 0;
        for (Map.Entry<Product, Integer> productEntry : products.entrySet()) {
            total += productEntry.getKey().getCoutTTC() * productEntry.getValue();
        }
        return total;
    }

    public double totalChariotAfterReduction() {
        double total = 0;
        for (Map.Entry<Product, Integer> productEntry : this.products.entrySet()) {
            Product product = productEntry.getKey();
            int quantity = productEntry.getValue();
            double price = product.getCoutTTC() * quantity;

            if (product instanceof ProduitElectro) {
                price = price - (price * ((ProduitElectro) product).GetPromo());
            }

            total += price;
        }

        if (total > 5_000) {
            total = total - (total * 0.05);
        }
        return total;
    }

    public List<Product> getProductsBenefPromotion() {
        List<Product> list = new ArrayList<>();
        for (Product product : this.products.keySet()) {
            if (product instanceof ProduitElectro) {
                if (Objects.equals(((ProduitElectro) product).getMarque(), "LG")) {
                    list.add(product);
                    continue;
                }

                if (product.getCoutTTC() > 10_000) list.add(product);
            }
        }
        return list;
    }

    public int getPointFidel() {
        int points = 0;
        for (Product product : this.products.keySet()) {
            if (product instanceof ProduitAlimentaire) points += 20;
            if (product instanceof ProduitElectro) {
                if (((ProduitElectro) product).getMarque().equals("LG")) {
                    points += 10_000;
                    continue;
                }
                points += 5000;
            }
        }

        return points;
    }
}
