package Personnages;


import Items.Item;

import java.util.Random;

public class Hostile extends Personnages {
    private Item loot;
    private int nbLoot;
    private float chanceLoot;

    public Hostile(String nom, int vie,int attaque,Item loot , int nbLoot,int niveau,int xp, int chanceLoot) {
        super(nom, vie, attaque, niveau, xp);
        this.loot = loot;
        this.nbLoot = nbLoot;
        this.chanceLoot = chanceLoot;

    }
    public void attaque(Joueur joueur){
        Random r = new Random();
        int nb = r.nextInt(1000);
        if(nb==1) {
            joueur.perteVie(this.getAttaque()*100000);
            System.out.println("GET NATCHOED!!!!");
        }
        else{
        joueur.perteVie(this.getAttaque());
        System.out.println("Vous avez perdu " + this.getAttaque() + " points de vie de la part de " + this.getNom());

        }
    }

}