package by.epam.module2.part4.task4;

/*На плоскости заданы своими координатами n точек. Написать метод(методы), 
 *определяющие, между какими из пар точек самое большое расстояние. 
 *Указание. Координаты точек занести в массив.*/

public class PointPairsList {
	private PointPair[] array;

	public PointPairsList(PointPair[] array) {
		this.array = array;
	}

	public PointPair[] add(PointPair element) {

		PointPair[] temp;

		temp = new PointPair[array.length + 1];

		for (int i = 0; i < array.length; i++) {
			temp[i] = array[i];
		}

		temp[temp.length - 1] = element;

		array = temp;

		return array;
	}

	public int length() {
		return array.length;
	}

	public PointPair getPointPair(int index) {
		return array[index];
	}
}
