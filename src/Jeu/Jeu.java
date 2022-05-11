package Jeu;

import Lieux.Salle;
import Personnages.Joueur;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Jeu {
    public void executer() {
        Scanner sc = new Scanner(System.in);
        Instance i = new Instance();
        Joueur j1 = new Joueur("Pilote Canadien",750,1000000,Instance.s1);
        boolean fini = true;

        Dialogue.dialogues("Vous pilotez un avion en provenance du canada, vous survolez le Mexique et vou... OH NON..." +
                "VOUS PERDEZ LE CONTRÔLE DE L'AVION.\nVous vous écrasez dans la jungle, vous regardez autour de vous et vous voyez un singe portant une médaille Fabrice, vous marchez en direction du sud... \n" +
                "Quand tout à coup un indigène sauvage apparaît, il parle dans un vieux français que vous peinez à comprendre,\n" +
                "mais vous discernez tout de même une invitation à faire une tiers list, vous êtes alors pris à la gorge par une odeur pestilentielle, vous prenez la fuite.\n" +
                "Vous tombez sur un temple maya et décidez d'y rentrer, la porte se ferme soudainement, il y fait sombre et vous trouvez un canif enfouis dans votre poche.\n",0);
        while (fini) {
            Dialogue.dialogues(j1.getSalle().getDescription() + "\n",65);
            java.util.Map<Integer, Salle> listeSalle = j1.afficherSalles(Instance.m.getMap());
            int cpt = 0;
            for (int key : listeSalle.keySet()) {
                Dialogue.dialogues(key + " - " + listeSalle.get(key).getNom() + "\n",65);
                cpt++;
            }
            System.out.println("Quelle salle voulez-vous aller ?");
            System.out.println(listeSalle);
            int choix = sc.nextInt();
            System.out.println("CHoix : " + choix);
            System.out.println("listeSalle.get(choix) : " + listeSalle.get(choix));
            j1.changerSalle(Instance.m.getMap(), listeSalle.get(choix));
        }
    }
}
