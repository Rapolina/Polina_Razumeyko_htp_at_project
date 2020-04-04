package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите размер массива: ");
        int size = scanner.nextInt();
        int mas[];
        mas = new int[size];
        int a = 0;
        int b = 100;
        for (int i = 0; i < mas.length; i++) {
            mas[i] = a + ((int) (Math.random() * (b - a)));
        }
        for (int i = 0; i < mas.length; i++) { //для проверки
            System.out.print(mas[i] + " ");
            ;
        }
        System.out.println("");

        moveRight(mas, 2);
        for (int i = 0; i < mas.length; i++) { //для проверки
            System.out.print(mas[i] + " ");
        }
        System.out.println("");
        /*moveLeft(mas, 4);
        for (int i = 0; i < mas.length; i++) { //для проверки
            System.out.print(mas[i] + " ");

        }*/

    }

    public static void moveRight(int[] mas, int positions) {
        int size = mas.length;

        for (int i = 0; i < positions; i++) {
            int temp = (int) mas[size - 1];

            for (int j = size - 1; j > 0; j--) {
                mas[j] = mas[j - 1];
            }
            mas[0] = temp;


        }
    }

    /*public static void moveLeft(int[] mas, int positions) {
        int size = mas.length;

        for (int i = 0; i < positions; i++) {
            int temp = mas[0];
            for (int j = 0; j < size - 1; j++) {
                mas[j] = mas[j + 1];
            }
            mas[size - 1] = temp;
        }

    }*/

}