package R����ģʽ;

/**
 * ����ӿ�
 */
public interface Command {

	// ���������һ�����ؽ��Ϊ�յķ����� ʵ����Ŀ�У����Ը���������ƶ����ͬ�ķ���
	void execute();

}

/**
 * ʵ���� Order �ӿڵ�����ʵ����
 */
class BuyCommand implements Command {
	
	private Receiver receiver; // �����������ִ����

	public BuyCommand(Receiver receiver) {
		this.receiver = receiver;
	}

	@Override
	public void execute() {
		// ��������ִ��ǰ���ִ����صĴ���������༭��
		receiver.buy();
	}
	
}

/**
 * ʵ���� Order �ӿڵ�����ʵ����
 */
class PayCommand implements Command {
	
	private Receiver receiver; // �����������ִ����

	public PayCommand(Receiver receiver) {
		this.receiver = receiver;
	}

	@Override
	public void execute() {
		// ��������ִ��ǰ���ִ����صĴ���������༭��
		receiver.pay();
	}
	
}