package T模板模式_方法回调;

/**
 * 创建一个抽象类，它的模板方法被设置为 final
 */
public abstract class BankTemplateMethod {
	
	// 具体方法
	public void takeNumber() {
		System.out.println("取号排队");
	}

	public abstract void transact(); // 核心：办理具体的业务（钩子方法--回调方法），可以有多个

	public void evaluate() {
		System.out.println("反馈评分");
	}

	// 核心： 模板方法！！！
	public final void process() { 
		this.takeNumber();

		this.transact();

		this.evaluate();
	}
	
}