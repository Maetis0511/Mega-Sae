package Jeu;

import Items.Consommable;
import Personnages.Combattant;
import Personnages.Hostile;
import Personnages.Joueur;

import java.util.*;

public class Combat {
    private Joueur joueur;
    private Hostile monstre;
    public static boolean boosted;

    public Combat(Joueur joueur, Hostile monstre) {
        this.joueur = joueur;
        this.monstre = monstre;
        this.boosted = false;
    }

    public void combat() {
        List<Buff> buffs = new ArrayList<>();
        while (joueur.getVie() > 0 && monstre.getVie() > 0) {

            System.out.println("Il vous reste " + joueur.getVie() + " points de vie");
            System.out.println("Il reste " + monstre.getVie() + " points de vie à " + monstre.getNom());

            //c1 attaque c2

            System.out.println("Que voulez vous faire ?");
            System.out.println("1 - Attaquer");
            System.out.println("2 - Utiliser un consommable");
            Scanner scanner = new Scanner(System.in);
            int choix = scanner.nextInt();
            if (choix == 1) {
                System.out.println("Vous pouvez :");
                System.out.println("1 - Attaquer avec votre arme");
                System.out.println("2 - Utiliser un sort augmentant votre attaque durant 2 tours");
                int choix2 = scanner.nextInt();
                if (choix2 == 1) {
                    joueur.attaque(monstre);
                }
                else if (choix2 == 2) {
                    System.out.println("Votre attaque est boostée pendant 2 tours");
                    joueur.setAttaque((int) (joueur.getAttaque() * 1.5));
                    BuffAttaque buff = new BuffAttaque(1.5, 3);
                    buffs.add(buff);
                }
            }
            else if (choix == 2) {
                System.out.println("Que voulez vous utiliser ?");
                joueur.afficherConsommable();
                int choix2 = scanner.nextInt();
                this.boosted = joueur.utiliserConsommable((Consommable) joueur.getInventaire().get(0).get(choix2 - 1), true);
                if (this.boosted) {
                    BuffBoosted buff = new BuffBoosted(2, 2);
                    buffs.add(buff);
                }
            }

            if (boosted) {
                System.out.println("Vous pouvez attaquer une deuxième fois grâce au nachos étrange pendant 2 tours");
                System.out.println("Que voulez vous faire ?");
                System.out.println("1 - Attaquer");
                System.out.println("2 - Utiliser un consommable");
                choix = scanner.nextInt();
                if (choix == 1) {
                    System.out.println("Vous pouvez :");
                    System.out.println("1 - Attaquer avec votre arme");
                    System.out.println("2 - Utiliser un sort augmentant votre attaque durant 2 tours");
                    int choix2 = scanner.nextInt();
                    if (choix2 == 1) {
                        joueur.attaque(monstre);
                    }
                    else if (choix2 == 2) {
                        System.out.println("Votre attaque est boostée pendant 2 tours");
                        joueur.setAttaque((int) (joueur.getAttaque() * 1.5));
                        BuffAttaque buff = new BuffAttaque(1.5, 3);
                        buffs.add(buff);
                    }
                }
                else if (choix == 2) {
                    System.out.println("Que voulez vous utiliser ?");
                    joueur.afficherConsommable();
                    int choix2 = scanner.nextInt();
                    joueur.utiliserConsommable((Consommable) joueur.getInventaire().get(0).get(choix2 - 1), true);
                }
            }

            if (monstre.getVie() > 0) {
                monstre.attaque(joueur);
            }

            for (Buff buff : buffs) {
                buff.decrementerTours();
            }

            if (!buffs.isEmpty()) {
                for (int i = 0; i < buffs.size(); i++) {
                    if (buffs.get(i).getTours() <= 0) {
                        buffs.get(i).removeBuff(joueur);
                    }
                }
            }
        }
        if (joueur.getVie() > 0) {
            System.out.println("Vous remportez le combat !");
        }
        if (monstre.getVie() > 0) {
            System.out.println("Vous avez été tué par " + monstre.getNom());
        }
    }
}
