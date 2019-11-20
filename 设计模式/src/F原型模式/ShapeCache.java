package Fԭ��ģʽ;

import java.util.Hashtable;

/**
 * ����һ���࣬�����ݿ��ȡʵ���࣬�������Ǵ洢��һ�� Hashtable �С�
 */
public class ShapeCache {

	private static Hashtable<String, Shape> shapeMap = new Hashtable<String, Shape>();

	public static Shape getShape(String shape) throws CloneNotSupportedException {
		Shape cachedShape = shapeMap.get(shape);
		return (Shape) cachedShape.clone();  //���ģ��������ж����clone()����ʵ�ָ��ƣ����������������������Ƶ��ǵ�ַ��
	}

	// ��ÿ����״���������ݿ��ѯ������������״ shapeMap.put(shapeKey, shape);
	// ���磬����Ҫ���������״
	public static void loadCache() {
		Circle circle = new Circle();
		shapeMap.put(circle.getType(), circle);

		Square square = new Square();
		shapeMap.put(square.getType(), square);

		Rectangle rectangle = new Rectangle();
		shapeMap.put(rectangle.getType(), rectangle);
	}
}