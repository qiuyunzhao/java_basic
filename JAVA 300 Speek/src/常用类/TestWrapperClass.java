package 常用类;

//	byte     --> Byte

//	boolean  --> Boolean
//	short    --> Short
//	char     --> Character
//	int      --> Integer
//	long     --> Long
//	float    --> Float
//	double   --> Double

public class TestWrapperClass {

	/** 测试Integer的用法，其他包装类与Integer类似 */
	void testInteger() {
		// 基本类型转化成Integer对象
		Integer int1 = new Integer(10);
		Integer int2 = Integer.valueOf(20); // 官方推荐这种写法

		// Integer对象转化成int
		int a = int1.intValue();

		// 字符串转化成Integer对象
		Integer int4 = new Integer("999");
		Integer int3 = Integer.parseInt("334");

		// Integer对象转化成字符串
		String str1 = int3.toString();

		// 一些常见int类型相关的常量
		System.out.println("int能表示的最大整数：" + Integer.MAX_VALUE);
	}

	/** 自动装箱(autoboxing) */
	void testAutoboxing() {
		Integer i1 = 100;// 自动装箱
		// 相当于编译器自动为您作以下的语法编译：
		// Integer b = Integer.valueOf(100);//调用的是valueOf(100)，而不是new Integer(100)
	}

	/** 自动拆箱(unboxing) */
	void testUnboxing() {
		Integer i = 100;
		int j = i;// 自动拆箱
		// 相当于编译器自动为您作以下的语法编译：
		// int j = i.intValue();
		// 下面的问题我们需要注意：
		Integer c = null;
		int d = c; // 此处其实就是：c.intValue(),因此抛空指针异常
	}

	/**
	 * 缓存测试 整型、char类型所对应的包装类，在自动装箱时，对于-128~127之间的值会进行缓存处理，其目的是提高效率。
	 * 缓存处理的原理为：
	 * 如果数据在-128~127这个区间，那么在类加载时就已经为该区间的每个数值创建了对象，并将这256个对象存放到一个名为cache的数组中。
	 * 每当自动装箱过程发生时(或者手动调用valueOf()时)，就会先判断数据是否在该区间，如果在则直接获取数组中对应的包装类对象的引用，
	 * 如果不在该区间，则会通过new调用包装类的构造方法来创建对象。
	 */
	void testCache() {
		Integer in1 = -128;
		Integer in2 = -128;
		System.out.println(in1 == in2);// true 因为123在缓存范围内
		System.out.println(in1.equals(in2));// true
		Integer in3 = 1234;
		Integer in4 = 1234;
		System.out.println(in3 == in4);// false 因为1234不在缓存范围内
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
