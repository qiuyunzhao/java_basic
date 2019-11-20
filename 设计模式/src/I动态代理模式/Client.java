package I��̬����ģʽ;

import java.lang.reflect.Proxy;

public class Client {

	public static void main(String[] args) {

		Star realStar = new RealStar(); // ��ʵ����
		StarHandler handler = new StarHandler(realStar); // ����ӿڵ� ����������

		// ��ȡ���������
		Star proxy = (Star) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[] { Star.class },handler);
		
		//ͨ����������������ʵ����ķ����������Ƚ��봦������invoke�������ڵ�����ʵ���еķ���
		proxy.confer();
		proxy.signContract();
		proxy.bookTicket();
		proxy.sing(); // �������ʵ��
		proxy.collectMoney();

	}

}
