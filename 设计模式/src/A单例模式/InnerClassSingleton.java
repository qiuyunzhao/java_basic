package A����ģʽ;

/**
 * ��̬�ڲ��൥��ģʽ���̰߳�ȫ������Ч�ʸߣ������ӳټ���-�����أ�--����
 * 
 * ������ʵ��˼·
 * 
 * 1.������Ĺ��췽��˽�л� --> �������Ĵ�����޷����ø���Ĺ��췽����ʵ��������Ķ���ֻ��ͨ�������ṩ�ľ�̬�������õ������Ψһʵ����
 * 
 * 2.�����ṩ˽�еľ�̬�ڲ���--> �洢����ĵ�ַ��
 * 
 * 3.�������ṩһ����̬���� --> ��ȡ���ԣ�����ĵ�ַ����
 */

public class InnerClassSingleton {

	// 2 ���ʼ��ʱ�������ʼ���ڲ���--�����أ�
	private static class SingletonClassInstance {
		private static final InnerClassSingleton instance = new InnerClassSingleton(); // ������ʱ���̰߳�ȫ��
	}

	// 1 ���췽��˽�л�
	private InnerClassSingleton() {
	}

	// 3 ��������ͬ��������Ч�ʸߣ�
	public static InnerClassSingleton getInstance() {
		return SingletonClassInstance.instance; // �ⲿ����getInstance()ִ�д˴�ʱʱ�Ż����--�ӳټ���
	}

}
