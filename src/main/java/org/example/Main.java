package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Добавьте элементы в коллекцию");
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> listBuf = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            int index = (int) (Math.random() * 15);
            listBuf.add(index);
        }
        while (list.size() <= 5) {
            if (scanner.hasNextInt()) {
                int number = scanner.nextInt();
                list.add(number);
            } else {
                System.out.println("Заполненная коллекция будет очищена");
                list.clear();
                System.exit(0);
            }
        }
        System.out.println("Хотите удалить элемент из коллекции?");
        Scanner scanner1 = new Scanner(System.in);
        String text = scanner1.nextLine();
        if (text.equals("да")) {
            System.out.println("Выберите индекс элемента");
            int index = scanner1.nextInt();
            list.remove(index);
        }
        System.out.println("Хотите заменить элементы коллекции");
        Scanner scanner2 = new Scanner(System.in);
        String text2 = scanner1.nextLine();
        if (text2.equals("да")) {
            System.out.println("Выберите индекс элемента");
            int index = scanner2.nextInt();
            list.addAll(index, listBuf);
        }
        bubbleSort(list);
    }

    static void bubbleSort(ArrayList<Integer> arrayList) {
        for (int i = 0; i < arrayList.size() - 1; i++) {
            boolean isSort = false;
            for (int j = 0; j < arrayList.size() - i - 1; j++) {
                if (arrayList.get(j) > arrayList.get(j + 1)) {
                    int buffer = arrayList.get(j);
                    arrayList.set(j, arrayList.get(j + 1));
                    arrayList.set(j + 1, buffer);
                    isSort = true;
                }
            }
            if (!isSort) {
                System.out.println(arrayList);
                break;
            }
        }
    }

}