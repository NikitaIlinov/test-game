package Entity;

public class Monster extends Entity {
    private static final Monster INSTANCE = new Monster(30);

    private Monster(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    //Не используется. Да и не очень понятно зачем
    public static Monster getInstance(){
        return INSTANCE;
    }
    //Много параметров в конструкторе. Подумай, как избавиться от них. Подсказка - поищи паттерны
    public Monster(String name, int health, int attack, int protection, int damage) {
        this.setName(name);
        this.setHealth(health);
        this.setAttack(attack);
        this.setProtection(protection);
        this.setDamage(damage);
    }

}
