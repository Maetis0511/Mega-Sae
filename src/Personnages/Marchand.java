package Personnages;

import Items.Arme;
import Items.Item;
import Lieux.Graphe;
import Lieux.Salle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Marchand extends Personnage {
    protected List<Arme> inventaire;

    /**
     * Trader's constructor
     * @param nom Item's name
     */
    public Marchand(String nom) {
        super(nom);
        this.inventaire = new ArrayList<>();
    }

    /**
     * Function to add an item to the trader's inventory
     * @param arme Item to add
     */
    public void ajouterItem(Arme arme) {
        this.inventaire.add(arme);
    }

    /**
     * Function to sell an item
     * @param arme Weapon to sell
     */
    public void vendreItem(Arme arme) {
        this.inventaire.remove(arme);
    }

    /**
     * Function to display the trader's inventory
     */
    public java.util.Map<Integer, Arme> afficherMarchand() {
        java.util.Map<Integer, Arme> listeItems = new HashMap<>();
        int cpt = 1;
        for (Arme arme : this.inventaire) {
            listeItems.put(cpt, arme);
            cpt++;
        }
        return listeItems;
    }

    /**
     * @return the inventory
     */
    public List<Arme> getInventaire() {
        return inventaire;
    }
}
