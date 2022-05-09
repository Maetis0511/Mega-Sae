package Tests;

import Personnages.*;
import Lieux.*;
import Jeu.*;
import Items.*;

public class testmain {
    public static void main(String[] args) {
        Map m = new Map();
        Salle s1 = new Salle("Salle 1", "Entrée du temple miteux", 1);
        Salle s2 = new Salle("Salle 2", "Salle de combat", 2);
        Salle s3 = new Salle("Salle 3", "Salle de boss", 3);

        m.addLien(s1, s2);
        m.addLien(s2, s3);

        Joueur j1 = new Joueur("Joueur 1", 1000, 110, s1);
        Hostile h1 = new Hostile("Hostile 1", 35000, 40, s3);

        System.out.println(j1.afficherPosition());

        j1.changerSalle(m.getMap(), s3);

        System.out.println(j1.afficherPosition());

        Consommable c1 = new Consommable("Nachos", 1, "Un nachos miteux", 100);
        Consommable c2 = new Consommable("Nachos", 1, "Un nachos miteux", 120);
        Consommable c3 = new Consommable("Nachos étrange", 2, "Un nachos brillant", 2);

        j1.ajouterItem(c1);
        j1.ajouterItem(c2);
        j1.ajouterItem(c3);

        Combat combat = new Combat(j1, h1);
    }
}
