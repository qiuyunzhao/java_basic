package B�򵥹���ģʽ;

/**
 * �򵥹���ģʽȱ�㣺�����µ��๤������Ҫ����µķ���
 * 
 * ������ʵ���˴����ߺ͵����ߵķ���
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
public class CarFactory2 {

	public static Car createCar(String type) {
		
		if(null == type) {
			return null;
		}
		if ("�µ�".equals(type)) {
			return new AudiCar();
		} else if ("���ǵ�".equals(type)) {
			return new BydCar();
		} else {
			return null;
		}
	}

}
