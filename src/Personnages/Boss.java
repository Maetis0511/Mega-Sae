package Personnages;

import Items.Item;
import Lieux.Salle;

public class Boss extends Hostile{

    public Boss(String nom, int vie, int attaque, Salle s) {
        super(nom, vie, attaque, s);
    }
}
