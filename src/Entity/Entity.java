package Entity;
import java.util.Scanner;

public class Entity {

    Scanner scanner = new Scanner(System.in);

    private String name;
    private int health;
    private int attack;
    private int protection;
    private int damage;
    protected int maxHealth;

    private static int attemptToRestoreHealth = 3;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health <= 0 || health > 100) {
            throw new IllegalArgumentException();
        } else {
            this.health = health;
        }
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        if (attack < 0 || attack > 20) {
            throw new IllegalArgumentException();
        } else {
            this.attack = attack;
        }
    }

    public int getProtection() {
        return protection;
    }

    public void setProtection(int protection) {
        if (protection < 0 || protection > 20) {
            throw new IllegalArgumentException();
        } else {
            this.protection = protection;
        }
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        if (damage < 0 || damage > 6) {
            throw new IllegalArgumentException();
        } else {
            this.damage = damage;
        }
    }


    public void attack(Entity entity) {
        if (random() == 5 || random() == 6) {
            int attack = Math.abs(this.getAttack() - entity.getProtection()) + 1;
            if (entity.getProtection() > 0) {
                try {
                    entity.setProtection(entity.getProtection() - attack);
                    System.out.println("Атака произведена. Защита остановила удар. " + entity.getName() + ": осталось " + entity.getProtection() + " единиц защиты.");
                } catch (IllegalArgumentException e) {
                    nearDead(entity, attack);
                }
            } else {
                nearDead(entity, attack);
            }
        } else {
            System.out.println(getName() + " промахнулся");
        }
    }

    private void nearDead(Entity entity, int attack) {
        try {
            int healthAfterAttack = entity.getHealth() - attack;
            entity.setHealth(healthAfterAttack);
            System.out.println("Атака произведена. " + entity.getName() + ": осталось " + entity.getHealth() + " единиц здоровья.");
        } catch (IllegalArgumentException ex) {
            System.out.println(entity.getName() + " умер. Введите цифру 1, чтобы восстановить здоворовье.");
            int restoreHealth = scanner.nextInt();
            if (restoreHealth == 1) {
                try {
                    entity.setAttemptToRestoreHealth(attemptToRestoreHealth - 1);
                    entity.setHealth(entity.maxHealth / 2);
                } catch (IllegalArgumentException exception) {
                    try {
                        entity.setHealth(0);
                    } catch (IllegalArgumentException argumentException) {
                        entity.setAttack(0);
                        System.out.println("\n" + "Игра окончена" + "\n" + "Победил " + getName());
                    }
                }
            }
        }
    }


    public int random() {
        int random = 0;

        //Что за странный цикл? Он же ничего не делает
        for (int i = 0; i < getDamage(); i++) {
            random = (int) (Math.random() * 6 + 1);
            return random;
        }
        return random;
    }

    @Override
    public String toString() {
        return "Ваш персонаж: " +
                name +
                ", здоровье = " + health +
                ", атака = " + attack +
                ", защита = " + protection +
                ", урон = " + damage;
    }

    public void setAttemptToRestoreHealth(int attemptToRestoreHealth) {
        if (attemptToRestoreHealth < 1) {
            throw new IllegalArgumentException();
        } else {
            //Не очень хорошо обращаться к статике через инстанс
            this.attemptToRestoreHealth = attemptToRestoreHealth;
        }
    }


}
