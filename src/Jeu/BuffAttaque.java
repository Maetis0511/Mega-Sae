package Jeu;

import Personnages.Joueur;

public class BuffAttaque extends Buff {

    public BuffAttaque(double stats, int tours) {
        super(stats, tours);
    }

    public void removeBuff(Joueur joueur) {
        joueur.setAttaque((int) (joueur.getAttaque() / this.getStats()));
    }
}
