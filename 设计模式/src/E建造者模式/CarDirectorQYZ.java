package E建造者模式;

public class CarDirectorQYZ implements CarDirector {

	private CarBuilder builder;

	public CarDirectorQYZ(CarBuilder builder) {
		this.builder = builder;
	}

	@Override
	public Car directCar() {
		// 调用构建者创建组件
		Engine engine = builder.builderEngine();
		Seat seat = builder.builderSeat();
		Tyre tyre = builder.builderTyre();

		/// 将组件组装成Car对象
		Car car = new Car();
		car.setEngine(engine);
		car.setSeat(seat);
		car.setTyre(tyre);
		
		return car;
	}
}