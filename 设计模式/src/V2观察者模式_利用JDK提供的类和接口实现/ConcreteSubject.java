package V2�۲���ģʽ_����JDK�ṩ����ͽӿ�ʵ��;

import java.util.Observable;

//�㲥��
public class ConcreteSubject extends Observable {

	private int state;

	public void set(int s) {
		
		state = s; // �㲥�����״̬�����˸ı�

		setChanged(); // ��ʾ�㲥�����Ѿ����˸���
		notifyObservers(state); // ֪ͨ���еĹ۲���

	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
	
}