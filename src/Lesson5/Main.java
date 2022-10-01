package Lesson5;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static java.lang.System.lineSeparator;

public class Main {
    public static String[] stringHeader = {"Value1", "Value2", "Value3"};
    public static List<IntBox> arrIntList = new ArrayList();

    public static void main(String[] args) throws IOException {

        randomArr();

        writerCSV();

        readCSV();

    }

    public static void randomArr() {
        Random random = new Random();
        int count = 100;
        for (int i = 0; i < count; i++) {
            arrIntList.add(new IntBox(random.nextInt(count), random.nextInt(count), random.nextInt(count)));
        }
    }

    public static void writerCSV() throws IOException {
        try (FileWriter writer = new FileWriter("src/Lesson5/csvFile.csv")) {
            writer.write(Arrays.toString(stringHeader));

            try (FileOutputStream fileOutputStream = new FileOutputStream("src/Lesson5/csvFile.csv", true)) {
                for (IntBox intBox : arrIntList) {
                    String str = intBox.getIntBox1() + "; " + intBox.getIntBox2() + "; " + intBox.getIntBox3() + "; " + lineSeparator();
                    for (byte b : str.getBytes()) fileOutputStream.write(b);
                }
            }

        }
    }

    public static AppData readCSV() throws IOException {
        AppData appData = new AppData();
        List<List<String>> listStr = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("src/Lesson5/csvFile.csv"))) {
            String line = br.readLine();
            appData.setHeader(line.split(";"));
            while ((line = br.readLine()) != null) {
                String[] values = line.split(";");
                listStr.add(Arrays.asList(values));
            }
        }
        int[][] arrData = new int[listStr.size()][3];
        for (int i = 0; i < listStr.size(); i++) {
            for (int j = 0; j < listStr.get(i).size(); j++) {
                arrData[i][j] = Integer.parseInt(listStr.get(i).get(j));
            }
        }
        appData.setData(arrData);
        return appData;
    }
}

//        1. Реализовать сохранение данных в csv файл;
//        2. Реализовать загрузку данных из csv файла. Файл читается целиком.