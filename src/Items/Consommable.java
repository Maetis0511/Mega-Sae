package Items;

public class Consommable extends Item {

    private int Valeur;

    Consommable(String nom, int id, int valeur) {
        super(nom,id);
        this.Valeur = valeur;

    }
    Consommable(String nom, int id, int valeur,) {
        super(nom,id);
        this.Valeur = valeur;

    }

    public int getValeur() {
        return Valeur;
    }
}