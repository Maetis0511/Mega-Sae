package Lieux;

public class Piege {
    private String name;
    private int damage;
    private boolean isActive;
    private String dialogue;

    /**
     * Trap's constructor
     * @param name Trap's name
     * @param damage Trap's damage
     */
    public Piege(String name, int damage, String dialogue) {
        this.name = name;
        this.damage = damage;
        this.isActive = true;
        this.dialogue = dialogue;
    }

    /**
     * Function to activate the trap
     * @param isActive true to activate the trap
     */
    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    /**
     * Function to know if the trap is active
     * @return true if the trap is active
     */
    public boolean isActive() {
        return this.isActive;
    }

    /**
     *
     * @return Trap's damage
     */
    public int getDamage() {
        return this.damage;
    }

    public String getDialogue() {
        return this.dialogue;
    }

    /**
     *
     * @return Trap's name
     */
    public String getName() {
        return this.name;
    }
}




