package Jeu;

import Items.Arme;
import Items.Consommable;
import Items.Item;
import Lieux.Salle;
import Personnages.Boss;
import Personnages.Joueur;
import Personnages.Marchand;

import java.util.*;

public class Jeu {
    public static boolean end = true;
    public static boolean alive = true;
    public static boolean hasKey = false;

    public static int ChoixUser(int nbChoix) {
        Scanner sc = new Scanner(System.in);
        int choix = 0;
        boolean ex = true;
        while ((choix < 1 || choix > nbChoix) && ex) {
            try {
                choix = sc.nextInt();
                ex = false;
            }
            catch (InputMismatchException e) {
                Dialogue.dialogues("Veuillez entrer un nombre");
                sc.nextLine();
            }
            if (choix < 1 || choix > nbChoix) {
                Dialogue.dialogues("Veuillez entrer un nombre entre 1 et " + nbChoix);
            }
        }
        return choix;
    }

    /**
     * Function to change the current room
     * @param j1 the player who is changing the room
     */
    public void ChangerDeSalle(Joueur j1) {
        java.util.Map<Integer, Salle> listeSalle = j1.afficherSalles(Instance.m.getMap());
        for (int key : listeSalle.keySet()) {
            Dialogue.dialogues(key + " - " + listeSalle.get(key).getDescription());
        }
        Dialogue.dialogues("Quelle salle voulez-vous aller ?");
        j1.changerSalle(Instance.m.getMap(), listeSalle.get(ChoixUser(listeSalle.size())));
    }

    /**
     * Function to choose the consumable to use
     * @param j1 the player who is using the consumable
     */
    public void ChoixConsommable(Joueur j1) {
        java.util.Map<Integer, Consommable> listeConsommable = j1.afficherConsommable();
        int max = 0;
        for (int key : listeConsommable.keySet()) {
            Dialogue.dialogues(key + " - " + listeConsommable.get(key).getNom());
            max = key;
        }
        Dialogue.dialogues((max + 1) + " - Retour");
        Dialogue.dialogues("Quel consommable voulez-vous utiliser ?");
        int choix = ChoixUser(listeConsommable.size() + 1);
        if (choix != (max + 1)) {
            j1.utiliserConsommable(listeConsommable.get(choix), false);
        }
    }

    /**
     * Function to choose the weapon to use
     * @param j1 the player who is using the weapon
     */
    public void ChoixArme(Joueur j1) {
        java.util.Map<Integer, Arme> listeArme = j1.afficherArme();
        int max = 0;
        for (int key : listeArme.keySet()) {
            Dialogue.dialogues(key + " - " + listeArme.get(key).getNom());
            max = key;
        }
        Dialogue.dialogues((max + 1) + " - Retour");
        Dialogue.dialogues("Quel arme voulez-vous utiliser ?");
        int choix = ChoixUser(listeArme.size() + 1);
        if (choix != (max + 1)) {
            j1.choisirArme(listeArme.get(choix));
        }
    }

    /**
     * Function to choose what to buy to the trader
     * @param j1 the player who is buying
     */
    public void ChoixMarchand(Joueur j1) {
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
        Dialogue.dialogues("Vous avez " + j1.getOr() + " pi??ces d'or.");
        int max = 0;
        for (int key : listeItem.keySet()) {
            Dialogue.dialogues(key + " - " + listeItem.get(key).getNom() + ", prix : " + listeItem.get(key).getPrix());
            max = key;
        }
        Dialogue.dialogues((max + 1) + " - Retour");
        Dialogue.dialogues("Quel item voulez-vous acheter ?");
        int choix = ChoixUser(listeItem.size() + 1);
        if (choix != (max + 1)) {
            j1.acheterItem(m, listeItem.get(choix));
        }
    }

