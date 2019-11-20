package J桥接模式;

//桥接模式核心：通过减低维度，变为内部持有的方式来简化类的继承关系

public class Client {
	public static void main(String[] args) {
		// 销售联想的笔记本电脑
		Computer c = new Laptop(new Lenovo());
		c.sale();
		// 销售神舟的台式机
		Computer c2 = new Pad(new Shenzhou());
		c2.sale();
	}
}