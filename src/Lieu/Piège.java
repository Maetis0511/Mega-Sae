package Lieu;

public class Piège {
    private String name;
    private int damage;
    private boolean isActive;

    public Piège(int name, int damage) {
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




