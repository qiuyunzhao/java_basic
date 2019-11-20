package Q中介者模式;

public class Market implements Department {

	private Mediator m; // 持有中介者(总经理)的引用

	public Market(Mediator m) {
		this.m = m;
		m.register("market", this); //代理类中进行注册
	}

	@Override
	public void outAction() {
		System.out.println("市场---->经理");
		System.out.println("汇报工作！项目承接的进度，需要资金支持！");
		m.command("finacial");
	}

	@Override
	public void selfAction() {
		System.out.println("跑去接项目！");
	}
	
}