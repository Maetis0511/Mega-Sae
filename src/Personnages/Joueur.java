package Personnages;

import Items.*;
import Jeu.Combat;
import Jeu.Instance;
import Lieux.Graphe;
import Lieux.Salle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Joueur extends Combattant {
    private List<List<Item>> inventaire;
    private int or;
    private Arme armeActive;
    private Salle pos;

    /**
     * Player constructor
     * @param nom Player's name
     * @param vie Player's life
     * @param attaque Player's attack
     * @param s Player's room
     */
    public Joueur(String nom, int vie, int attaque, Salle s) {
        super(nom,vie,attaque,1,0);
        this.inventaire = new ArrayList<>(2);
        for (int i = 0; i < 2; i++) {
            this.inventaire.add(new ArrayList<>());
        }
        this.armeActive = armeActive;

        this.pos = s;
    }

    /**
     *
     * @param item Item to add to the player's inventory
     */
    public void ajouterItem(Item item) {
        if (item instanceof Consommable) {
            this.inventaire.get(0).add(item);
        }
        else if (item instanceof Arme) {
            this.inventaire.get(1).add(item);
        }
    }

    /**
     *
     * @return Player's inventory
     */
    public List<List<Item>> getInventaire() {
        return this.inventaire;
    }

    /**
     * Function to remove an item from the player's inventory
     * @param item Item to remove
     */
    public void retirerItem(Item item) {
        this.inventaire.remove(item);
    }

    /**
     * Function to display the player's inventory
     */
    public void afficherInventaire() {
        System.out.println("1 - Consommables");
        for (int i = 0; i < inventaire.get(0).size(); i++) {
            System.out.println((i + 1) + " - " + inventaire.get(0).get(i).getNom());
        }
        System.out.println("2 - Armes");
        for (int i = 0; i < inventaire.get(1).size(); i++) {
            System.out.println((i + 1) + " - " + inventaire.get(1).get(i).getNom());
        }
    }

    /**
     * Function to display the player's consumables
     */
    public void afficherConsommable() {
        for (int i = 0; i < inventaire.get(0).size(); i++) {
            System.out.println((i + 1) + " - " + inventaire.get(0).get(i).getNom());
        }
    }

    /**
     * Function to display the player's weapons
     */
    public void afficherArme() {
        for (int i = 0; i < inventaire.get(1).size(); i++) {
            System.out.println((i + 1) + " - " + inventaire.get(1).get(i).getNom());
        }
    }

    /**
     * Function to choose a player's weapon
     */
    public void choisirArme() {
        System.out.println("Que voulez vous utiliser ?");
        afficherArme();
        Scanner scanner = new Scanner(System.in);
        int choix = scanner.nextInt();
        this.armeActive = (Arme) this.inventaire.get(choix - 1);
    }

    /**
     * Set player's attack
     * @param c the attack at the fighter
     */
    public void attaque(Combattant c) {
        if (this.armeActive != null) {
            c.perteVie(this.getAttaque() + this.armeActive.getDegats());
            System.out.println("Vous attaquez " + c.getNom() + " avec votre arme et lui avez infligé " + this.getAttaque() + this.armeActive.getDegats() + " points de dégats");
        }
        else {
            c.perteVie(this.getAttaque());
            System.out.println("Vous attaquez " + c.getNom() + " et lui avez infligé " + this.getAttaque() + " points de dégats");
        }
    }

    /**
     * Function to use a consumable
     * @param conso the consumable to use
     * @param inFight true if the player is in a fight
     * @return true if "nachos étranges" is used
     */
    public boolean utiliserConsommable(Consommable conso, boolean inFight) {
        if (conso.getId() == 1) {
            this.setVie(this.getVie() + conso.getValue());
            return false;
        }
        else if (inFight && conso.getId() == 2) {
            System.out.println("Vous avez mangé le nachos étrange, sensation étrange, c'est comme si vous pouviez attaquer 2 fois par tour, drôle de sensation");
            return true;
        }
        else if (!inFight && conso.getId() == 2) {
            System.out.println("Vous ne pouvez pas mangé le nachos étrange ici, gardez le pour un combat ou vous aurez faim");
            return false;
        }
        return false;
    }

    /**
     * Function to change room
     * @param map the map
     * @param s Position where the player goes
     * @return true if the room is accessible
     */
    public boolean changerSalle(Graphe<Salle> map, Salle s) {
        for (Salle salle : map.getVoisins(this.pos)) {
            if (salle.getId() == s.getId()) {
                this.pos = salle;
                if (salle.getId() == 1) {
                    Random rd = new Random();
                    int nb = rd.nextInt(100);
                    if (nb < 83) {
                        int nb2 = rd.nextInt(100);
                        int nb3 = rd.nextInt(100);
                        int nb4 = rd.nextInt(100);
                        if (nb2 <= 19) {
                            if (nb3 < 81) {
                                if (nb4 < 1) {
                                    Hostile mob = new Hostile("Jeune nachos miteux", s.getNiveauSalle() * 170, s.getNiveauSalle() * 32, Instance.listeConsommables.get(1), s);
                                    Combat c = new Combat(this, mob);
                                    c.combat();
                                }else {
                                    Hostile mob = new Hostile("Jeune nachos miteux", s.getNiveauSalle() * 170, s.getNiveauSalle() * 32,Instance.listeConsommables.get(0), s);
                                    Combat c = new Combat(this, mob);
                                    c.combat();
                                }

                            }
                            else {
                                Hostile mob = new Hostile("Jeune nachos miteux", s.getNiveauSalle() * 170, s.getNiveauSalle() * 32, s);
                                Combat c = new Combat(this, mob);
                                c.combat();
                            }
                        }
                        if (nb2 > 19 && nb2 <= 39) {
                            if (nb3 < 81) {
                                if (nb4 < 1) {
                                    Hostile mob = new Hostile("Jeune nachos miteux", s.getNiveauSalle() * 170, s.getNiveauSalle() * 32, Instance.listeConsommables.get(1), s);
                                    Combat c = new Combat(this, mob);
                                    c.combat();
                                }else {
                                    Hostile mob = new Hostile("Jeune nachos miteux", s.getNiveauSalle() * 170, s.getNiveauSalle() * 32,Instance.listeConsommables.get(0), s);
                                    Combat c = new Combat(this, mob);
                                    c.combat();
                                }
                            }
                            else {
                                Hostile mob = new Hostile("Jeune nachos miteux", s.getNiveauSalle() * 170, s.getNiveauSalle() * 32, s);
                                Combat c = new Combat(this, mob);
                                c.combat();
                            }
                        }
                        if (nb2 > 39 && nb2 <= 59) {
                            if (nb3 < 81) {
                                if (nb4 < 1) {
                                    Hostile mob = new Hostile("Jeune nachos miteux", s.getNiveauSalle() * 170, s.getNiveauSalle() * 32, Instance.listeConsommables.get(1), s);
                                    Combat c = new Combat(this, mob);
                                    c.combat();
                                }else {
                                    Hostile mob = new Hostile("Jeune nachos miteux", s.getNiveauSalle() * 170, s.getNiveauSalle() * 32,Instance.listeConsommables.get(0), s);
                                    Combat c = new Combat(this, mob);
                                    c.combat();
                                }
                            }
                            else {
                                Hostile mob = new Hostile("Jeune nachos miteux", s.getNiveauSalle() * 170, s.getNiveauSalle() * 32, s);
                                Combat c = new Combat(this, mob);
                                c.combat();
                            }
                        }
                        if (nb2 > 59 && nb2 <= 79) {
                            if (nb3 < 81) {
                                if (nb4 < 1) {
                                    Hostile mob = new Hostile("Jeune nachos miteux", s.getNiveauSalle() * 170, s.getNiveauSalle() * 32, Instance.listeConsommables.get(1), s);
                                    Combat c = new Combat(this, mob);
                                    c.combat();
                                }else {
                                    Hostile mob = new Hostile("Jeune nachos miteux", s.getNiveauSalle() * 170, s.getNiveauSalle() * 32,Instance.listeConsommables.get(0), s);
                                    Combat c = new Combat(this, mob);
                                    c.combat();
                                }
                            }
                            else {
                                Hostile mob = new Hostile("Jeune nachos miteux", s.getNiveauSalle() * 170, s.getNiveauSalle() * 32, s);
                                Combat c = new Combat(this, mob);
                                c.combat();
                            }
                        }
                        if (nb2 > 79) {
                            if (nb3 < 81) {
                                if (nb4 < 1) {
                                    Hostile mob = new Hostile("Jeune nachos miteux", s.getNiveauSalle() * 170, s.getNiveauSalle() * 32, Instance.listeConsommables.get(1), s);
                                    Combat c = new Combat(this, mob);
                                    c.combat();
                                }else {
                                    Hostile mob = new Hostile("Jeune nachos miteux", s.getNiveauSalle() * 170, s.getNiveauSalle() * 32,Instance.listeConsommables.get(0), s);
                                    Combat c = new Combat(this, mob);
                                    c.combat();
                                }
                            }
                            else {
                                Hostile mob = new Hostile("Jeune nachos miteux", s.getNiveauSalle() * 170, s.getNiveauSalle() * 32, s);
                                Combat c = new Combat(this, mob);
                                c.combat();
                            }
                        }
                    }
                }
                return true;
            }
        }
        System.out.println("Cette salle n'est pas accessible");
        return false;
    }

    /**
     * Function to display the room where the player is
     */
    public void afficherPosition() {
        System.out.println(this.pos.getNom());
    }

    /**
     * Function to display accessible rooms
     * @param map the map
     */
    public void afficherSalles(Graphe<Salle> map) {
        System.out.println("Salles accessible :");
        int cpt = 1;
        for (Salle s : map.getVoisins(this.pos)) {
            System.out.println(cpt + " - " + s.getNom());
            cpt++;
        }
    }

    /**
     *
     * @return the player's money
     */
    public int getOr() {
        return this.or;
    }

    /**
     * Function to add money
     * @param or the money to add
     */
    public void ajouterOr(int or) {
        this.or = this.or+or;
    }

    /**
     * Function to remove money
     * @param or the money to remove
     */
    public void retirerOr(int or) {
        this.or = this.or-or;
    }

    /**
     * Function to increase the player's statistics when he gets a new level
     */
    public void passageNiveau() {
        if (this.getXp() >= 1000*(0.25*(this.getNiveau()+1))) {
            niveau++;
            attaque = attaque + 20;
            vie = vie + 20;
        }
    }

    /**
     * Function to buy from a trader
     * @param m the trader
     */
    public void achatMarchand(Marchand m) {

        System.out.println("Que voulez vous acheter ?");
        for (int i = 0; i < m.getInventaire().size(); i++) {
            System.out.println(i+1 + "- " + m.getInventaire().get(i).getNom());
        }
        boolean fini = true;
        Scanner scanner = new Scanner(System.in);
        while (fini) {
            try {
                int choix = scanner.nextInt() - 1 % m.getInventaire().size() + 1;
                if (m.getInventaire().get(choix).getPrix() <= this.or) {
                    this.ajouterItem(m.getInventaire().get(choix));
                    m.getInventaire().remove(choix);
                    this.retirerOr(m.getInventaire().get(choix).getPrix());
                    fini = false;
                }
            } catch (Exception e) {
                System.out.println("Veuillez entrer un nombre");
                scanner.nextLine();
            }
        }


        }

    /**
     * @return true if the player is alive
     */
    public boolean estEnVie() {
        if (this.getVie() > 0) {
            return true;
        }
        return false;
    }
}


