package R����ģʽ;

public class Client {
	public static void main(String[] args) {

		// ����ִ����
		Receiver receiver = new Receiver();

		// ��������
		Command buyCommand = new BuyCommand(receiver);
		Command payCommand = new PayCommand(receiver);

		// �������������
		Invoke invoke = new Invoke();
		// �������
		invoke.addOrder(buyCommand);
		invoke.addOrder(payCommand);
		// һ����ִ����������
		invoke.callOrders();

	}
}