package D抽象工厂模式;

public class LowSeat implements Seat {

	@Override
	public void massage() {
		System.out.println("不能按摩！");
	}

}