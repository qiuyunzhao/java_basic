package Fԭ��ģʽ;

//˵����https://www.runoob.com/design-pattern/prototype-pattern.html

/**
 * ��ʹ��New�ؼ���ʵ���������ʱ�򣬺ܸ��ӣ����Կ���ԭ��ģʽ��ʵ�֣� �������New����ȽϺ�ʱ,��¡��clone���ȽϽ�ʡʱ�䣡
 */

public class Client {

	public static void main(String[] args) throws CloneNotSupportedException {

		ShapeCache.loadCache();

		Shape clonedShape = (Shape) ShapeCache.getShape("Circle");
		System.out.println("Shape : " + clonedShape.getType());

		Shape clonedShape2 = (Shape) ShapeCache.getShape("Rectangle");
		System.out.println("Shape : " + clonedShape2.getType());

		Shape clonedShape3 = (Shape) ShapeCache.getShape("Square");
		System.out.println("Shape : " + clonedShape3.getType());

	}

}
