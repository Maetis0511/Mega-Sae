package Personnages;

public abstract class Combattant extends Personnage {
    protected int viemax;
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

        this.vie = vie;
        this.viemax = vie;
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
     * Function to add XP at the fighter
     * @param xp the XP to add
     */
    public void ajouterXp(int xp) {
        System.out.println("Vous avez gagnes " + xp + " points d'XP");
        this.xp += xp;
        if (this.getXp() >= 1000*(0.25*(this.getNiveau()+1))) {
            System.out.println("Vous avez atteint le niveau " + (this.getNiveau()+1));
            this.niveau++;
            this.viemax = this.viemax + 20;
            this.attaque = this.attaque + 20;
            this.vie = this.vie + 20;
            if(this.vie > this.viemax) {
                this.vie = this.viemax;
            }
            this.xp = 0;
        }
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
     * Function to set the life of the fighter
     * @param vie the life to set
     */
    public void setVie(int vie){
        this.vie=vie;
    }

    /**
     * Function to set the attack of the fighter
     * @param attaque the attack to set
     */
    public void setAttaque(int attaque){
        this.attaque=attaque;
    }

    /**
     * Function to remove life from the fighter
     * @param vie the life to remove
     */
    public void perteVie(int vie){
        this.vie-=vie;
    }

    /**
     * Function to manage the action of attacking
     * @param c the attack at the fighter
     */
    public abstract void attaque(Combattant c);
}