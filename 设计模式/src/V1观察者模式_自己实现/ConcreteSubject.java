package V1�۲���ģʽ_�Լ�ʵ��;

/**
 * ����㲥��
 */
public class ConcreteSubject extends Subject {

	private int state; //����ֵ

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
		this.notifyAllObservers(); // �������(Ŀ�����)ֵ�����˱仯����֪ͨ���еĹ۲��߽���ֵ�仯
	}
	
}