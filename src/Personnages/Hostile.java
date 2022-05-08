package Personnages;


import Items.*;

import java.util.Random;

public class Hostile extends Combattant {
    private Item loot;
    private int nbLoot;

    public Hostile(String nom, int vie, int attaque, Item loot, int niveau) {
        super(nom, vie, attaque * (niveau / 15), niveau, 0);
        this.loot = loot;
    }

    public Hostile(String nom, int vie, int attaque, int niveau) {
        super(nom, vie, attaque, niveau, 0);
        this.loot = null;
    }

    public boolean attaque(Combattant c){
        Random r = new Random();
        int nb = r.nextInt(1000);
        if(nb==1) {
            c.perteVie(this.getAttaque()*100000);
            System.out.println("GET NATCHOED!!!!");
        }
        else{
            c.perteVie(this.getAttaque());
            System.out.println("Vous avez perdu " + this.getAttaque() + " points de vie de la part de " + this.getNom());
        }
        return true;
    }
}