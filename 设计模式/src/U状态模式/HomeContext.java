package U״̬ģʽ;

/**
 * �������
 * 
 * @author Administrator
 *
 */
public class HomeContext {

	private State state;

	public void setState(State s) {
		System.out.println("�޸�״̬��");
		state = s;
		state.handle(); // �л�״̬ʱ���þ���״̬��Ĳ�������
	}

}