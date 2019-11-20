package V1�۲���ģʽ_�Լ�ʵ��;

public class Client {
	public static void main(String[] args) {
		// Ŀ�����
		ConcreteSubject subject = new ConcreteSubject();

		// ��������۲���
		ObserverA obsA1 = new ObserverA();
		ObserverA obsA2 = new ObserverA();
		ObserverB obsB1 = new ObserverB();
		ObserverB obsB2 = new ObserverB();

		// ���������۲�����ӵ�subject����Ĺ۲��߶�����
		subject.registerObserver(obsA1);
		subject.registerObserver(obsA2);
		subject.registerObserver(obsB1);
		subject.registerObserver(obsB2);

		// �ı�subject��״̬
		subject.setState(3000);
		System.out.println("########################");
		// ���ǿ������۲��ߵ�״̬�ǲ���Ҳ�����˱仯
		System.out.println(obsA1.getState());
		System.out.println(obsA2.getState());
		System.out.println(obsB1.getState());
		System.out.println(obsB2.getState());

		// �ı�subject��״̬
		subject.setState(30);
		System.out.println("########################");
		// ���ǿ������۲��ߵ�״̬�ǲ���Ҳ�����˱仯
		System.out.println(obsA1.getState());
		System.out.println(obsA2.getState());
		System.out.println(obsB1.getState());
		System.out.println(obsB2.getState());
	}
}