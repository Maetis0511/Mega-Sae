package Personnages;

import Items.Item;

import java.util.List;

public class Marchand extends Personnage {
    protected List<Item> inventaire;

    /**
     * Trader's constructor
     * @param nom Item's name
     */
    public Marchand(String nom) {
        super(nom);
    }

    /**
     * Function to add an item to the trader's inventory
     * @param item Item to add
     */
    public void ajouterItem(Item item) {
        inventaire.add(item);
    }

    /**
     * Function to display the trader's inventory
     */
    public void afficherInventaire() {
        for (Item item : inventaire) {
            System.out.println(item.getNom());
        }
    }

    public List<Item> getInventaire() {
        return inventaire;
    }
}
