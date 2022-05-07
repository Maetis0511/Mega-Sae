package Lieux;

import java.util.Set;

public class Map {
    private Graphe<Salle> map;

    public Map() {
        this.map = new Graphe<Salle>();
    }

    public void addSalle(Salle s) {
        this.map.ajouterSommet(s);
    }

    public void addLien(Salle s1, Salle s2) {
        this.map.ajouterArete(s1, s2, 1);
    }

    public Set<Salle> sallesAdjacentes(Salle s) {
        return this.map.getVoisins(s);
    }
}
