package by.epam.module2.part2;

/* Задана матрица неотрицательных чисел. Посчитать сумму элементов в каждом столбце. Определить, какой
столбец содержит максимальную сумму.
*/

public class MultidimensionalArrayTask9 {

	public static void main(String[] args) {

		double[][] matrix = { { 1, 3, 8 }, { 9, 10, 11 }, { 32, 4, 8, 7 }, { 45, 3 } };

		System.out.println("Задана матрица: ");

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println("Максимальную сумму содержит столбец " + columnWithMaxSumOfElements(matrix));

	}

	public static int columnWithMaxSumOfElements(double array[][]) {
		double maxSum = 0;
		double sum = 0;
		int columnWithMaxSum = 0;

		int rowMaxLength = 0;

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				if (array[i].length > rowMaxLength) {
					rowMaxLength = array[i].length;
				}
			}
		}

		for (int i = 0; i < rowMaxLength; i++) {

			for (int j = 0; j < array.length; j++) {
				if (array[j].length - 1 >= i) {
					sum += array[j][i];
				}
			}
			if (sum > maxSum) {
				maxSum = sum;
				columnWithMaxSum = i;
			}
			sum = 0;
		}
		return columnWithMaxSum + 1;

	}

}
