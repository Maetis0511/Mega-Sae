package Items;

public class Consommable extends Item {
    private int value;

    public Consommable(String nom, int id, String description, int value) {
        super(nom, id, description);
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}