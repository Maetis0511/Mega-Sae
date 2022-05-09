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
     * Function to add a room to the map
     * @param s Room to add
     */
    public void addSalle(Salle s) {
        this.map.ajouterSommet(s);
    }

    /**
     * Function to links two rooms
     * @param s1 Room 1
     * @param s2 Room 2
     */
    public void addLien(Salle s1, Salle s2) {
        this.map.ajouterArete(s1, s2, 1);
    }

    /**
     * Function to return neighbors of a room
     * @param s Room to get neighbors from
     * @return neighbors of the room
     */
    public Set<Salle> sallesAdjacentes(Salle s) {
        return this.map.getVoisins(s);
    }

    public Graphe<Salle> getMap() {
        return this.map;
    }
}
