package D抽象工厂模式;

public class LowEngine implements Engine {

	@Override
	public void run() {
		System.out.println("低端引擎：转的慢！");
	}

	@Override
	public void start() {
		System.out.println("低端引擎：启动慢!");
	}

}