    /**
     * Function to manage the player's action when he is in a normal room
     * @param j1 the player who is in a normal room
     */
    public void SalleNormal(Joueur j1) {
        Dialogue.dialogues(j1.getSalle().getDescription());
        Dialogue.dialogues("Que voulez-vous faire ?");
        Dialogue.dialogues("1 - Changer de salle");
        Dialogue.dialogues("2 - Utiliser un consommable");
        Dialogue.dialogues("3 - Equiper une arme");

        int choix = ChoixUser(3);
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
        Dialogue.dialogues(j1.getSalle().getDescription());
        Dialogue.dialogues("Que voulez-vous faire ?");
        Dialogue.dialogues("1 - Changer de salle");
        Dialogue.dialogues("2 - Utiliser un consommable");
        Dialogue.dialogues("3 - Equiper une arme");
        Dialogue.dialogues("4 - Acheter un item");

        int choix = ChoixUser(4);
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

    public void SalleFabrice(Joueur j1) {
        if (!hasKey) {
            Dialogue.dialogues("Vous entrez dans cette salle semblant vide, quand vous apercevez arriver par une fissure dans le b??timent un singe, c'est le singe que vous aviez vu pr??c??demment.\n" +
                    "Il est grand et arbore une m??daille avec ??crit \"Fabrice\".\nIl se pose sur une st??le au centre de la salle, vous vous approchez de lui lorsqu'il commence ?? vous tendre un objet.\n" +
                    "Vous prenez l'objet et apercevez qu'il s'agit d'une cl?? assez ??trange.\nUne fois la cl?? r??cup??r??e Fabrice s'enfuit dans l'immense jungle qui vous entoure par la m??me fissure par laquelle il est rentr??.\n");
            SalleNormal(j1);
            hasKey = true;
        }
        else {
            SalleNormal(j1);
        }
    }

    public void SalleMiniBoss(Joueur j1) {
        Dialogue.dialogues("Vous apercevez une silhouette au milieu de la pi??ce...\nQuand soudain elle se met ?? vous attaquer.");
        Combat combat = new Combat(j1, Instance.miniB);
        combat.combat();
        j1.getSalle().setId(1);
    }

    public void SalleBoss(Joueur j1) {
        j1.ajouterItem(Instance.a5);
        j1.choisirArme(Instance.a5);
        Dialogue.dialogues("Vous y ??tes enfin, le pistolet acrobatique est juste devant vous sur sa st??le.\nVous avancez et l'enlevez de sa st??le.\nTout ?? coup, un " +
                "bruit retenti et une forme humaine tomba du ciel. Il ??tait l??, l'indig??ne aux tierlist, entrain de vous sauter dessus en criant ce qui s'apparente ?? son nom, THE STINKY ONE.");
        Combat combat = new Combat(j1, Instance.boss);
        combat.combat();
        if (Instance.boss.getVie() <= 0) {
            end = false;
        }
    }

    /**
     * Function to execute the main code of the game
     */
    public void executer() {
        Instance i = new Instance();
        Joueur j1 = new Joueur("Pilote Canadien",750,100000, Instance.s1);

        Dialogue.dialogues("Vous pilotez un avion en provenance du canada, vous survolez le Mexique et vou... OH NON..." +
                "VOUS PERDEZ LE CONTR??LE DE L'AVION.\nVous vous ??crasez dans la jungle, vous regardez autour de vous et vous voyez un singe portant une m??daille Fabrice, vous marchez en direction du sud... \n" +
                "Quand tout ?? coup un indig??ne sauvage appara??t, il parle dans un vieux fran??ais que vous peinez ?? comprendre,\n" +
                "mais vous discernez tout de m??me une invitation ?? faire une tierlist, vous ??tes alors pris ?? la gorge par une odeur pestilentielle, vous prenez la fuite.\n" +
                "Vous tombez sur un temple maya et d??cidez d'y rentrer, la porte se ferme soudainement, il y fait sombre et vous trouvez un canif enfouis dans votre poche.\n");
        j1.ajouterItem(Instance.a12);
        j1.choisirArme(Instance.a12);
        while (end) {
            if (j1.getSalle().getId() == 1) {
                SalleNormal(j1);
            }
            if (j1.getSalle().getId() == 2) {
                SalleMiniBoss(j1);
            }
            if (j1.getSalle().getId() == 3) {
                SalleMarchand(j1);
            }
            if (j1.getSalle().getId() == 4) {
                SalleFabrice(j1);
            }
            if (j1.getSalle().getId() == 5) {
                SalleBoss(j1);
            }
        }
        if (alive) {
            Dialogue.dialogues("Vous avez vaincu the stinky one !\n");
            Dialogue.dialogues("Vous sortez enfin de ce temple miteux, une soudaine envie de faire un backflip vous prend.\n" +
                    "Vous appercevez au loin un cerf dans la jungle et vous le distinguez entrain de manger un toast.");
        }
    }
}
