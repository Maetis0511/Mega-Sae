package Lieux;

import java.util.ArrayList;
import java.util.List;

public class Salle {
    private String nom;
    private String description;
    private List<Piege> pieges;


    public Salle(String nom, String description) {
        this.nom = nom;
        this.description = description;
        this.pieges = new ArrayList<>();
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
