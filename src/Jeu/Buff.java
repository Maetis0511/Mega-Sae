package Jeu;

import Personnages.Joueur;

public abstract class Buff {
    private double stats;
    private int tours;

    /**
     * Buff constructor
     * @param stats Buff's stats
     * @param tours Buff's duration
     */
    public Buff(double stats, int tours) {
        this.stats = stats;
        this.tours = tours;
    }

    /**
     * @return Buff's duration
     */
    public int getTours() {
        return tours;
    }

    /**
     * @return Buff's stats
     */
    public double getStats() {
        return stats;
    }

    /**
     * Function to reduce the duration of the buff
     */
    public void decrementerTours() {
        this.tours--;
    }

    /**
     * Function to remove the buff
     * @param joueur Player who has the buff
     */
    public abstract void removeBuff(Joueur joueur);
}
