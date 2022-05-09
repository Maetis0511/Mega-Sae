package Jeu;

import Personnages.Joueur;

public class BuffBoosted extends Buff {
    /**
     * BuffBoosted constructor
     * @param stats Buff's stats
     * @param tours Buff's duration
     */
    public BuffBoosted(double stats, int tours) {
        super(stats, tours);
    }

    /**
     * Function to remove the buff
     * @param joueur player who has the buff
     */
    @Override
    public void removeBuff(Joueur joueur) {
        Combat.boosted = false;
    }
}
