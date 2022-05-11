package Personnages;

import Items.Item;
import Lieux.Salle;

import java.util.Random;

public class Boss extends Hostile{
    private boolean isArmor;

    public Boss(String nom, int vie, int attaque, Salle s) {
        super(nom, vie, attaque, s);
        this.isArmor = false;
    }

    public void attaque(Combattant c){
        Random r = new Random();
        int nb = r.nextInt(100);
        if(isArmor){
            if (nb < 50) {
                c.perteVie(this.getAttaque());
                System.out.println("ay pif");
            }
            if (nb >= 50 && nb < 85) {
                c.perteVie((int) (this.getAttaque() * 1.5));
                System.out.println("Vous avez perdu " + this.getAttaque() + " points de vie de la part de " + this.getNom());
            }
            if (nb >= 85) {
                this.setVie(this.getVie() + (int) (this.getAttaque() * 0.5));
                System.out.println("Le boss c'est soignée de " + this.getAttaque() + " points de vie");
            }
        }else {
            if (nb < 50) {
                c.perteVie(this.getAttaque());
                System.out.println("ay pif");
            }
            if (nb >= 50 && nb < 70) {
                c.perteVie((int) (this.getAttaque() * 1.5));
                System.out.println("Vous avez perdu " + this.getAttaque() + " points de vie de la part de " + this.getNom());
            }
            if (nb >= 70 && nb < 85) {
                this.setVie(this.getVie() + (int) (this.getAttaque() * 0.5));
                System.out.println("Le boss c'est soignée de " + this.getAttaque() + " points de vie");
            }
            if (nb >= 85) {
                this.isArmor = true;
            }
        }
    }
}