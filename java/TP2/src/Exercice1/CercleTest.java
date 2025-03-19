package Exercice1;

public class  CercleTest {

    public static void run(){
        System.out.println("====================<< Start of Exercice1: Cercle >>====================");

        Cercle cercle = new Cercle(3.42);
        System.out.println("Rayon: " + cercle.getRayon());
        System.out.println("Diametre: " + cercle.diametre());
        System.out.println("Perimetre: " + cercle.perimetre());
        System.out.println("Surface: " + cercle.surface());

        System.out.println("=========================<< End of Exercice1 >>=========================");
    }
}
