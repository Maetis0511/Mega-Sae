package Lieux;

public class Piege {
    private String name;
    private int damage;
    private boolean isActive;

    public Piege(String name, int damage) {
        this.name = name;
        this.damage = damage;
        this.isActive = false;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    public boolean isActive() {
        return this.isActive;
    }

    public int getDamage() {
        return this.damage;
    }

    public String getName() {
        return this.name;
    }
}




