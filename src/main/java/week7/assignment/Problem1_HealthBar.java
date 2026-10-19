package week7.assignment;

class Character {
    private int health;
    private final int maxHealth;

    public Character(int maxHealth) {
        if (maxHealth < 0) {
            maxHealth = 0;
        }
        this.maxHealth = maxHealth;
        this.health = maxHealth;
    }

    public void takeDamage(int amount) {
        if (amount > 0) {
            health = Math.max(0, health - amount);
        }
    }

    public void heal(int amount) {
        if (amount > 0) {
            health = Math.min(maxHealth, health + amount);
        }
    }

    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }
}

public class Problem1_HealthBar {
    public static void main(String[] args) {
        Character c = new Character(100);
        c.takeDamage(30);
        System.out.println("After damage: " + c.getHealth());
        c.heal(50);
        System.out.println("After healing: " + c.getHealth());
        c.takeDamage(150);
        System.out.println("After extra damage: " + c.getHealth());
    }
}
