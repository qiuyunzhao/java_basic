package S����ģʽ;

/**
 * ����;���Ĳ����ཻ���������Ļ���������㷨��ֱ�ӵĿͻ��˵��÷����ˣ�ʹ���㷨���Զ����ڿͻ��˶����ı仯��
 * ���ʹ��spring������ע�빦�ܣ�������ͨ�������ļ�����̬��ע�벻ͬ���Զ��󣬶�̬���л���ͬ���㷨.
 */
public class Context {
	
	private Strategy strategy; // ��ǰ���õ��㷨����

	// ����ͨ����������ע��
	public Context(Strategy strategy) {
		this.strategy = strategy;
	}

	// ����ͨ��set������ע��
	public void setStrategy(Strategy strategy) {
		this.strategy = strategy;
	}

	public void pringPrice(double s) {
		System.out.println("���ñ��ۣ�" + strategy.getPrice(s));
	}
}