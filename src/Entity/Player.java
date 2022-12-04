package Entity;

public class Player extends Entity {
    private static final Player INSTANCE = new Player();

    private Player(){;
    }

    public Player(String name, int health, int attack, int protection, int damage) {
        this.setName(name);
        this.setHealth(health);
        this.setAttack(attack);
        this.setProtection(protection);
        this.setDamage(damage);
    }

    @Override
    public int getMAX_HEALTH(){
        return 30;
    }

    @Override
    public int getAttemptToRestoreHealth(){
        return attemptToRestoreHealth;
    }

    @Override
    public void setAttemptToRestoreHealth(int attemptToRestoreHealth) {
        if (getAttemptToRestoreHealth() < 1) {
            throw new IllegalArgumentException();
        } else {
            this.attemptToRestoreHealth = attemptToRestoreHealth;
        }
    }
    }