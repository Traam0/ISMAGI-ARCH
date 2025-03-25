package common;

import abstraction.Product;

public final class ProduitElectro extends Product {
    private String marque;
    private String energyClass;


    public ProduitElectro(String designation, double cout, String marque, String energyClass) {
        super(designation, cout);
        this.marque = marque;
        this.energyClass = energyClass;
    }

    public ProduitElectro(ProduitElectro produit) {
        super(produit);
        this.setMarque(produit.getMarque());
        this.setEnergyClass(produit.getEnergyClass());
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String value) {
        if (value.equals(this.marque)) return;
        this.marque = value;
    }

    public String getEnergyClass() {
        return energyClass;
    }

    public void setEnergyClass(String value) {
        if (value.equals(this.energyClass)) return;
        this.energyClass = value;
    }

    public double GetPromo() {
        if (this.marque.equals("LG")) return 0.1;
        if (this.getCoutTTC() > 10_000) return 0.12;
        return 0;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("\t-Marque: ").append(this.marque).append(".\n");
        sb.append("\t-Class: ").append(this.energyClass).append(".\n");
        return sb.toString();
    }
}
