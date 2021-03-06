package Items;

public class Arme extends Item {
    private int degats;

    /**
     * Weapon constructor
     * @param name Weapon's name
     * @param id Weapon's id
     * @param description Weapon's description
     * @param degats Weapon's damage
     * @param prix Weapon's price
     */
    public Arme(String name,int id, String description, int degats,int prix) {
        super(name, id, description,prix);
        this.degats = degats;
    }

    /**
     * Weapon constructor
     * @param name Weapon's name
     * @param id Weapon's id
     * @param description Weapon's description
     * @param degats Weapon's damage
     */
    public Arme(String name,int id, String description, int degats) {
        super(name, id, description);
        this.degats = degats;
    }

    /**
     * @return Weapon's damage
     */
    public int getDegats() {
        return degats;
    }

}
