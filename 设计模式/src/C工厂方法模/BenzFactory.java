package C��������ģ;

public class BenzFactory implements CarFactory {

	@Override
	public Car creatCar() {
		return new BenzCar();
	}



}
