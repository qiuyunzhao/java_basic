package F原型模式;

import java.util.Hashtable;

/**
 * 创建一个类，从数据库获取实体类，并把它们存储在一个 Hashtable 中。
 */
public class ShapeCache {

	private static Hashtable<String, Shape> shapeMap = new Hashtable<String, Shape>();

	public static Shape getShape(String shape) throws CloneNotSupportedException {
		Shape cachedShape = shapeMap.get(shape);
		return (Shape) cachedShape.clone();  //核心：调用已有对象的clone()方法实现复制（若对象中有引用类型则复制的是地址）
	}

	// 对每种形状都运行数据库查询，并创建该形状 shapeMap.put(shapeKey, shape);
	// 例如，我们要添加三种形状
	public static void loadCache() {
		Circle circle = new Circle();
		shapeMap.put(circle.getType(), circle);

		Square square = new Square();
		shapeMap.put(square.getType(), square);

		Rectangle rectangle = new Rectangle();
		shapeMap.put(rectangle.getType(), rectangle);
	}
}