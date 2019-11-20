package C工厂方法模;

public class BenzFactory implements CarFactory {

	@Override
	public Car creatCar() {
		return new BenzCar();
	}



}
