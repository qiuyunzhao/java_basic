package R命令模式;

public class Client {
	public static void main(String[] args) {

		// 创建执行者
		Receiver receiver = new Receiver();

		// 创建命令
		Command buyCommand = new BuyCommand(receiver);
		Command payCommand = new PayCommand(receiver);

		// 创建命令调用者
		Invoke invoke = new Invoke();
		// 添加命令
		invoke.addOrder(buyCommand);
		invoke.addOrder(payCommand);
		// 一次性执行所有命令
		invoke.callOrders();

	}
}