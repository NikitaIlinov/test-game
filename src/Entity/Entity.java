package Entity;

import java.util.HashSet;
import java.util.Scanner;

public class Entity {

    Scanner scanner = new Scanner(System.in);

    private String name;
    private int health;
    private int attack;
    private int protection;
    private int damage;

    protected final int MAX_HEALTH = 0;
    protected int attemptToRestoreHealth = 3;

    public int getMAX_HEALTH() {
        return MAX_HEALTH;
    }

    public int getAttemptToRestoreHealth(){
        return attemptToRestoreHealth;
    }

    public void setAttemptToRestoreHealth(int attemptToRestoreHealth) {
    }

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
        if (random()) {
            int attack = Math.abs(this.getAttack() - entity.getProtection()) + 1;
            if (entity.getProtection() > 0) {
                try {
                    entity.setProtection(entity.getProtection() - attack);
                    System.out.println("\n" + "???? ?????????? ?????????????? ???????????? ???????????????? ?????????? 5 ?????? 6." + "\n" + "?????????? ??????????????????????. ???????????? ???????????????????? ????????." + "\n" + entity.getName() + ": ???????????????? " + entity.getProtection() + " ????????????(??) ????????????." + "\n");
                } catch (IllegalArgumentException e) {
                    nearDead(entity, attack);
                }
            } else {
                nearDead(entity, attack);
            }
        } else {
            System.out.println("\n" + getName() + " ??????????????????????." + "\n");
        }
    }

    private void nearDead(Entity entity, int attack) {
        try {
            int healthAfterAttack = entity.getHealth() - attack;
            entity.setHealth(healthAfterAttack);
            System.out.println("\n" + "???? ?????????? ?????????????? ???????????? ???????????????? ?????????? 5 ?????? 6. ?????????? ??????????????????????. " + "\n" + entity.getName() + ": ???????????????? " + entity.getHealth() + " ????????????(??) ????????????????." + "\n");
        } catch (IllegalArgumentException ex) {
            System.out.println("\n" + entity.getName() + " ????????. ?????????????? ?????????? ??????????, ?????????? ???????????????????????? ????????????????." + "\n");
            int restoreHealth = scanner.nextInt();
            switch (restoreHealth) {
                default -> {
                    try {
                        entity.setAttemptToRestoreHealth(entity.attemptToRestoreHealth - 1);
                        entity.setHealth(entity.getMAX_HEALTH() / 2);
                    } catch (IllegalArgumentException exception) {
                        try {
                            entity.setHealth(0);
                        } catch (IllegalArgumentException argumentException) {
                            entity.setAttack(0);
                            System.out.println("\n" + "???????? ????????????????" + "\n" + "?????????????? " + getName());
                        }
                    }
                }
            }
        }
    }


    public boolean random() {
        HashSet<Integer> set = new HashSet<>();
        int random;

        for (int i = 0; i < getDamage(); i++) {
            random = (int) (Math.random() * 6 + 1);
            set.add(random);
        }
        return set.contains(5) | set.contains(6);
    }

    @Override
    public String toString() {
        return "?????? ????????????????: " +
                name +
                ", ???????????????? = " + health +
                ", ?????????? = " + attack +
                ", ???????????? = " + protection +
                ", ???????? = " + damage;
    }
}
