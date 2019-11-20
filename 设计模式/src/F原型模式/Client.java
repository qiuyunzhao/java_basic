package F原型模式;

//说明：https://www.runoob.com/design-pattern/prototype-pattern.html

/**
 * 当使用New关键字实例化对象的时候，很复杂，可以考虑原型模式来实现！ 再则就是New对象比较耗时,克隆（clone）比较节省时间！
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
