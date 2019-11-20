package Q中介者模式;

public class Finacial implements Department {

	private Mediator m; // 持有中介者(总经理)的引用

	public Finacial(Mediator m) {
		this.m = m;
		m.register("finacial", this); // 代理类中进行注册
	}

	@Override
	public void outAction() {
		System.out.println("汇报工作！预算复合要求，可进行拨款?");
	}

	@Override
	public void selfAction() {
		System.out.println("进行资金核算！");
	}
}