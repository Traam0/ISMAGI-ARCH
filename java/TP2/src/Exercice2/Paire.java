package Exercice2;

public class Paire {
    private static int nbrPair = 0;
    private int a;
    private  int b;

    public Paire(int a, int b){
        this.a = a;
        this.b = b;
        Paire.nbrPair++;
    }

    public static int getNbrPair() {
        return nbrPair;
    }

    public int max(){
        // return this.a > this.b ? a : b;
        return  Math.max(a, b);
    }

    public boolean bDividesA(){
        return this.a % this.b == 0;
    }

    public int aPowerB(){
        return (int) Math.pow(a, b);
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }
}
