package D抽象工厂模式;

public class Client {
	
	//说明：https://www.runoob.com/design-pattern/abstract-factory-pattern.html
	
	public static void main(String[] args) {
		
		//抽象工厂模式   用来创建类族
		
		CarFactory factory = new LuxuryCarFactory();
		
		Engine e = factory.createEngine();
		e.run();
		e.start();
		
		Seat s = factory.createSeat();
		s.massage();
		
		Tyre t = factory.createTyre();
		t.revolve();
		
	}

}
