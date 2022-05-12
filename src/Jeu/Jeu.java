package Jeu;

import Items.Arme;
import Items.Consommable;
import Items.Item;
import Lieux.Salle;
import Personnages.Joueur;
import Personnages.Marchand;

import java.util.*;

public class Jeu {
    /**
     * Function to change the current room
     * @param j1 the player who is changing the room
     */
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

    /**
     * Function to choose the consumable to use
     * @param j1 the player who is using the consumable
     */
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

    /**
     * Function to choose the weapon to use
     * @param j1 the player who is using the weapon
     */
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

    /**
     * Function to choose what to buy to the trader
     * @param j1 the player who is buying
     */
    public void ChoixMarchand(Joueur j1) {
        Scanner sc = new Scanner(System.in);
        Marchand m = new Marchand("Marchand du temple");

        List<Arme> listeArmePossible = new ArrayList<>();

        for (int i = 0; i < Instance.listeArmes.size(); i++) {
            if (Instance.listeArmes.get(i).getPrix() != 0) {
                listeArmePossible.add(Instance.listeArmes.get(i));
            }
        }

        Random r = new Random();

        for (int i = 0; i < 5; i++) {
            int random = r.nextInt(listeArmePossible.size());
            m.ajouterItem(listeArmePossible.get(random));
            listeArmePossible.remove(random);
        }

        java.util.Map<Integer, Arme> listeItem = m.afficherMarchand();
        int max = 0;
        for (int key : listeItem.keySet()) {
            Dialogue.dialogues(key + " - " + listeItem.get(key).getNom() + "\n",100);
            max = key;
        }
        Dialogue.dialogues((max + 1) + " - Retour\n",100);
        System.out.println("Quel item voulez-vous acheter ?");
        int choix = sc.nextInt();
        if (choix != (max + 1)) {
            j1.acheterItem(m, listeItem.get(choix));
        }
    }

    /**
     * Function to manage the player's action when he is in a normal room
     * @param j1 the player who is in a normal room
     */
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

    /**
     * Function to manage the player's action when he is in a trader room
     * @param j1 the player who is in a trader room
     */
    public void SalleMarchand(Joueur j1) {
        Dialogue.dialogues(j1.getSalle().getDescription() + "\n",100);
        System.out.println("Que voulez-vous faire ?");
        System.out.println("1 - Changer de salle");
        System.out.println("2 - Utiliser un consommable");
        System.out.println("3 - Equiper une arme");
        System.out.println("4 - Acheter un item");

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

    /**
     * Function to execute the main code of the game
     */
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
            System.out.println(j1.getSalle().getId());
            if (j1.getSalle().getId() == 1) {
                SalleNormal(j1);
            }
            if (j1.getSalle().getId() == 3) {
                SalleMarchand(j1);
            }
        }
    }
}
