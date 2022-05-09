package Personnages;

public abstract class Combattant extends Personnage {
    protected int vie;
    protected int attaque;
    protected int niveau;
    protected int xp;

    /**
     * Fighter constructor
     * @param nom Fighter's name
     * @param vie Fighter's life
     * @param attaque Fighter's attack
     * @param niveau Fighter's level
     * @param xp Fighter's XP
     */
    public Combattant(String nom, int vie, int attaque, int niveau, int xp){
        super(nom);
        if (vie > 0) {
            this.vie = vie;
        } else {
            System.out.println("Votre vie doit être supérieure à 0");
        }
        this.attaque=attaque;
        this.niveau=niveau;
        this.xp=xp;
    }

    /**
     *
     * @return the level of the fighter
     */
    public int getNiveau() {
        return niveau;
    }

    /**
     *
     * @return the XP of the fighter
     */
    public int getXp() {
        return xp;
    }

    /**
     * Function to pass a level to the fighter
     */
    public void passageNiveau() {
        this.niveau++;
    }

    /**
     *
     * @param xp the XP to add at the fighter
     */
    public void ajouterXp(int xp) {
        this.xp += xp;
    }

    /**
     *
     * @return the life of the fighter
     */
    public int getVie(){
        return vie;
    }

    /**
     *
     * @return the attack of the fighter
     */
    public int getAttaque(){
        return attaque;
    }

    /**
     *
     * @param vie the life to set at the fighter
     */
    public void setVie(int vie){
        this.vie=vie;
    }

    /**
     *
     * @param attaque the attack to set at the fighter
     */
    public void setAttaque(int attaque){
        this.attaque=attaque;
    }

    /**
     *
     * @param vie the life to remove at the fighter
     */
    public void perteVie(int vie){
        this.vie-=vie;
    }

    /**
     *
     * @param c the attack at the fighter
     */
    public abstract void attaque(Combattant c);
}