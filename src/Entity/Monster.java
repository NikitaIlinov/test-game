package Entity;

public class Monster extends Entity {
    private static final Monster INSTANCE = new Monster();

    private Monster(){

    }

    public static Monster getInstance(){
        return INSTANCE;
    }
    public Monster(String name, int health, int attack, int protection, int damage) {
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
