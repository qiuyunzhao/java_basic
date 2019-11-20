package D抽象工厂模式;

public interface CarFactory {
	
	Engine createEngine();

	Seat createSeat();

	Tyre createTyre();
	
}