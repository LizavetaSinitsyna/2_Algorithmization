package by.epam.module2.part3;

/*
 * Сортировка вставками. Дана последовательность чисел a_1, a_2, ..., a_n. Требуется переставить числа в порядке
возрастания. Делается это следующим образом. Пусть  a_1, a_2, ..., a_i - упорядоченная последовательность, т. е.
a_1 <= a_2 <= ... <= a_n (опечатка: дана неотсортированная последовательность чисел a_1, a_2, ..., a_n). Берется следующее число a_(i+1) и вставляется в последовательность так, чтобы новая
последовательность была тоже возрастающей. Процесс производится до тех пор, пока все элементы от i +1 до n
не будут перебраны. Примечание. Место помещения очередного элемента в отсортированную часть производить
с помощью двоичного поиска. Двоичный поиск оформить в виде отдельной функции.
 */

public class SortingTask5 {

	public static void main(String[] args) {

		double[] array = { 0, -1, 7, 4, 2, 2, 1, -5, 3, 4, 10, 5 };

		insertionSort(array);

		printArray(array);

	}

	public static void insertionSort(double[] array) {

		for (int i = 1; i < array.length; i++) {
			int index = binarySearch(array, 0, i, array[i]);

			for (int j = i; j > index; j--) {
				swap(array, j, j - 1);
			}

		}

	}

	public static int binarySearch(double[] array, int startIndex, int endIndex, double element) {

		int newPosition = endIndex;

		int middle = startIndex + (endIndex - startIndex) / 2;

		if (startIndex == middle && array[middle] > element) {
			return startIndex;
		}

		if (array[middle] <= element && array[middle + 1] >= element) {
			return middle + 1;
		}

		if (array[middle] > element) {
			newPosition = binarySearch(array, startIndex, middle - 1, element);

		} else {
			newPosition = binarySearch(array, middle + 1, endIndex, element);
		}

		return newPosition;

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
