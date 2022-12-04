package Utility;

import Entity.Entity;

public class Navigation {

    public static void initialMenu(Entity player, Entity monster){
        System.out.println("Выбрать персонажа:" + "\n" + "1. " + player.getName() + "\n" + "2. " + monster.getName());
    }

    public static void choosingAnAction(){
        System.out.println("Выберите действие:" + "\n" + "1. Подбросить кубики для атаки противника." + "\n" + "2. Вернуться в начало.");
    }



}
