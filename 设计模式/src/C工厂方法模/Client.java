package C��������ģ;

public class Client {

	public static void main(String[] args) {

		// �������� ����� ֮ǰ�Ĵ��벻�øı䣬ֻ��Ҫ��һ�����һ����Ӧ�Ĺ����࣬���ǻ�ʹ����Ŀ����������ܶࣨ�������ã�
		Car c1 = new AudiFactory().creatCar();
		Car c2 = new BydFactory().creatCar();
		Car c3 = new BenzFactory().creatCar();

		c1.run();
		c2.run();
		c3.run();
	}

}
