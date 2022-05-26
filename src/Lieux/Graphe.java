package Lieux;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Graphe<E> {
    private final Map<E, Map<E, Integer>> listeAdjacence = new HashMap<E, Map<E, Integer>>();
    private final boolean oriente;

    /**
     * Graph constructor with orientation
     * @param oriente true if the graph is oriented
     */
    public Graphe(boolean oriente) {
        this.oriente = oriente;
    }

    /**
     * Graph constructor without orientation
     */
    public Graphe() {
        this(false);
    }

    /**
     * Add a vertex to the graph
     * @param sommet the vertex to add
     */
    public void ajouterSommet(E sommet) {
        if(!this.listeAdjacence.containsKey(sommet)) {
            this.listeAdjacence.put(sommet, new HashMap<E, Integer>());
        }
    }

    public void supprimerArete(E sommet1, E sommet2) {
        this.listeAdjacence.get(sommet1).remove(sommet2);
        if(!this.oriente) {
            this.listeAdjacence.get(sommet2).remove(sommet1);
        }
    }

    /**
     * Add an edge to the graph
     * @param source the source vertex
     * @param destination the destination vertex
     * @param poids the weight of the edge
     */
    public void ajouterArete(E source, E destination, int poids) {
        this.ajouterSommet(source);
        this.ajouterSommet(destination);
        Map<E, Integer> voisinsSource = this.listeAdjacence.get(source);
        voisinsSource.put(destination, poids);
        if(!oriente) {
            Map<E, Integer> voisinsDestination = this.listeAdjacence.get(destination);
            voisinsDestination.put(source, poids);
        }
    }

    /**
     *
     * @return Graph's vertices
     */
    public Set<E> getSommets() {
        return this.listeAdjacence.keySet();
    }

    /**
     *
     * @param source the source vertex
     * @return the neighbors of the source vertex
     */
    public Set<E> getVoisins(E source) {
        if(this.listeAdjacence.containsKey(source)) {
            return this.listeAdjacence.get(source).keySet();
        }

        return null;
    }

    /**
     *
     * @param source the source vertex
     * @param destination the destination vertex
     * @return the weight of the edge between the source and the destination vertex
     */
    public int getPoids(E source, E destination) {
        if(this.listeAdjacence.containsKey(source)) {
            Map<E, Integer> voisinsSource = this.listeAdjacence.get(source);
            if(voisinsSource.containsKey(destination)) {
                return voisinsSource.get(destination);
            }
        }
        return -1;
    }

    /**
     *
     * @return graph in dot format
     */
    public String toString() {
        String direction = oriente ? "->" : "--";
        String graphData = this.oriente ? "digraph" : "strict graph";
        graphData += "{\n";
        Map<E, Integer> idsForGeneration = new HashMap<>();
        int i = 0;
        for(E donnee : this.listeAdjacence.keySet()) {
            idsForGeneration.put(donnee, i);
            graphData += String.format("%s[label=\"%s\"]\n", i, donnee);
            i++;
        }
        for(E donnee : this.listeAdjacence.keySet()) {
            Map<E, Integer> voisinsSource = this.listeAdjacence.get(donnee);
            for(E voisin : voisinsSource.keySet()) {
                graphData += String.format("%s %s %s[label=\"%s\"]\n", idsForGeneration.get(donnee), direction, idsForGeneration.get(voisin), voisinsSource.get(voisin));
            }
        }
        graphData += "}";
        return graphData;
    }
}
