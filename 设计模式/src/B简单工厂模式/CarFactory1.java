package B�򵥹���ģʽ;

/**
 * ������ʵ���˴����ߺ͵����ߵķ���
 * 
 * �򵥹���ģʽȱ�㣺�����µ��๤������Ҫ����µķ�������������õĹ���ģʽ��
 * 
 * oop���ԭ��
 * 
 * ocp:��Դ��رգ�����չ����ԭ��
 * 
 * dip:������תԭ��
 * 
 * �����ط���
 */

// Card�Ĺ�����
public class CarFactory1 {

	public static Car createAudi() {
		return new AudiCar();  //�����ÿ�¡ģʽ��ԭ��ģʽ��������
	}

	public static Car createByd() {
		return new BydCar();
	}

}
