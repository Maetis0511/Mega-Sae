package Personnages;

public abstract class Personnage {
    private String nom;
    private String salle;

    public Personnage(String nom) {
        this.nom = nom;
    }

    public void setNom(String nom){
        this.nom=nom;
    }

    public String getNom(){
        return this.nom;
    }

    public String getSalle() {
        return salle;
    }
}

