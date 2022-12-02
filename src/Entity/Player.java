package Entity;

public class Player extends Entity {
    private static final Player INSTANCE = new Player(30);

    private Player(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    //Не используется
    public static Player getInstance(){
        return INSTANCE;
    }

    public Player(String name, int health, int attack, int protection, int damage) {
        this.setName(name);
        this.setHealth(health);
        this.setAttack(attack);
        this.setProtection(protection);
        this.setDamage(damage);
    }
}
