package Entity;

import com.sun.tools.javac.Main;

public class Player extends Entity {
    private static final Player INSTANCE = new Player();

    private Player(){

    }

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

    @Override
    public int getMAX_HEALTH() {
        return 30;
    }

    }
