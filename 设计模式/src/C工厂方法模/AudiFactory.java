package C工厂方法模;

public class AudiFactory implements CarFactory {

	@Override
	public Car creatCar() {
		return new AudiCar();
	}



}
