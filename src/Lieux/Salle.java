package Lieux;

import java.util.ArrayList;
import java.util.List;

public class Salle {
    private String nom;
    private String description;
    private List<Piege> pieges;
    private int niveauSalle;


    public Salle(String nom, String description, int niveauSalle) {
        this.nom = nom;
        this.description = description;
        this.pieges = new ArrayList<>();
        this.niveauSalle = niveauSalle;
    }

    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

    public List<Piege> getPieges() {
        return pieges;
    }

    public void addPiege(Piege p) {
        pieges.add(p);
    }
}
