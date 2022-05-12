package Jeu;

import Items.Arme;
import Items.Item;
import Items.Consommable;
import Lieux.Map;
import Lieux.Salle;
import Personnages.Hostile;
import Personnages.Joueur;

import java.util.ArrayList;
import java.util.List;

public class Instance {
    public static List<Arme> listeArmes;
    public static List<Consommable> listeConsommables;
    public static Map m;
    public static Salle s1 = new Salle("Salle 1", "Entrée du temple miteux", 1, 1);

    public Instance() {
        listeArmes = new ArrayList<>();
        Arme a1 = new Arme("Épée", 3, "Épée rouillé", 150);
        Arme a2 = new Arme("Arbalette", 3, "", 200);
        Arme a3 = new Arme("Lame de Doran", 3, "Un bon item à 450", 250, 180);
        Arme a4 = new Arme("Babouche de la grand-mère", 3, "", 300);
        Arme a5 = new Arme("Pistolet accrobatique", 3, "Relique du temple Miteux", 450);
        Arme a6 = new Arme("Hache du berserk", 3, "", 150);
        Arme a7 = new Arme("Kunaî", 3, "", 200, 150);
        Arme a8 = new Arme("Katana", 3, "", 250, 180);
        Arme a9 = new Arme("Arc", 3, "", 300, 400);
        Arme a10 = new Arme("Torche", 3, "", 230);
        Arme a11 = new Arme("Couperet noir", 3, "", 150, 300);
        Arme a12 = new Arme("Canif", 3, "", 200, 240);
        Arme a13 = new Arme("Pied de biche", 3, "", 250, 180);
        Arme a14 = new Arme("Lance pierre", 3, "", 300);
        Arme a15 = new Arme("", 3, "", 450);
        Arme a16 = new Arme("", 3, "", 150);
        Arme a17 = new Arme("", 3, "", 200);
        Arme a18 = new Arme("", 3, "", 250, 180);
        Arme a19 = new Arme("", 3, "", 300);
        Arme a20 = new Arme("", 3, "", 450);

        listeArmes.add(a1);
        listeArmes.add(a2);
        listeArmes.add(a3);
        listeArmes.add(a4);
        listeArmes.add(a5);
        listeArmes.add(a6);
        listeArmes.add(a7);
        listeArmes.add(a8);
        listeArmes.add(a9);
        listeArmes.add(a10);
        listeArmes.add(a11);
        listeArmes.add(a12);
        listeArmes.add(a13);
        listeArmes.add(a14);
        listeArmes.add(a15);
        listeArmes.add(a16);
        listeArmes.add(a17);
        listeArmes.add(a18);
        listeArmes.add(a19);
        listeArmes.add(a20);

        Salle s2 = new Salle("Salle 2", "Salle normal", 2, 1);
        Salle s3 = new Salle("Salle 3", "Salle piègé", 2, 1);
        Salle s4 = new Salle("Salle 4", "Salle de Boss", 3, 2);
        Salle s5 = new Salle("Salle 5", "Salle normal", 3, 1);
        Salle s6 = new Salle("Salle 6", "Salle avec marchand", 3, 3);
        Salle s7 = new Salle("Salle 7", "Salle piègé", 4, 1);
        Salle s8 = new Salle("Salle 8", "Salle clé", 4, 4);
        Salle s9 = new Salle("Salle 9", "Salle normal", 5, 1);
        Salle s10 = new Salle("Salle 10", "Salle normal ", 6, 1);
        Salle s11 = new Salle("Salle 11", "Salle normal ", 5, 1);
        Salle s12 = new Salle("Salle 12", "Salle normal ", 5, 1);
        Salle s13 = new Salle("Salle 13", "Salle piègé", 5, 1);
        Salle s14 = new Salle("Salle 14", "Salle normal", 6, 1);
        Salle s15 = new Salle("Salle 15", "Salle piègé", 6, 1);
        Salle s16 = new Salle("Salle 16", "Salle piègé", 7, 1);
        Salle s17 = new Salle("Salle 17", "Salle normal", 7, 1);
        Salle s18 = new Salle("Salle 18", "Salle normal", 7, 1);
        Salle s19 = new Salle("Salle 19", "Salle avec marchand", 8, 3);
        Salle s20 = new Salle("Salle 20", "Salle Boss", 9, 2);

        m = new Map();

        m.addLien(s1, s2);
        m.addLien(s1, s3);
        m.addLien(s2, s5);
        m.addLien(s3, s6);
        m.addLien(s6, s5);
        m.addLien(s5, s4);
        m.addLien(s5, s7);
        m.addLien(s7, s8);
        m.addLien(s6, s13);
        m.addLien(s13, s14);
        m.addLien(s13, s12);
        m.addLien(s7, s9);
        m.addLien(s5, s11);
        m.addLien(s5, s12);
        m.addLien(s11, s10);
        m.addLien(s9, s10);
        m.addLien(s12, s15);
        m.addLien(s14, s18);
        m.addLien(s12, s18);
        m.addLien(s10, s16);
        m.addLien(s15, s16);
        m.addLien(s15, s17);
        m.addLien(s17, s19);
        m.addLien(s16, s19);
        m.addLien(s18, s19);
        m.addLien(s19, s20);

        listeConsommables = new ArrayList<>();

        Consommable c1 = new Consommable("Nachos", 1, "Un nachos miteux", 100);
        Consommable c2 = new Consommable("Nachos étrange", 2, "Un nachos brillant", 2);

        listeConsommables.add(c1);
        listeConsommables.add(c2);
    }
}
