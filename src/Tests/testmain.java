package Tests;

import Personnages.*;
import Lieux.*;
import Jeu.*;
import Items.*;

public class testmain {
    public static void main(String[] args) {
        Joueur j1 = new Joueur("Joueur 1", 600, 110);
        Hostile h1 = new Hostile("Hostile 1", 350, 40, 3);

        Combat c1 = new Combat(j1, h1);
        c1.combat();
    }
}
