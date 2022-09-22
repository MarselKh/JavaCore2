package Lesson4;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        ArrayList<String> wordsList = new ArrayList<>();
        wordsList.add("сапог");
        wordsList.add("душ");
        wordsList.add("сапог");
        wordsList.add("полиграф");
        wordsList.add("Евразия");
        wordsList.add("эмаль");
        wordsList.add("пес");
        wordsList.add("сапог");
        wordsList.add("Картахена");
        wordsList.add("Евразия");
        wordsList.add("Киоск");
        wordsList.add("душ");

        HashSet<String> wordsSet = new HashSet<>(wordsList);
        for (String word: wordsSet) {
            System.out.println(word + " :" + Collections.frequency(wordsList,word));
        }
        System.out.println("------------------------------------------------");

        MemberPhone memberPhone = new MemberPhone();
        memberPhone.add("111111","Ivanov");
        memberPhone.add("234567","Katov");
        memberPhone.add("222222","Sidorov");
        memberPhone.add("234567","Aminev");
        memberPhone.add("234567","Semenov");
        memberPhone.add("234567","First");
        memberPhone.add("234567","Popko");
        memberPhone.add("234567","Rahmatullin");
        memberPhone.add("222222","Sidorov");
        memberPhone.add("222222","Ivanov");
        memberPhone.add("234567","Bobko");
        memberPhone.add("333333","Ivanov");

        System.out.println(memberPhone.getMemberPhone("Ivanov"));
        System.out.println(memberPhone.getMemberPhone("234567"));
    }
}

//    Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся). Найти и
//        вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
//        Посчитать, сколько раз встречается каждое слово.
//        2 Написать простой класс Телефонный Справочник, который хранит в себе список фамилий и
//        телефонных номеров. В этот телефонный справочник с помощью метода add() можно
//        добавлять записи, а с помощью метода get() искать номер телефона по фамилии. Следует
//        учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
//        тогда при запросе такой фамилии должны выводиться все телефоны. Желательно не добавлять
//        лишний функционал (дополнительные поля (имя, отчество, адрес), взаимодействие с пользователем
//        через консоль и т.д). Консоль использовать только для вывода результатов проверки телефонного
//        справочника.


