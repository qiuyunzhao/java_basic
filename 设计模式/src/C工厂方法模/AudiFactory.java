package C��������ģ;

public class AudiFactory implements CarFactory {

	@Override
	public Car creatCar() {
		return new AudiCar();
	}



}
