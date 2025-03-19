package Exercice1;

public class Cercle {
    private double rayon;

    public Cercle(double rayon){
        if(rayon < 0) throw new IllegalArgumentException("rayon cannot be negative");
    }

    public double getRayon() {
        return rayon;
    }

    public void setRayon(double rayon) {
        if(rayon < 0) throw new IllegalArgumentException("rayon cannot be negative");
        this.rayon = rayon;
    }

    public double diametre(){
        return  this.rayon * 2;
    }

    public  double perimetre(){
        return 2 * Math.PI * this.rayon;
    }

    public double surface(){
        return Math.PI * Math.pow(this.rayon, 2);
    }
}

