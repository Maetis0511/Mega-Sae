package Items;

public class Arme extends Item {
    private int degats;
    public Arme(String name,int id, int degats) {
        super(name,id);
        this.degats = degats;
    }
    public int getDegats() {
        return degats;
    }

}
