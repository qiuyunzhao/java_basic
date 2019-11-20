package C工厂方法模;

public class Client {

	public static void main(String[] args) {

		// 工厂方法 情况下 之前的代码不用改变，只需要加一个类和一个对应的工厂类，但是会使得项目中类的数量很多（并不常用）
		Car c1 = new AudiFactory().creatCar();
		Car c2 = new BydFactory().creatCar();
		Car c3 = new BenzFactory().creatCar();

		c1.run();
		c2.run();
		c3.run();
	}

}
