package Items;

public class Arme extends Item {
    private int degats;
    public Arme(String name,int id, String description, int degats) {
        super(name, id, description);
        this.degats = degats;
    }
    public int getDegats() {
        return degats;
    }

}
