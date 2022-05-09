package Items;

public class Item{
    private String name;
    private int id;
    private String description;

    /**
     * Item constructor
     * @param name Item's name
     * @param id Item's id
     * @param description Item's description
     */
    public Item(String name, int id, String description){
        this.name = name;
        this.id = id;
        this.description = description;
    }

    /**
     * @return Item's id
     */
    public int getId(){
        return id;
    }

    /**
     * @return Item's name
     */
    public String getNom(){
        return name;
    }

    /**
     * @return Item's name
     */
    public String toString(){
        return name;
    }
}

// id : 1 : Vie
// id : 2 : Boost
// id : 3 : Arme