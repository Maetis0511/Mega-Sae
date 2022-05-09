package Jeu;

import Personnages.Joueur;

public class BuffAttaque extends Buff {
    /**
     * BuffAttaque constructor
     * @param stats Buff's stats
     * @param tours Buff's duration
     */
    public BuffAttaque(double stats, int tours) {
        super(stats, tours);
    }

    /**
     * Function to remove the buff
     * @param joueur Player who has the buff
     */
    public void removeBuff(Joueur joueur) {
        joueur.setAttaque((int) (joueur.getAttaque() / this.getStats()));
    }
}
