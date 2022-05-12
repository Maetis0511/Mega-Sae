package Lieux;

import java.util.ArrayList;
import java.util.List;

public class Salle {
    private String nom;
    private int id;
    private String description;
    private List<Piege> pieges;
    private int niveauSalle;

    /**
     * Room's constructor
     * @param nom Room's name
     * @param description Room's description
     * @param niveauSalle Room's level
     */
    public Salle(String nom, String description, int niveauSalle, int id) {
        this.nom = nom;
        this.description = description;
        this.pieges = new ArrayList<>();
        this.niveauSalle = niveauSalle;
        this.id = id;
    }

    /**
     *
     * @return Room's name
     */
    public String getNom() {
        return nom;
    }

    /**
     *
     * @return Room's description
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @return Room's traps
     */
    public List<Piege> getPieges() {
        return pieges;
    }

    /**
     * Add a trap to the room
     * @param p Trap to add
     */
    public void addPiege(Piege p) {
        pieges.add(p);
    }

    /**
     *
     * @return Room's level
     */
    public int getNiveauSalle() {
        return niveauSalle;
    }

    /**
     *
     * @return Room's id
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return Room's name and description
     */
    public String toString() {
        return nom;
    }
}
