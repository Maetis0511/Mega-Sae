package Personnages;

import Items.*;

import java.util.List;
import java.util.Scanner;

public class Joueur extends Combattant {
    private List<List<Item>> inventaire;
    private Arme armeActive;

    public Joueur(String nom, int vie, int attaque) {
        super(nom,vie,attaque,1,0);
        this.inventaire = inventaire;
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

    public boolean attaque(Combattant c) {
        System.out.println("Que voulez vous faire ?");
        System.out.println("1 - Attaquer");
        System.out.println("2 - Utiliser un consommable");
        Scanner scanner = new Scanner(System.in);
        int choix = scanner.nextInt();
        if (choix == 1) {
            System.out.println("Vous pouvez :");
            System.out.println("1 - Attaquer avec votre arme");
            System.out.println("2 - Utiliser un sort augmentant votre attque durant 2 tours");
            int choix2 = scanner.nextInt();
            if (choix2 == 1) {
                System.out.println("Vous attaquez " + c.getNom() + " avec votre arme et lui avez infligé " + this.getAttaque() + " points de vie");
                c.perteVie(this.getAttaque());
            }
            else if (choix2 == 2) {
                System.out.println("Votre attaque est boostée pendant 2 tours");
                this.setAttaque((int) (this.getAttaque() * 1.5));
                return true;
            }
        }
        else if (choix == 2) {
            System.out.println("Que voulez vous utiliser ?");
            afficherConsommable();
            int choix2 = scanner.nextInt();
            utiliserConsommable((Consommable) this.inventaire.get(0).get(choix2 - 1));
        }
        return false;
    }

    public void utiliserConsommable(Consommable consommable) {
        this.gainVie(consommable.getValeur());
    }
}


