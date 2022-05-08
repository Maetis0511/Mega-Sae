package Jeu;

import Personnages.Joueur;

public class BuffBoosted extends Buff {

    public BuffBoosted(double stats, int tours) {
        super(stats, tours);
    }

    @Override
    public void removeBuff(Joueur joueur) {
        Combat.boosted = false;
    }
}
