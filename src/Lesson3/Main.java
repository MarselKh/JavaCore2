package Lesson3;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main (String [] args) {
        String [] arr = {"One", "Two", "Three", "four", "Five"};
        exchange(arr,0,4);
        System.out.println("-------------------------");

        Apple apple = new Apple();
        Orange orange = new Orange();

        ArrayList <Apple> listApple = new ArrayList<>();
        listApple.add(apple);
        listApple.add(apple);
        listApple.add(apple);

        Box <Apple> boxApple = new Box<>(listApple);
        System.out.println("Weigth box Apple = " + boxApple.getWeightBox());

        ArrayList <Apple> listApple2 = new ArrayList<>();
        listApple2.add(apple);

        Box <Apple> boxApple2 = new Box<>(listApple2);
        System.out.println("Weigth box Apple2 = " + boxApple2.getWeightBox());

        ArrayList<Orange> listOrange = new ArrayList<>();
        listOrange.add(orange);
        listOrange.add(orange);
        listOrange.add(orange);

        Box <Orange> boxOrange = new Box<>(listOrange);
        System.out.println("Weigth box Orange = = " + boxOrange.getWeightBox());

        System.out.println("Сравнение веса ящиков = " + boxApple.compare(boxOrange));

        boxApple.overflowBox(boxApple2);




    }



    // 1 Задание
    public static void exchange (String [] arrExchange, int a, int b) {

        for (int i = 0; i < arrExchange.length; i++) {
            String tmp = arrExchange[a];
            arrExchange[a] = arrExchange[b];
            arrExchange[b] = tmp;
            System.out.println(arrExchange[i]);
        }

    }

}
