package by.epam.module2.part4.task4;

/*На плоскости заданы своими координатами n точек. Написать метод(методы), 
 *определяющие, между какими из пар точек самое большое расстояние. 
 *Указание. Координаты точек занести в массив.*/

public class PointPairsView {
	public String printPoint(Point point) {
		return "{" + point.getX() + ", " + point.getY() + "}";

	}

	public String printPointPair(PointPair pair) {
		return "[" + printPoint(pair.getPoint1()) + " и " + printPoint(pair.getPoint2()) + "]";
	}

	public void printPointPairsList(String message, PointPairsList list) {
		System.out.println(message);
		for (int i = 0; i < list.length(); i++) {
			System.out.println(printPointPair(list.getPointPair(i)) + ";");
		}

	}

}
