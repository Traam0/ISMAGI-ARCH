package Exercice2;

import java.util.Random;

public class PaireTest {
    public static void run() {
        System.out.println("====================<< Start of Exercice2: Paire >>=====================");

        Random gen = new Random();
        Paire p1 = new Paire(gen.nextInt(), gen.nextInt());
        Paire p2 = new Paire(gen.nextInt(), gen.nextInt());
        Paire p3 = new Paire(gen.nextInt(), gen.nextInt());
        Paire p4 = new Paire(gen.nextInt(), gen.nextInt());

        System.out.println("Total Paire created: " + Paire.getNbrPair());
        System.out.println("Max de a et b dont p4 est: " + p4.max());
        System.out.printf("b(%d) in p2 %s a(%d) %n", p2.getB(), p2.bDividesA() ? "divides" : "doesnt divide", p2.getA());
        System.out.println("a power of b in p3 is:" + p3.aPowerB());

        System.out.println("=========================<< End of Exercice2 >>=========================");
    }
}
