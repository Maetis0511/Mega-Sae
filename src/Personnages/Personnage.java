package Personnages;

public abstract class Personnage {
    private String nom;
    private String salle;

    /**
     * Character's constructor
     * @param nom Character's name
     */
    public Personnage(String nom) {
        this.nom = nom;
    }

    /**
     *
     * @return Character's name
     */
    public String getNom(){
        return this.nom;
    }

    /**
     *
     * @return Character's room
     */
    public String getSalle() {
        return salle;
    }
}

