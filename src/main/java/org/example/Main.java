package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Добавьте элементы в коллекцию");
        MyArrayList<Integer> list = new MyArrayList<>();
        while (list.size() <= 5) {
            if (scanner.hasNextInt()) {
                int number = scanner.nextInt();
                list.add(number);
            }
        }
        System.out.println("Выберите действие:\n" +
                "1 - чистка коллекции;\n" + "2 - удаление индекса элемента коллекции;\n"
                + "3 - получение индекса элемента коллекции;\n" + "4 - сортировка коллекции;");
        Scanner getInd = new Scanner(System.in);
        int b = getInd.nextInt();
        switch (b) {
            case 1:
                System.out.println("Заполненная коллекция будет очищена");
                list.clear();
                System.out.println(list);
                break;
            case 2:
                Scanner scanner1 = new Scanner(System.in);
                System.out.println("Выберите индекс элемента");
                int index = scanner1.nextInt();
                if (index > list.size()){
                    System.out.println("Индекс за пределами коллекции");
                    System.out.println("Выберите действие:\n" +
                            "1 - чистка коллекции;\n" + "2 - удаление индекса элемента коллекции;\n"
                            + "3 - получение индекса элемента коллекции;\n" + "4 - сортировка коллекции;");
                    getInd.nextInt();;
                } else {
                    list.remove(index);
                    System.out.println(list);
                    break;
                }
            case 3:
                Scanner scanner2 = new Scanner(System.in);
                System.out.println("Выберите индекс элемента");
                int index1 = scanner2.nextInt();
                if (index1 > list.size()){
                    System.out.println("Индекс за пределами коллекции");
                    System.out.println("Выберите действие:\n" +
                            "1 - чистка коллекции;\n" + "2 - удаление индекса элемента коллекции;\n"
                            + "3 - получение индекса элемента коллекции;\n" + "4 - сортировка коллекции;");
                    getInd.nextInt();;
                } else {
                    System.out.println(list.get(index1));
                    break;
                }
            case 4:
                bubbleSort(list);
        }

    }

    static void bubbleSort(MyArrayList<Integer> arrayList) {
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