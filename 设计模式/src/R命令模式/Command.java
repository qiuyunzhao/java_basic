package R命令模式;

/**
 * 命令接口
 */
public interface Command {

	// 这个方法是一个返回结果为空的方法。 实际项目中，可以根据需求设计多个不同的方法
	void execute();

}

/**
 * 实现了 Order 接口的命令实体类
 */
class BuyCommand implements Command {
	
	private Receiver receiver; // 命令的真正的执行者

	public BuyCommand(Receiver receiver) {
		this.receiver = receiver;
	}

	@Override
	public void execute() {
		// 命令真正执行前或后，执行相关的处理在这里编辑！
		receiver.buy();
	}
	
}

/**
 * 实现了 Order 接口的命令实体类
 */
class PayCommand implements Command {
	
	private Receiver receiver; // 命令的真正的执行者

	public PayCommand(Receiver receiver) {
		this.receiver = receiver;
	}

	@Override
	public void execute() {
		// 命令真正执行前或后，执行相关的处理在这里编辑！
		receiver.pay();
	}
	
}