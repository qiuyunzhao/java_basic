package A����ģʽ;

/**
 * ����ʽ����ģʽ��������ʽ�����Ż�������JVM�ײ��ڲ�ģ��ԭ��ż��������⣬������ʹ�ã�
 * 
 * ������ʵ��˼·
 * 
 * 1.������Ĺ��췽��˽�л� --> �������Ĵ�����޷����ø���Ĺ��췽����ʵ��������Ķ���ֻ��ͨ�������ṩ�ľ�̬�������õ������Ψһʵ����
 * 
 * 2.�����ṩ˽�еľ�̬���� --> �洢����ĵ�ַ��
 * 
 * 3.�������ṩһ����̬���� --> ��ȡ���ԣ�����ĵ�ַ����
 */
public class DoubleCheckedSingleton {
	// 2.�����ṩ˽�еľ�̬����(����ʽ)
	private static volatile DoubleCheckedSingleton instance; // volatile��ָֹ�����ţ������߳��õ�û�г�ʼ���Ķ���

	// 1.����Ĺ��췽��˽�л�
	private DoubleCheckedSingleton() {

	}

	// 3.�������ṩһ����̬����
	public static DoubleCheckedSingleton getInstance() {
		// ˫�ؼ�⣬��ֹ����Ҫ��ͬ��
		if (null != instance) {
			return instance;
		}
		synchronized (DoubleCheckedSingleton.class) {
			if (null == instance) {
				// ִ�в���1.���ٿռ� 2.��ʼ������ 3.���ض���ĵ�ַ
				// ���ܴ���ָ���������⣬2ûִ����֮ǰ��ִ��3������һ���߳����ڳ�ʼ��������һ���߳�ȴ�õ��˸ö���ĵ�ַ�����¿�ָ���쳣
				instance = new DoubleCheckedSingleton();
			}
		}
		return instance;
	}



}
