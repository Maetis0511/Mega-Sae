package Personnages;


import Items.*;
import Lieux.Salle;

import java.util.Random;

public class Hostile extends Combattant {
    private Item loot;
    protected Salle pos;

    /**
     * Mob constructor with loot
     * @param nom Mob's name
     * @param vie Mob's life
     * @param attaque Mob's attack
     * @param loot Mob's loot when killed
     * @param s Mob's room
     */
    public Hostile(String nom, int vie, int attaque, Item loot, Salle s) {
        super(nom, vie, attaque * (s.getNiveauSalle() / 15), s.getNiveauSalle(), 0);
        this.loot = loot;
        this.pos = s;
    }

    /**
     * Mob constructor without loot
     * @param nom Mob's name
     * @param vie Mob's life
     * @param attaque Mob's attack
     * @param s Mob's room
     */
    public Hostile(String nom, int vie, int attaque, Salle s) {
        super(nom, vie, attaque, s.getNiveauSalle(), 0);
        this.loot = null;
        this.pos = s;
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

    public void setPos(Salle pos) {
        this.pos = pos;
    }

    public Item getLoot() {
        return loot;
    }
}