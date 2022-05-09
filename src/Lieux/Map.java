package Lieux;

import java.util.Set;

public class Map {
    private Graphe<Salle> map;

    /**
     * Map constructor
     */
    public Map() {
        this.map = new Graphe<Salle>();
    }

    /**
     *
     * @param s Room to add at the map
     */
    public void addSalle(Salle s) {
        this.map.ajouterSommet(s);
    }

    /**
     *
     * @param s1 Room 1 to add at the map
     * @param s2 Room 2 to add at the map
     */
    public void addLien(Salle s1, Salle s2) {
        this.map.ajouterArete(s1, s2, 1);
    }

    public Set<Salle> sallesAdjacentes(Salle s) {
        return this.map.getVoisins(s);
    }
}
