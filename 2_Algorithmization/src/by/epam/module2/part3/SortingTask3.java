package by.epam.module2.part3;

/*
 * Сортировка выбором. Дана последовательность чисел a_1 <= a_2 <= ... <= a_n.Требуется переставить элементы так,
чтобы они были расположены по убыванию. Для этого в массиве, начиная с первого, выбирается наибольший
элемент и ставится на первое место, а первый - на место наибольшего. Затем, начиная со второго, эта процедура
повторяется. Написать алгоритм сортировки выбором.
 */

public class SortingTask3 {

	public static void main(String[] args) {
	
		
		double[] array = { 1.7, 8, 8, 10, 87.5, 96 };
		
		selectionSort(array);

		printArray(array);

	}

	public static void selectionSort(double[] array) {
		for (int i = 0; i < array.length; i++) {

			int maxIndex = i;

			for (int j = i + 1; j < array.length; j++) {
				if (array[j] > array[maxIndex]) {
					maxIndex = j;
				}
			}

			swap(array, maxIndex, i);

		}

	}

	public static void swap(double[] array, int index1, int index2) {
		double temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}

	public static void printArray(double[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}

}
