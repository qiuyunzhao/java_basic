package B�򵥹���ģʽ;

//˵����https://www.runoob.com/design-pattern/factory-pattern.html

public class Client {

	public static void main(String[] args) {

		// ������û�й���ģʽ�������
		Car c1 = new AudiCar();
		Car c2 = new BydCar();
		c1.run();
		c2.run();

		// �򵥹��������  --- ����һ���ü򵥹���ģʽ����Ҫ���ӹ�����Ĵ��룩
		Car c3 = CarFactory2.createCar("�µ�");
		Car c4 = CarFactory2.createCar("���ǵ�");

		c3.run();
		c4.run();
	}

}
