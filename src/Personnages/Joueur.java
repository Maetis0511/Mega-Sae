package Personnages;

import Items.*;
import Lieux.Graphe;
import Lieux.Salle;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Joueur extends Combattant {
    private List<List<Item>> inventaire;
    private Arme armeActive;
    private Salle pos;

    /**
     * Player constructor
     * @param nom Player's name
     * @param vie Player's life
     * @param s Player's room
     */
    public Joueur(String nom, int vie, int attaque, Salle s) {
        super(nom,vie,attaque,1,0);
        this.inventaire = new ArrayList<>(2);
        for (int i = 0; i < 2; i++) {
            this.inventaire.add(new ArrayList<>());
        }
        this.armeActive = armeActive;

        this.pos = s;
    }

    /**
     *
     * @param item Item to add to the player's inventory
     */
    public void ajouterItem(Item item) {
        if (item instanceof Consommable) {
            this.inventaire.get(0).add(item);
        }
        else if (item instanceof Arme) {
            this.inventaire.get(1).add(item);
        }
    }

    /**
     *
     * @return Player's inventory
     */
    public List<List<Item>> getInventaire() {
        return this.inventaire;
    }

    /**
     * Function to remove an item from the player's inventory
     * @param item Item to remove
     */
    public void retirerItem(Item item) {
        this.inventaire.remove(item);
    }

    /**
     * Function to display the player's inventory
     */
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

    /**
     * Function to display the player's consumables
     */
    public void afficherConsommable() {
        for (int i = 0; i < inventaire.get(0).size(); i++) {
            System.out.println((i + 1) + " - " + inventaire.get(0).get(i).getNom());
        }
    }

    /**
     * Function to display the player's weapons
     */
    public void afficherArme() {
        for (int i = 0; i < inventaire.get(1).size(); i++) {
            System.out.println((i + 1) + " - " + inventaire.get(1).get(i).getNom());
        }
    }

    /**
     * Function to choose a player's weapon
     */
    public void choisirArme() {
        System.out.println("Que voulez vous utiliser ?");
        afficherArme();
        Scanner scanner = new Scanner(System.in);
        int choix = scanner.nextInt();
        this.armeActive = (Arme) this.inventaire.get(choix - 1);
    }

    /**
     * Set player's attack
     * @param c the attack at the fighter
     */
    public void attaque(Combattant c) {
        System.out.println("Vous attaquez " + c.getNom() + " avec votre arme et lui avez infligé " + this.getAttaque() + " points de vie");
        c.perteVie(this.getAttaque());
    }

    /**
     * Function to use a consumable
     * @param conso the consumable to use
     * @param inFight true if the player is in a fight
     * @return true if "nachos étranges" is used
     */
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


    public boolean changerSalle(Graphe<Salle> map, Salle s) {
        for (Salle salle : map.getVoisins(s)) {
            if (salle.getNom().equals(s.getNom())) {
                this.pos = salle;
                return true;
            }
        }
        System.out.println("Cette salle n'est pas accessible");
        return false;
    }

    public void afficherPosition() {
        System.out.println(this.pos.getNom());
    }

    public void afficherSalles(Graphe<Salle> map) {
        System.out.println("Salles accessible :");
        int cpt = 1;
        for (Salle s : map.getVoisins(this.pos)) {
            System.out.println(cpt + " - " + s.getNom());
            cpt++;
        }
    }
}


