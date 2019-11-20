package E������ģʽ;

public class CarDirectorQYZ implements CarDirector {

	private CarBuilder builder;

	public CarDirectorQYZ(CarBuilder builder) {
		this.builder = builder;
	}

	@Override
	public Car directCar() {
		// ���ù����ߴ������
		Engine engine = builder.builderEngine();
		Seat seat = builder.builderSeat();
		Tyre tyre = builder.builderTyre();

		/// �������װ��Car����
		Car car = new Car();
		car.setEngine(engine);
		car.setSeat(seat);
		car.setTyre(tyre);
		
		return car;
	}
}