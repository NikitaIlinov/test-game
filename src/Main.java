import Entity.*;
import Utility.Navigation;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Monster monsterBob = new Monster("Монстр Боб", 100, 15, 15, 6);
        Player playerNik = new Player("Игрок Ник", 30, 10, 10, 3);

        Scanner scanner = new Scanner(System.in);

        while (monsterBob.getAttack() != 0 & playerNik.getAttack() != 0) {
            Utility.Navigation.initialMenu(playerNik, monsterBob);
            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> {
                    System.out.println(playerNik);
                    Navigation.choosingAnAction();
                    int choiceInMenuPersonage = scanner.nextInt();
                    if (choiceInMenuPersonage == 1) {
                        playerNik.attack(monsterBob);
                    }
                }
                case 2 -> {
                    System.out.println(monsterBob);
                    Navigation.choosingAnAction();
                    int choiceInMenuPersonage = scanner.nextInt();
                    if (choiceInMenuPersonage == 1) {
                        monsterBob.attack(playerNik);
                    }
                }
                default -> {
                }
            }
        }
    }
}
