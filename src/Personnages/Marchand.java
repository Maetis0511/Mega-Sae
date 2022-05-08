package Personnages;

import Items.Item;

import java.util.List;

public class Marchand extends Personnage {
    private List<Item> inventaire;

    public Marchand(String nom) {
        super(nom);
    }

    public void ajouterItem(Item item) {
        inventaire.add(item);
    }

    public void afficherInventaire() {
        for (Item item : inventaire) {
            System.out.println(item.getNom());
        }
    }
}
