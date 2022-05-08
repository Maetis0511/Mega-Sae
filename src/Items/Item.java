package Items;

public class Item{
    private String name;
    private int id;
    private String description;

    public Item(String name, int id, String description){
        this.name = name;
        this.id = id;
        this.description = description;
    }

    public String getName(){
        return name;
    }

    public int getId(){
        return id;
    }

    public String getNom(){
        return name;
    }

    public String toString(){
        return name;
    }
}

// id : 1 : Vie
// id : 2 : Boost
// id : 3 : Arme