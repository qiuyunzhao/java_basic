package V1�۲���ģʽ_�Լ�ʵ��;

public class ObserverB implements Observer {

	private int state; //ֵ��㲥�߶����ֵ����һ��
	
	@Override
	public void update(Subject subject) {
		this.state = ((ConcreteSubject)subject).getState();		
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

}
