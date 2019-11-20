package ������;

//	byte     --> Byte

//	boolean  --> Boolean
//	short    --> Short
//	char     --> Character
//	int      --> Integer
//	long     --> Long
//	float    --> Float
//	double   --> Double

public class TestWrapperClass {

	/** ����Integer���÷���������װ����Integer���� */
	void testInteger() {
		// ��������ת����Integer����
		Integer int1 = new Integer(10);
		Integer int2 = Integer.valueOf(20); // �ٷ��Ƽ�����д��

		// Integer����ת����int
		int a = int1.intValue();

		// �ַ���ת����Integer����
		Integer int4 = new Integer("999");
		Integer int3 = Integer.parseInt("334");

		// Integer����ת�����ַ���
		String str1 = int3.toString();

		// һЩ����int������صĳ���
		System.out.println("int�ܱ�ʾ�����������" + Integer.MAX_VALUE);
	}

	/** �Զ�װ��(autoboxing) */
	void testAutoboxing() {
		Integer i1 = 100;// �Զ�װ��
		// �൱�ڱ������Զ�Ϊ�������µ��﷨���룺
		// Integer b = Integer.valueOf(100);//���õ���valueOf(100)��������new Integer(100)
	}

	/** �Զ�����(unboxing) */
	void testUnboxing() {
		Integer i = 100;
		int j = i;// �Զ�����
		// �൱�ڱ������Զ�Ϊ�������µ��﷨���룺
		// int j = i.intValue();
		// ���������������Ҫע�⣺
		Integer c = null;
		int d = c; // �˴���ʵ���ǣ�c.intValue(),����׿�ָ���쳣
	}

	/**
	 * ������� ���͡�char��������Ӧ�İ�װ�࣬���Զ�װ��ʱ������-128~127֮���ֵ����л��洦����Ŀ�������Ч�ʡ�
	 * ���洦���ԭ��Ϊ��
	 * ���������-128~127������䣬��ô�������ʱ���Ѿ�Ϊ�������ÿ����ֵ�����˶��󣬲�����256�������ŵ�һ����Ϊcache�������С�
	 * ÿ���Զ�װ����̷���ʱ(�����ֶ�����valueOf()ʱ)���ͻ����ж������Ƿ��ڸ����䣬�������ֱ�ӻ�ȡ�����ж�Ӧ�İ�װ���������ã�
	 * ������ڸ����䣬���ͨ��new���ð�װ��Ĺ��췽������������
	 */
	void testCache() {
		Integer in1 = -128;
		Integer in2 = -128;
		System.out.println(in1 == in2);// true ��Ϊ123�ڻ��淶Χ��
		System.out.println(in1.equals(in2));// true
		Integer in3 = 1234;
		Integer in4 = 1234;
		System.out.println(in3 == in4);// false ��Ϊ1234���ڻ��淶Χ��
		System.out.println(in3.equals(in4));// true
	}

	public static void main(String[] args) {
		TestWrapperClass test = new TestWrapperClass();
		System.out.println("***********************");
		test.testInteger();
		System.out.println("***********************");
		test.testCache();
		System.out.println("***********************");
		test.testAutoboxing();
		test.testUnboxing();
	}

}
