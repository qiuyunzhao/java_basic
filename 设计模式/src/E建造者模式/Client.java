package E������ģʽ;

public class Client {

	public static void main(String[] args) {
		
		CarDirectorQYZ director = new CarDirectorQYZ(new CarBuilderQYZ());
		Car car = director.directCar();
		
		car.getComponent();
		System.out.println(car.getEngine().getName());
	}

}
