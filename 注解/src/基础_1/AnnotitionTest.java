package ����_1;

public class AnnotitionTest {

	// ��д
	@Override
	public String toString() {
		return super.toString();
	}

	// ������ʹ�ã���ʱ��
	@Deprecated
	public static void test01() {
		System.out.println("@Deprecated");
	}

	public static void main(String[] args) {

		test01();

	}

}
