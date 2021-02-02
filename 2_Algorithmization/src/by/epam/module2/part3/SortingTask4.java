package by.epam.module2.part3;

/*
 * Сортировка обменами. Дана последовательность чисел a_1 <= a_2 <= ... <= a_n (опечатка: дана неотсортированная последовательность чисел a_1, a_2, ..., a_n).
 * Требуется переставить числа в порядке возрастания. Для этого сравниваются два соседних числа a_i и a_(i+1). Если  a_i > a_(i+1) , то делается перестановка. Так продолжается до тех пор, пока все элементы не станут расположены в порядке возрастания.
 * Составить алгоритм сортировки, подсчитывая при этом количества перестановок.
 */

public class SortingTask4 {

	public static void main(String[] args) {

		double[] array = { 8, -10, 9, 10 };

		bubbleSort(array);

		printArray(array);

	}

	public static void bubbleSort(double[] array) {
		int counter = 0;
		for (int i = 0; i < array.length - 1; i++) {

			for (int j = 0; j < array.length - 1 - i; j++) {
				if (array[j] > array[j + 1]) {
					swap(array, j + 1, j);
					counter++;
				}
			}

		}

		System.out.println("Количество перестановок равно " + counter);
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
