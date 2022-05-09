package Jeu;

import Items.Consommable;
import Personnages.Combattant;
import Personnages.Hostile;
import Personnages.Joueur;

import java.io.File;
import java.io.FileNotFoundException;
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

    public void cri() {
        try {
            File myObj = new File("src/ressources/Wordlist");
            int i = 0;
            int random = (int) (Math.random() * 22737);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if (i == random) {

                    System.out.println(this.monstre.getNom()+" crie : " + data);
                }
                i++;

            }
            myReader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

        public void combat() {
            System.out.println("Vous avez découvert un " + this.monstre.getNom() + " de niveau " + this.monstre.getNiveau() + " !");
        cri();
        List<Buff> buffs = new ArrayList<>();
        while (joueur.getVie() > 0 && monstre.getVie() > 0) {

            System.out.println("Il vous reste " + joueur.getVie() + " points de vie");
            System.out.println("Il reste " + monstre.getVie() + " points de vie à " + monstre.getNom());

            //c1 attaque c2

            System.out.println("Que voulez vous faire ?");
            System.out.println("1 - Attaquer");
            System.out.println("2 - Utiliser un consommable");
            Scanner scanner = new Scanner(System.in);
            int choix = 0;
            boolean exception = true;
            while (exception) {
                try {
                    choix = scanner.nextInt();
                    exception = false;
                } catch (InputMismatchException e) {
                    System.out.println("Veuillez entrer un nombre.\nEntrez le nombre : ");
                    scanner.nextLine();
                }
            }

            if (choix == 1) {
                System.out.println("Vous pouvez :");
                System.out.println("1 - Attaquer avec votre arme");
                System.out.println("2 - Utiliser un sort augmentant votre attaque durant 2 tours");
                int choix2 = 0;
                boolean exception2 = true;
                while (exception2) {
                    try {
                        choix2 = scanner.nextInt();
                        exception2 = false;
                    } catch (InputMismatchException e) {
                        System.out.println("Veuillez entrer un nombre.\nEntrez le nombre : ");
                        scanner.nextLine();
                    }
                }
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
                int choix2 = 0;
                try {
                    choix2 = scanner.nextInt();
                }catch (InputMismatchException e) {
                    System.out.println("Veuillez entrer un nombre.\nEntrez le nombre : ");
                    scanner.nextLine();
                }

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
