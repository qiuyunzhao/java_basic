package D���󹤳�ģʽ;

public class Client {
	
	//˵����https://www.runoob.com/design-pattern/abstract-factory-pattern.html
	
	public static void main(String[] args) {
		
		//���󹤳�ģʽ   ������������
		
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
