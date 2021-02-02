package by.epam.module2.part4.task4;

/*На плоскости заданы своими координатами n точек. Написать метод(методы), 
 *определяющие, между какими из пар точек самое большое расстояние. 
 *Указание. Координаты точек занести в массив.*/

public class PointPair {
	private Point point1;
	private Point point2;

	public PointPair(Point point1, Point point2) {
		this.point1 = point1;
		this.point2 = point2;
	}

	public Point getPoint1() {
		return point1;
	}

	public void setPoint1(Point point1) {
		this.point1 = point1;
	}

	public Point getPoint2() {
		return point2;
	}

	public void setPoint2(Point point2) {
		this.point2 = point2;
	}

	@Override
	public String toString() {
		return "PointPair [point1=" + point1 + ", point2=" + point2 + "]";
	}

}
