package Personnages;


import Items.*;

import java.util.Random;

public class Hostile extends Combattant {
    private Item loot;
    private int nbLoot;

    /**
     * Mob constructor with loot
     * @param nom Mob's name
     * @param vie Mob's life
     * @param attaque Mob's attack
     * @param loot Mob's loot when killed
     * @param niveau Mob's level
     */
    public Hostile(String nom, int vie, int attaque, Item loot, int niveau) {
        super(nom, vie, attaque * (niveau / 15), niveau, 0);
        this.loot = loot;
    }

    /**
     * Mob constructor without loot
     * @param nom Mob's name
     * @param vie Mob's life
     * @param attaque Mob's attack
     * @param niveau Mob's level
     */
    public Hostile(String nom, int vie, int attaque, int niveau) {
        super(nom, vie, attaque, niveau, 0);
        this.loot = null;
    }

    /**
     * Set mob's attack
     * @param c the attack of the mob
     */
    public void attaque(Combattant c){
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
    }
}