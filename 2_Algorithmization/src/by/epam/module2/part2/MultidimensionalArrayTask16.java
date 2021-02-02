package by.epam.module2.part2;

import java.util.Scanner;

/*
 Магическим квадратом порядка n называется квадратная матрица размера nxn, составленная из чисел 1, 2, 3,
..., 2 n так, что суммы по каждому столбцу, каждой строке и каждой из двух больших диагоналей равны между
собой. Построить такой квадрат.
 */

public class MultidimensionalArrayTask16 {

	public static void main(String[] args) {

		int n = readInt("Введите количество строк и столбцов матрицы n >> ");

		int[][] matrix = new int[n][n];

		if (n == 2) {
			System.out.print("Магический квадрат 2-го порядка составить нельзя.");
			return;
		} else if (n % 4 == 0) {
			matrix = generateDoubleEvennessOderedMatrix(n);
		} else if (n % 2 == 0) {
			matrix = generateOddOderedMatrix(1, n);
		} else {
			matrix = generateSingleEvennessOderedMatrix(n);
		}

		System.out.println("Сформирован магический квадрат следующего вида: ");

		printMatrix(matrix);

	}

	public static int readInt(String message) {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		int number;
		do {
			System.out.println(message);

			while (!scan.hasNextInt()) {
				scan.nextLine();
				System.out.println(message);
			}

			number = scan.nextInt();
			scan.nextLine();
		} while (number < 1);

		return number;
	}

	public static int[][] generateOddOderedMatrix(int startIndex, int n) {

		/*Метод А. де ла Лубера (сиамский метод) основан на пяти правилах:
		  Правило 1. Поставьте 1 в среднюю колонку первой строки. 
		  Правило 2. Следующее число поставьте, если возможно в клетку, 
		  соседнюю с текущей по диагонали правее и выше. 
		  Правило 3. Если новая клетка выходит за пределы квадрата
		  сверху, то запишите число в самую нижнюю строку и в следующую колонку.
		  Правило 4. Если клетка выходит за пределы квадрата справа, то запишите число
		  в самую первую колонку и в предыдущую строку. 
		  Правило 5. Если клетка уже занята, то очередное число запишите под текущей клеткой.
		  
		  Далее переходите к Правилу 2. Снова выполняйте Правила 3, 4, 5, пока не
		  составите весь квадрат.*/

		int[][] matrix = new int[n][n];
		int currentRow = 0;
		int currentColumn = n / 2;

		int previousRow = 0;
		int previousColumn = n / 2;

		for (int i = startIndex; i <= n * n + startIndex - 1; i++) {
			if (matrix[currentRow][currentColumn] == 0) {
				matrix[currentRow][currentColumn] = i;
				previousRow = currentRow;
				previousColumn = currentColumn;
			} else {
				if (previousRow == n - 1) {
					currentRow = 0;
				} else {
					currentRow = previousRow + 1;
				}
				currentColumn = previousColumn;
				matrix[currentRow][currentColumn] = i;
				previousRow = currentRow;

			}
			if (currentRow == 0) {
				currentRow = n - 1;
			} else {
				currentRow--;
			}
			if (currentColumn == n - 1) {
				currentColumn = 0;
			} else {
				currentColumn++;
			}
		}

		return matrix;

	}

	public static int[][] generateSingleEvennessOderedMatrix(int n) {

		//Source of method: http://www.klassikpoez.narod.ru/mojmetod.htm

		int m = n / 2;

		int mSquared = m * m;

		int lastElementIndex = m - 1;

		int[][] matrix = new int[n][n];

		/*1_|_2 
		  4 | 3*/

		int[][] firstMatrix = new int[m][m];
		firstMatrix = generateOddOderedMatrix(1, m);

		int[][] secondMatrix = new int[m][m];

		int[][] thirdMatrix = new int[m][m];

		int[][] fourthMatrix = new int[m][m];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < m; j++) {

				secondMatrix[i][j] = 2 * mSquared + firstMatrix[i][j];

				thirdMatrix[i][j] = mSquared + firstMatrix[i][j];

				fourthMatrix[i][j] = 3 * mSquared + firstMatrix[i][j];
			}
		}

		int temp;

		temp = firstMatrix[0][0];
		firstMatrix[0][0] = fourthMatrix[0][0];
		fourthMatrix[0][0] = temp;

		temp = firstMatrix[lastElementIndex][0];
		firstMatrix[lastElementIndex][0] = fourthMatrix[lastElementIndex][0];
		fourthMatrix[lastElementIndex][0] = temp;

		int replacementAmount = (m - 3) / 2;

		// replacement of columns

		for (int i = 0; i < m; i++) {
			if (i > 0 && i < lastElementIndex) {
				temp = firstMatrix[i][1];
				firstMatrix[i][1] = fourthMatrix[i][1];
				fourthMatrix[i][1] = temp;
			}

			for (int j = 0; j <= replacementAmount; j++) {
				temp = firstMatrix[i][lastElementIndex - j];
				firstMatrix[i][lastElementIndex - j] = fourthMatrix[i][lastElementIndex - j];
				fourthMatrix[i][lastElementIndex - j] = temp;

				temp = secondMatrix[i][j];
				secondMatrix[i][j] = thirdMatrix[i][j];
				thirdMatrix[i][j] = temp;
			}
		}

		// merging in one matrix

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < m; j++) {
				matrix[i][j] = firstMatrix[i][j];
				matrix[i][j + m] = secondMatrix[i][j];
				matrix[i + m][j + m] = thirdMatrix[i][j];
				matrix[i + m][j] = fourthMatrix[i][j];
			}
		}

		return matrix;

	}

	public static int[][] generateDoubleEvennessOderedMatrix(int n) {

		// метод Рауз-Болла (http://www.klassikpoez.narod.ru/metody.htm):
		// Построим исходную таблицу размером n*n. Разделим исходную таблицу на
		// квадратные блоки 4*4 и отметим в каждом блоке клетки, находящиеся на главных
		// диагоналях. Для получения классического квадрата порядка n=4k остаётся во
		// всех отмеченных клетках произвести замену находящихся в них чисел di на числа
		// n*n + 1 - di

		int m = 4;

		int number = 1;

		int[][] matrix = new int[n][n];

		/*i = j большая диагональ \ 
		 i == n - 1 - j большая диагональ / 
		 i = j - m диагональ 2-й матрицы \ 
		 i - m = j диагональ 4-й матрицы \ 
		 i - m == n - 1 - j диагональ 3-й матрицы / 
		 i == m - 1 - j диагональ 1-й матрицы / 
		 Общий вид главных диагоналей: j = i - X * m; n - 1 - j = i - X * m;*/

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if ((i - j) % m == 0 || (i - (n - 1 - j)) % m == 0) {
					matrix[i][j] = n * n + 1 - number;
				} else {
					matrix[i][j] = number;

				}
				number++;

			}
		}

		return matrix;

	}

	public static void printMatrix(int[][] matrix) {

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + "\t");
			}
			System.out.println();
		}

	}

}
