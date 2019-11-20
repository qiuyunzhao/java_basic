package 基础_1;

public class AnnotitionTest {

	// 重写
	@Override
	public String toString() {
		return super.toString();
	}

	// 不建议使用，过时的
	@Deprecated
	public static void test01() {
		System.out.println("@Deprecated");
	}

	public static void main(String[] args) {

		test01();

	}

}
