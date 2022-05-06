package Items;

public class Item{
    private String name;
    private int id;

    public Item(String name, int id){
        this.name = name;
        this.id = id;
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