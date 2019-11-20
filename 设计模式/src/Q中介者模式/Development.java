package Q中介者模式;

public class Development implements Department {

	private Mediator m; // 持有中介者(总经理)的引用

	public Development(Mediator m) {
		this.m = m;
		m.register("development", this); // 代理类中进行注册
	}

	@Override
	public void outAction() {
		System.out.println("汇报工作！没钱了，需要资金支持！");
	}

	@Override
	public void selfAction() {
		System.out.println("专心科研，开发项目！");
	}
}