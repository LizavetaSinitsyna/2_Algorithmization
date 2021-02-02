package by.epam.module2.part2;

// Найдите наибольший элемент матрицы и заменить все нечетные элементы на него.

public class MultidimensionalArrayTask15 {

	public static void main(String[] args) {

		int[][] matrix = { { -56, 789, 54 }, { 0, 3 }, { 78, 56, 90 }, { 34, 800, 75 } };

		System.out.println("Задана матрица следующего вида: ");

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + "\t");
			}
			System.out.println();
		}

		int max = matrix[0][0];

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] > max) {
					max = matrix[i][j];
				}
			}
		}

		System.out.println(
				"После замены всех нечетных элементов на наибольший элемент матрица выглядит следующим образом: ");

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] % 2 != 0) {
					matrix[i][j] = max;
				}
				System.out.print(matrix[i][j] + "\t");
			}
			System.out.println();
		}
	}
}
