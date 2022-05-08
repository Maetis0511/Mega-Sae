package Personnages;

import Items.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Joueur extends Combattant {
    private List<List<Item>> inventaire;
    private Arme armeActive;

    public Joueur(String nom, int vie, int attaque) {
        super(nom,vie,attaque,1,0);
        this.inventaire = new ArrayList<>(2);
        for (int i = 0; i < 2; i++) {
            this.inventaire.add(new ArrayList<>());
        }
        this.armeActive = armeActive;
    }

    public void ajouterItem(Item item) {
        if (item instanceof Consommable) {
            this.inventaire.get(0).add(item);
        }
        else if (item instanceof Arme) {
            this.inventaire.get(1).add(item);
        }
    }

    public List<List<Item>> getInventaire() {
        return this.inventaire;
    }

    public void retirerItem(Item item) {
        this.inventaire.remove(item);
    }

    public void afficherInventaire() {
        System.out.println("1 - Consommables");
        for (int i = 0; i < inventaire.get(0).size(); i++) {
            System.out.println((i + 1) + " - " + inventaire.get(0).get(i).getNom());
        }
        System.out.println("2 - Armes");
        for (int i = 0; i < inventaire.get(1).size(); i++) {
            System.out.println((i + 1) + " - " + inventaire.get(1).get(i).getNom());
        }
    }

    public void afficherConsommable() {
        for (int i = 0; i < inventaire.get(0).size(); i++) {
            System.out.println((i + 1) + " - " + inventaire.get(0).get(i).getNom());
        }
    }

    public void afficherArme() {
        for (int i = 0; i < inventaire.get(1).size(); i++) {
            System.out.println((i + 1) + " - " + inventaire.get(1).get(i).getNom());
        }
    }

    public void choisirArme() {
        System.out.println("Que voulez vous utiliser ?");
        afficherArme();
        Scanner scanner = new Scanner(System.in);
        int choix = scanner.nextInt();
        this.armeActive = (Arme) this.inventaire.get(choix - 1);
    }

    public void attaque(Combattant c) {
        System.out.println("Vous attaquez " + c.getNom() + " avec votre arme et lui avez infligé " + this.getAttaque() + " points de vie");
        c.perteVie(this.getAttaque());
    }

    public boolean utiliserConsommable(Consommable conso, boolean inFight) {
        if (conso.getId() == 1) {
            this.setVie(this.getVie() + conso.getValue());
            return false;
        }
        else if (inFight && conso.getId() == 2) {
            System.out.println("Vous avez mangé le nachos étrange, sensation étrange, c'est comme si vous pouviez attaquer 2 fois par tour, drôle de sensation");
            return true;
        }
        else if (!inFight && conso.getId() == 2) {
            System.out.println("Vous ne pouvez pas mangé le nachos étrange ici, gardez le pour un combat ou vous aurez faim");
            return false;
        }
        return false;
    }
}


