package Personnages;

import Items.Item;
import Jeu.Dialogue;
import Lieux.Salle;

import java.util.Random;

public class Boss extends Hostile{
    public static boolean isArmor;

    /**
     * Boss constructor
     * @param nom Boss's name
     * @param vie Boss's life
     * @param attaque Boss's attack
     * @param s Room where the Boss is
     */
    public Boss(String nom, int vie, int attaque, Salle s) {
        super(nom, vie, attaque, s);
        this.isArmor = false;
    }

    /**
     * Set boss's attack
     * @param c the attack of the mob
     */
    public void attaque(Combattant c){
        Random r = new Random();
        int nb = r.nextInt(100);
        if(isArmor){
            if (nb < 50) {
                c.perteVie(this.getAttaque());
                Dialogue.dialogues("Vous avez perdu " + this.getAttaque() + " points de vie de la part de " + this.getNom());
            }
            if (nb >= 50 && nb < 85) {
                c.perteVie((int) (this.getAttaque() * 1.5));
                Dialogue.dialogues("Vous avez perdu " + this.getAttaque() * 1.5 + " points de vie de la part de " + this.getNom());
            }
            if (nb >= 85) {
                this.setVie(this.getVie() + (int) (this.getAttaque() * 0.5));
                Dialogue.dialogues("Le boss s'est soigné de " + this.getAttaque() + " points de vie");
            }
        }else {
            if (nb < 50) {
                c.perteVie(this.getAttaque());
                Dialogue.dialogues("Vous avez perdu " + this.getAttaque() + " points de vie de la part de " + this.getNom());
            }
            if (nb >= 50 && nb < 70) {
                c.perteVie((int) (this.getAttaque() * 1.5));
                Dialogue.dialogues("Vous avez perdu " + this.getAttaque() * 1.5 + " points de vie de la part de " + this.getNom());
            }
            if (nb >= 70 && nb < 85) {
                this.setVie(this.getVie() + (int) (this.getAttaque() * 0.5));
                Dialogue.dialogues("Le boss s'est soigné de " + this.getAttaque() + " points de vie");
            }
            if (nb >= 85) {
                this.isArmor = true;
                Dialogue.dialogues("Vous voyez un nuage vert recouvrir THE STINKY ONE, le nuage a l'air de puer");
            }
        }
    }
}
