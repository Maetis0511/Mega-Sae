package Items;

public class Consommable extends Item {
    private int value;

    /**
     * Consumable constructor with price
     * @param nom Consumable's name
     * @param id Consumable's id
     * @param description Consumable's description
     * @param value Consumable's value
     * @param prix Consumable's price
     */
    public Consommable(String nom, int id, String description, int value,int prix) {
        super(nom, id, description,prix);
        this.value = value;
    }

    /**
     * Consumable constructor without price
     * @param nom Consumable's name
     * @param id Consumable's id
     * @param description Consumable's description
     * @param value Consumable's value
     */
    public Consommable(String nom, int id, String description, int value) {
        super(nom, id, description);
        this.value = value;
    }

    /**
     * @return Consumable's value
     */
    public int getValue() {
        return value;
    }
}