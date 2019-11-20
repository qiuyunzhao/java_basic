package A����ģʽ;

/**
 * ����ʽ����ģʽ���̰߳�ȫ������Ч�ʸߣ�������ʱ���أ�
 * 
 * ������ʵ����Ҫ��ͨ�����²��裺
 * 
 * 1.������Ĺ��췽��˽�л� --> �������Ĵ�����޷����ø���Ĺ��췽����ʵ��������Ķ���ֻ��ͨ�������ṩ�ľ�̬�������õ������Ψһʵ����
 * 
 * 2.�����ṩ˽�еľ�̬���� --> �洢����ĵ�ַ��
 * 
 * 3.�������ṩһ����̬���� --> ��ȡ���ԣ�����ĵ�ַ����
 */

public class HungrierSingleton {

	// 2 ���ʼ��ʱ�����������������--����ʽ��û����ʱ���ص����ƣ���������ʱ����Ȼ�����̰߳�ȫ�ģ�
	private static HungrierSingleton instance = new HungrierSingleton();

	// 1 ���췽��˽�л�
	private HungrierSingleton() {
	}

	// 3 ����û��ͬ��������Ч�ʸߣ�
	public static HungrierSingleton getInstance() {
		return instance;
	}

}