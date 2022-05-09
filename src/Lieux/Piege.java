package Lieux;

public class Piege {
    private String name;
    private int damage;
    private boolean isActive;

    /**
     * Trap's constructor
     * @param name Trap's name
     * @param damage Trap's damage
     */
    public Piege(String name, int damage) {
        this.name = name;
        this.damage = damage;
        this.isActive = false;
    }

    /**
     *
     * @param isActive true to activate the trap
     */
    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    /**
     *
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

    /**
     *
     * @return Trap's name
     */
    public String getName() {
        return this.name;
    }
}




