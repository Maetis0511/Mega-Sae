package Jeu;

import Items.Arme;
import Items.Consommable;
import Lieux.Salle;
import Personnages.Joueur;
import Personnages.Marchand;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Jeu {
    public void ChangerDeSalle(Joueur j1) {
        Scanner sc = new Scanner(System.in);
        java.util.Map<Integer, Salle> listeSalle = j1.afficherSalles(Instance.m.getMap());
        for (int key : listeSalle.keySet()) {
            Dialogue.dialogues(key + " - " + listeSalle.get(key).getNom() + "\n",100);
        }
        System.out.println("Quelle salle voulez-vous aller ?");
        int choix = sc.nextInt();
        j1.changerSalle(Instance.m.getMap(), listeSalle.get(choix));
    }

    public void ChoixConsommable(Joueur j1) {
        Scanner sc = new Scanner(System.in);
        java.util.Map<Integer, Consommable> listeConsommable = j1.afficherConsommable();
        int max = 0;
        for (int key : listeConsommable.keySet()) {
            Dialogue.dialogues(key + " - " + listeConsommable.get(key).getNom() + "\n",100);
            max = key;
        }
        Dialogue.dialogues((max + 1) + " - Retour\n",100);
        System.out.println("Quel consommable voulez-vous utiliser ?");
        int choix = sc.nextInt();
        if (choix != (max + 1)) {
            j1.utiliserConsommable(listeConsommable.get(choix), false);
        }
    }

    public void ChoixArme(Joueur j1) {
        Scanner sc = new Scanner(System.in);
        java.util.Map<Integer, Arme> listeArme = j1.afficherArme();
        int max = 0;
        for (int key : listeArme.keySet()) {
            Dialogue.dialogues(key + " - " + listeArme.get(key).getNom() + "\n",100);
            max = key;
        }
        Dialogue.dialogues((max + 1) + " - Retour\n",100);
        System.out.println("Quel arme voulez-vous utiliser ?");
        int choix = sc.nextInt();
        if (choix != (max + 1)) {
            j1.choisirArme(listeArme.get(choix));
        }
    }

    public void ChoixMarchand(Joueur j1) {
        Scanner sc = new Scanner(System.in);
        Marchand m = new Marchand("Marchand du temple");
        m.afficherInventaire();
    }

    public void SalleNormal(Joueur j1) {
        Dialogue.dialogues(j1.getSalle().getDescription() + "\n",100);
        System.out.println("Que voulez-vous faire ?");
        System.out.println("1 - Changer de salle");
        System.out.println("2 - Utiliser un consommable");
        System.out.println("3 - Equiper une arme");

        Scanner sc = new Scanner(System.in);
        int choix = sc.nextInt();
        switch (choix) {
            case 1:
                ChangerDeSalle(j1);
                break;
            case 2:
                ChoixConsommable(j1);
                break;
            case 3:
                ChoixArme(j1);
                break;
        }
    }

    public void SalleMarchand(Joueur j1) {
        Dialogue.dialogues(j1.getSalle().getDescription() + "\n",100);
        System.out.println("Que voulez-vous faire ?");
        System.out.println("1 - Changer de salle");
        System.out.println("2 - Utiliser un consommable");
        System.out.println("3 - Equiper une arme");

        Scanner sc = new Scanner(System.in);
        int choix = sc.nextInt();
        switch (choix) {
            case 1:
                ChangerDeSalle(j1);
                break;
            case 2:
                ChoixConsommable(j1);
                break;
            case 3:
                ChoixArme(j1);
                break;
            case 4:
                ChoixMarchand(j1);
                break;
        }
    }

    public void executer() {
        Instance i = new Instance();
        Joueur j1 = new Joueur("Pilote Canadien",750,1000000,Instance.s1);
        boolean fini = true;

        Dialogue.dialogues("Vous pilotez un avion en provenance du canada, vous survolez le Mexique et vou... OH NON..." +
                "VOUS PERDEZ LE CONTRÔLE DE L'AVION.\nVous vous écrasez dans la jungle, vous regardez autour de vous et vous voyez un singe portant une médaille Fabrice, vous marchez en direction du sud... \n" +
                "Quand tout à coup un indigène sauvage apparaît, il parle dans un vieux français que vous peinez à comprendre,\n" +
                "mais vous discernez tout de même une invitation à faire une tiers list, vous êtes alors pris à la gorge par une odeur pestilentielle, vous prenez la fuite.\n" +
                "Vous tombez sur un temple maya et décidez d'y rentrer, la porte se ferme soudainement, il y fait sombre et vous trouvez un canif enfouis dans votre poche.\n",0);
        while (fini) {
            if (j1.getSalle().getId() == 1) {
                SalleNormal(j1);
            }
            if (j1.getSalle().getId() == 3) {
                SalleMarchand(j1);
            }
        }
    }
}