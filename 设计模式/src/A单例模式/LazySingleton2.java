package A����ģʽ;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * ����ģʽҪ�����ܹ��з��ض���һ������(��Զ��ͬһ��)��һ����ø�ʵ���ķ����������Ǿ�̬������ͨ��ʹ��getInstance������ƣ���
 * 
 * ����ʽ����ģʽ���̰߳�ȫ������Ч�ʲ��ߣ�������ʱ���أ�
 * 
 * ������ʵ����Ҫ��ͨ�����²��裺
 * 
 * 1.������Ĺ��췽��˽�л� --> �������Ĵ�����޷����ø���Ĺ��췽����ʵ��������Ķ���ֻ��ͨ�������ṩ�ľ�̬�������õ������Ψһʵ����
 * 
 * 2.�����ṩ˽�еľ�̬���� --> �洢����ĵ�ַ��
 * 
 * 3.�������ṩһ����̬���� --> ��ȡ���ԣ�����ĵ�ַ����
 *
 */
public class LazySingleton2 implements Serializable {

	// 2 ���ʼ��ʱ������ʼ���������--����ʽ����ʱ���أ������õ�ʱ���ٴ�������
	private static LazySingleton2 instance;

	// 1 ���췽��˽�л�
	private LazySingleton2() {
	}

	// 3 ����ͬ��������Ч�ʵͣ����߳�Ҫ�ȴ�����
	public static synchronized LazySingleton2 getInstance() {
		if (instance == null) {
			instance = new LazySingleton2();
		}
		return instance;
	}

	// �����л�ʱ�����������readResolve()��ֱ�ӷ��ش˷���ָ���Ķ��󡣶�����Ҫ�����ٴ����¶��󣡣���ֹ���л��ͷ����л��������ƻ�����ģʽ��
	private Object readResolve() throws ObjectStreamException {
		return instance;
	}

}
