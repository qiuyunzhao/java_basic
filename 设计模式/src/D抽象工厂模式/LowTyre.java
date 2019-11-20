package D抽象工厂模式;

public class LowTyre implements Tyre {

	@Override
	public void revolve() {
		System.out.println("旋转磨损快！");
	}

}