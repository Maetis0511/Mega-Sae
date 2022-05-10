package Items;

public abstract class Item {
    private String name;
    private int id;
    private String description;
    private int prix;

    /**
     * Item constructor
     *
     * @param name        Item's name
     * @param id          Item's id
     * @param description Item's description
     */
    public Item(String name, int id, String description, int prix) {
        this.name = name;
        this.id = id;
        this.description = description;
        this.prix = prix;
    }

    public Item(String name, int id, String description) {
        this.name = name;
        this.id = id;
        this.description = description;
        this.prix = 0;
    }

    /**
     * @return Item's id
     */
    public int getId() {
        return id;
    }

    /**
     * @return Item's name
     */
    public String getNom() {
        return name;
    }

    /**
     * @return Item's name
     */
    public String toString() {
        return name;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }
}
// id : 1 : Vie
// id : 2 : Boost
// id : 3 : Arme