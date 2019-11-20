package B简单工厂模式;

//说明：https://www.runoob.com/design-pattern/factory-pattern.html

public class Client {

	public static void main(String[] args) {

		// 测试在没有工厂模式的情况下
		Car c1 = new AudiCar();
		Car c2 = new BydCar();
		c1.run();
		c2.run();

		// 简单工厂情况下  --- 开发一般用简单工厂模式（需要增加工厂类的代码）
		Car c3 = CarFactory2.createCar("奥迪");
		Car c4 = CarFactory2.createCar("比亚迪");

		c3.run();
		c4.run();
	}

}
