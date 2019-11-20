package D抽象工厂模式;

public class LuxuryEngine implements Engine {

	@Override
	public void run() {
		System.out.println("高端引擎：转的快！");
	}

	@Override
	public void start() {
		System.out.println("高端引擎：启动快!");
	}

}