package com.company;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Введите размер массива: ");
		int size = scanner.nextInt();
		int[] mas = new int[size];
		for (int i = 0; i < mas.length; i++) {
			int a = 100;
			int randomNumber = (int) (Math.random() * a);
			mas[i] = randomNumber;
		}
		for (int i = 0; i < mas.length; i++) { //для проверки
			System.out.print(mas[i] + " ");
		}
		System.out.println("");

		for (int i = 1; i < mas.length; i += 2) {
			int a = mas[i];
			mas[i] = mas[i - 1];
			mas[i - 1] = a;

		}

		for (int i = 0; i < mas.length; i++) {
			System.out.print(mas[i] + " ");
		}
	}
}
