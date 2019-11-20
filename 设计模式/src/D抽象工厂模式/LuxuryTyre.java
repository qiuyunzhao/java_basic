package D抽象工厂模式;

class LuxuryTyre implements Tyre {

	@Override
	public void revolve() {
		System.out.println("旋转磨损慢！");
	}

}