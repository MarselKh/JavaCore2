package Lesson2;

import Lesson1.Start;

public class Main {

    public static void main (String[] args){
        String[][] arrString1 =  {{"1", "1", "1", "1"}, {"2", "2", "2", "2"}, {"3", "3", "3", "4"}, {"4", "4", "4", "1"}, {"4", "4", "4", "1"}};
        String[][] arrString2 =  {{"1", "1", "1", "1"}, {"2", "Привет", "2", "2"}, {"3", "3", "3", "4"}, {"4", "4", "4", "1"}};
        String[][] arrString3 =  {{"1", "1", "1", "1"}, {"2", "2", "2", "2"}, {"3", "3", "3", "3"}, {"4", "4", "4", "4"}};

        Start(arrString1);
        Start(arrString2);
        Start(arrString3);
    }

    public static void Start(String [][] arrStr) {
        try {
            Array(arrStr);
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        } catch (MyArrayDataException e) {
            e.printStackTrace();
        }
    }

    public static void Array(String[][] arrStr)  throws MyArraySizeException, MyArrayDataException  {
        int [][] arrInt = new int [arrStr.length][arrStr.length];
        int summ = 0;
            for (int i = 0; i < arrStr.length; i++) {
                for (int j = 0; j < arrStr.length; j++) {
                    if (arrStr.length != 4 || arrStr[i].length != 4)
                        throw new MyArraySizeException("Массив не соответствует размеру 4 х 4");
                    try {
                        arrInt[i][j] = Integer.parseInt(arrStr[i][j]);
                        summ += arrInt[i][j];
                    } catch (NumberFormatException e) {
                        throw new MyArrayDataException("Ошибка в ячейке "+ "[" + i + "]" + "[" + j + "]");
                    }

                }
            }
        System.out.println(summ);
        }


    private static class MyArrayDataException extends RuntimeException {
        MyArrayDataException(String e) {
            super(e);
        }
    }

    private static class MyArraySizeException extends RuntimeException {
        MyArraySizeException(String e) {
            super(e);
        }
    }
}


/*1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4. При подаче массива другого размера
        необходимо бросить исключение MyArraySizeException.
2. Далее метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать. Если в каком-то элементе 
        массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа), должно быть брошено 
        исключение MyArrayDataException с детализацией, в какой именно ячейке лежат неверные данные.
3. В методе main() вызвать полученный метод, обработать возможные исключения MyArraySizeException и MyArrayDataException 
        и вывести результат расчета.*/