package Personnages;

public class Personnages{
    protected String nom;
    protected int vie;
    protected int attaque;
    protected int niveau;
    protected int xp;

    public Personnages(String nom, int vie, int attaque,int niveau, int xp){
        this.nom=nom;
        this.vie=vie;
        this.attaque=attaque;
        this.niveau=niveau;
        this.xp=xp;
    }

    public int getNiveau() {
        return niveau;
    }

    public int getXp() {
        return xp;
    }

    public void passageNiveau() {
        this.niveau++;
    }

    public void ajouterXp(int xp) {
        this.xp += xp;
    }

    public String getNom(){
        return nom;
    }

    public int getVie(){
        return vie;
    }

    public int getAttaque(){
        return attaque;
    }

    public void setNom(String nom){
        this.nom=nom;
    }

    public void setVie(int vie){
        this.vie=vie;
    }

    public void setAttaque(int attaque){
        this.attaque=attaque;
    }

    public void perteVie(int vie){
        this.vie-=vie;
    }

    public void gainVie(int vie){
        this.vie+=vie;
    }
}