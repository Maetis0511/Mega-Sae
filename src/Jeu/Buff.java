package Jeu;

import Personnages.Joueur;

public abstract class Buff {
    private double stats;
    private int tours;

    public Buff(double stats, int tours) {
        this.stats = stats;
        this.tours = tours;
    }

    public int getTours() {
        return tours;
    }

    public double getStats() {
        return stats;
    }

    public void decrementerTours() {
        this.tours--;
    }

    public abstract void removeBuff(Joueur joueur);
}
