package Jeu;

import Personnages.Combattant;
import Personnages.Joueur;

public class Combat {
    private Combattant c1;
    private Combattant c2;

    public Combat(Combattant c1, Combattant c2) {
        this.c1 = c1;
        this.c2 = c2;
    }

    public void combat() {
        while (c1.getVie() > 0 && c2.getVie() > 0) {
            c1.attaque(c2);
            if (c2.getVie() > 0) {
                c2.attaque(c1);
            }
        }
        if (c1.getVie() > 0) {
            System.out.println("Vous remportez le combat !");
        }
        if (c2.getVie() > 0) {
            System.out.println("Vous avez été tué par " + c2.getNom());
        }
    }
}
