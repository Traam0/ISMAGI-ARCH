package abstraction;

import java.util.Random;

public abstract class Product {
    public static final double TVA = 0.19;
    protected final int id;
    protected String designation;
    protected double cout;

    public Product() {
        this.id = Math.abs(new Random().nextInt());
    }

    public Product(String designation, double cout) {
        this();
        this.designation = designation;
        this.cout = cout;
    }

    public Product(Product product) {
        this();
        this.setCout(product.getCout());
        this.setDesignation(product.getDesignation());
    }

    public int getId() {
        return this.id;
    }

    public String getDesignation() {
        return this.designation;
    }

    public void setDesignation(String value) {
        if (value.equals(this.designation)) return;
        this.designation = value;
    }

    public double getCout() {
        return this.cout;
    }

    public void setCout(double value) {
        if (value == this.cout) return;
        this.cout = value;
    }

    public double getCoutTTC() {
        return this.cout + (this.cout * Product.TVA);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("•Produit(").append(this.id).append(")").append(" :\n");
        sb.append("\t-designation: ").append(this.designation).append(".\n");
        sb.append("\t-cout: ").append(this.cout).append(".\n");
        sb.append("\t-coutTTC: ").append(this.getCoutTTC()).append(".\n");
        return sb.toString();
    }
}
