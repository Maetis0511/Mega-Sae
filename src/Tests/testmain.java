package Tests;

import Personnages.*;
import Lieux.*;
import Jeu.*;
import Items.*;

public class testmain {
    public static void main(String[] args) {
        Joueur j1 = new Joueur("Joueur 1", 1000, 110);
        Hostile h1 = new Hostile("Hostile 1", 35000, 40, 3);


        Consommable c1 = new Consommable("Nachos", 1, "Un nachos miteux", 100);
        Consommable c2 = new Consommable("Nachos", 1, "Un nachos miteux", 120);
        Consommable c3 = new Consommable("Nachos étrange", 2, "Un nachos brillant", 2);

        j1.ajouterItem(c1);
        j1.ajouterItem(c2);
        j1.ajouterItem(c3);

        Combat combat = new Combat(j1, h1);
        combat.combat();
    }
}
