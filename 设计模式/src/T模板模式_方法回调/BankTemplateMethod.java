package Tģ��ģʽ_�����ص�;

/**
 * ����һ�������࣬����ģ�巽��������Ϊ final
 */
public abstract class BankTemplateMethod {
	
	// ���巽��
	public void takeNumber() {
		System.out.println("ȡ���Ŷ�");
	}

	public abstract void transact(); // ���ģ���������ҵ�񣨹��ӷ���--�ص��������������ж��

	public void evaluate() {
		System.out.println("��������");
	}

	// ���ģ� ģ�巽��������
	public final void process() { 
		this.takeNumber();

		this.transact();

		this.evaluate();
	}
	
}