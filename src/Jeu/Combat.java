package Jeu;

import Items.Arme;
import Items.Consommable;
import Personnages.Boss;
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

    /**
     * Fight constructor
     * @param joueur Player who fights
     * @param monstre Monster who fights
     */
    public Combat(Joueur joueur, Hostile monstre) {
        this.joueur = joueur;
        this.monstre = monstre;
        this.boosted = false;
    }

    /**
     * Function that screams a random word when a mob spawn
     */
    public void cri() {
        try {
            File myObj = new File("src/ressources/Wordlist");
            int i = 0;
            int random = (int) (Math.random() * 22737);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if (i == random) {

                    Dialogue.dialogues(this.monstre.getNom()+" crie : " + data);
                }
                i++;

            }
            myReader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Function to manage player combat
     * @param buffs List of buffs
     */
    public void combatStep(List<Buff> buffs) {
        if (Boss.isArmor){
            BuffBoosted buffArmor = new BuffBoosted(0, 2);
            buffs.add(buffArmor);
            Dialogue.dialogues("Que voulez vous faire ?");
            Dialogue.dialogues("1 - Attaquer");
            Dialogue.dialogues("2 - Utiliser un consommable");
            int choix = Jeu.ChoixUser(2);

            if (choix == 1) {
                Dialogue.dialogues("Vous pouvez :");
                Dialogue.dialogues("1 - Attaquer avec votre arme");
                Dialogue.dialogues("2 - Utiliser un sort augmentant votre attaque durant 2 tours");
                int choix2 = Jeu.ChoixUser(2);
                if (choix2 == 1) {
                    joueur.attaque(monstre);
                    joueur.perteVie(25);
                    Dialogue.dialogues("Vous avez perdu 25 points de vie à en tapant THE STINKY ONE qui avait son armure de puanteur");
                }
                else if (choix2 == 2) {
                    Dialogue.dialogues("Votre attaque est boostée pendant 2 tours");
                    joueur.setAttaque((int) (joueur.getAttaque() * 1.5));
                    BuffAttaque buff = new BuffAttaque(1.5, 3);
                    buffs.add(buff);
                }
            }
            else if (choix == 2) {
                Dialogue.dialogues("Que voulez vous utiliser ?");
                java.util.Map<Integer, Consommable> listeConsommable = joueur.afficherConsommable();
                int max = 0;
                for (int key : listeConsommable.keySet()) {
                    Dialogue.dialogues(key + " - " + listeConsommable.get(key).getNom() + "\n");
                    max = key;
                }
                Dialogue.dialogues((max + 1) + " - Retour\n");
                int choix2 = Jeu.ChoixUser(listeConsommable.size() + 1);

                if (choix2 != max + 1) {
                    this.boosted = joueur.utiliserConsommable((Consommable) joueur.getInventaire().get(0).get(choix2 - 1), true);
                    if (this.boosted) {
                        BuffBoosted buff = new BuffBoosted(2, 2);
                        buffs.add(buff);
                    }
                }
            }
            else if (choix == 3) {
                combatStep(buffs);
            }
        }
        else {
            Dialogue.dialogues("Que voulez vous faire ?");
            Dialogue.dialogues("1 - Attaquer");
            Dialogue.dialogues("2 - Utiliser un consommable");
            int choix = Jeu.ChoixUser(2);

            if (choix == 1) {
                Dialogue.dialogues("Vous pouvez :");
                Dialogue.dialogues("1 - Attaquer avec votre arme");
                Dialogue.dialogues("2 - Utiliser un sort augmentant votre attaque durant 2 tours");
                int choix2 = Jeu.ChoixUser(2);
                if (choix2 == 1) {
                    joueur.attaque(monstre);
                }
                else if (choix2 == 2) {
                    Dialogue.dialogues("Votre attaque est boostée pendant 2 tours");
                    joueur.setAttaque((int) (joueur.getAttaque() * 1.5));
                    BuffAttaque buff = new BuffAttaque(1.5, 3);
                    buffs.add(buff);
                }
            }
            else if (choix == 2) {
                Dialogue.dialogues("Que voulez vous utiliser ?");
                java.util.Map<Integer, Consommable> listeConsommable = joueur.afficherConsommable();
                int max = 0;
                for (int key : listeConsommable.keySet()) {
                    Dialogue.dialogues(key + " - " + listeConsommable.get(key).getNom() + "\n");
                    max = key;
                }
                Dialogue.dialogues((max + 1) + " - Retour\n");
                int choix2 = Jeu.ChoixUser(listeConsommable.size() + 1);

                if (choix2 != max + 1) {
                    this.boosted = joueur.utiliserConsommable((Consommable) joueur.getInventaire().get(0).get(choix2 - 1), true);
                    if (this.boosted) {
                        BuffBoosted buff = new BuffBoosted(2, 2);
                        buffs.add(buff);
                    }
                }
            }
            else if (choix == 3) {
                combatStep(buffs);
            }
        }
    }

    /**
     * Function to mange the combat
     */
    public void combat() {
        Dialogue.dialogues("Un " + this.monstre.getNom().toLowerCase(Locale.ROOT) + " sauvage apparait, de niveau " + this.monstre.getNiveau() + " !");
        cri();
        List<Buff> buffs = new ArrayList<>();
        while (joueur.getVie() > 0 && monstre.getVie() > 0) {

            Dialogue.dialogues("Il vous reste " + joueur.getVie() + " points de vie");
            Dialogue.dialogues("Il reste " + monstre.getVie() + " points de vie à " + monstre.getNom());

            boolean ex = true;

            //c1 attaque c2

            combatStep(buffs);

            if (boosted) {
                combatStep(buffs);
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
            Dialogue.dialogues("Vous remportez le combat !");
            Random rd = new Random();
            int nb = rd.nextInt(40) + 80;
            int nb2 = rd.nextInt(80) + 40;
            joueur.ajouterXp(nb * monstre.getNiveau());
            joueur.ajouterOr(nb2);
            if (monstre.getLoot() != null) {
                joueur.ajouterItem(monstre.getLoot());
            }
        }
        if (monstre.getVie() > 0) {
            Jeu.end = false;
            Jeu.alive = false;
            Dialogue.dialogues("Vous avez été tué par " + monstre.getNom());
        }
    }
}
