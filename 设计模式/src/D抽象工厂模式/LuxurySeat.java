package D抽象工厂模式;

public class LuxurySeat implements Seat {

	@Override
	public void massage() {
		System.out.println("可以加热，自动按摩！");
	}

}