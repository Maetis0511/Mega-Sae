package Personnages;

import Items.Item;

import java.util.ArrayList;
import java.util.List;

public class Joueur extends Personnages {
    private List<Item> inventaire;
    private Item armeActive;

    public Joueur(String nom, int vie, int attaque,int niveau, int xp,List<Item> inventaire, Item armeActive) {
        super(nom);
        this.niveau = niveau;
        this.xp = xp;
        List<Item> inventaire = new ArrayList<>();
        this.inventaire = inventaire;
        this.armeActive = armeActive;
    }



    public void ajouterItem(Item item) {
        this.inventaire.add(item);
    }

    public void retirerItem(Item item) {
        this.inventaire.remove(item);
    }

    public void afficherInventaire() {
        for (Item item : inventaire) {
            System.out.println(item.getNom());
        }
    }

    public void attaque(Personnages personnage) {
        personnage.perteVie(this.attaque + this.armeActive.getDegats());
        System.out.println("Vous avez attaqué " + personnage.getNom() + " et lui avez infligé " + (this.attaque + this.armeActive.getDegats()) + " points de dégats");
    }

    public void utiliserConsommable(Consommable consommable) {
        this.gainVie(consommable.getValeur());
    }

    public static void main(String[] args) {

    }
}


