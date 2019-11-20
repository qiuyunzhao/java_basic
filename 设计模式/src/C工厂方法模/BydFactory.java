package C工厂方法模;

public class BydFactory implements CarFactory {

	@Override
	public Car creatCar() {
		return new BydCar();

	}

}
