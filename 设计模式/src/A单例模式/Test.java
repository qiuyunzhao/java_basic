package A单例模式;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.util.concurrent.CountDownLatch;

public class Test {

	public static void main(String[] args) throws Exception {

		// test01();// 测试饿汉式

		// test02();// 懒汉式

		// test03();// 双重检测式

		// test04();// 静态内部类式

		// test05();// 枚举式

		// test06();// 通过反射的方式直接调用私有构造器，破解单例模式

		// test07(); // 通过序列化和反序列化的方式，破解单例模式

		// test08(); //防止反序列化破坏单例模式

		test09(); // 各种单例模式的效率测试

	}

	// 测试各种单例模式的效率
	private static void test09() throws InterruptedException {
		long start = System.currentTimeMillis();
		int threadNum = 10;
		// countDownLatch相当于记录当前线程数的计数器，结束一个线程countDownLatch减一
		final CountDownLatch countDownLatch = new CountDownLatch(threadNum);
		for (int i = 0; i < threadNum; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {

					for (int i = 0; i < 100000000; i++) {
						// Object o = HungrierSingleton.getInstance(); //32ms
						// Object o = LazySingleton.getInstance(); //2393ms
						// Object o = DoubleCheckedSingleton.getInstance(); //60ms
						Object o = InnerClassSingleton.getInstance(); // 39ms
						// Object o = EnumSingleton.INSTANCE; //26ms
					}

					countDownLatch.countDown(); // 计数器减一
				}
			}).start();
		}
		countDownLatch.await(); // main线程阻塞，直到计数器变为0，才会继续往下执行！
		long end = System.currentTimeMillis();
		System.out.println("总耗时：" + (end - start) + "ms");
	}

	// 防止反序列化破坏单例模式
	private static void test08() throws Exception {
		// 通过反序列化的方式构造多个对象
		LazySingleton2 s1 = LazySingleton2.getInstance();
		System.out.println(s1);

		FileOutputStream fos = new FileOutputStream("a.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(s1);
		oos.close();
		fos.close();

		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("a.txt"));
		LazySingleton2 s3 = (LazySingleton2) ois.readObject();
		System.out.println(s3);
		ois.close();
	}

	// 通过序列化和反序列化的方式，破解单例模式
	private static void test07() throws Exception {
		// 通过反序列化的方式构造多个对象
		LazySingleton s1 = LazySingleton.getInstance();
		System.out.println(s1);

		FileOutputStream fos = new FileOutputStream("a.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(s1);
		oos.close();
		fos.close();

		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("a.txt"));
		LazySingleton s3 = (LazySingleton) ois.readObject();
		System.out.println(s3);
		ois.close();
	}

	// 通过反射的方式直接调用私有构造器，破解单例模式
	private static void test06() throws Exception {
		Class<LazySingleton> clazz = (Class<LazySingleton>) Class.forName("A单例模式.LazySingleton");
		Constructor<LazySingleton> c = clazz.getDeclaredConstructor(null);
		c.setAccessible(true); // 使私有构造方法可以对外使用了，因此破坏了单例模式
		LazySingleton s3 = c.newInstance();
		LazySingleton s4 = c.newInstance();
		System.out.println(s3);
		System.out.println(s4);
	}

	// 枚举式
	private static void test05() {
		Thread[] t5 = new Thread[10];
		for (int i = 0; i < 10; i++) {
			t5[i] = new Thread(() -> {
				System.out.println(EnumSingleton.INSTANCE);
			});
			t5[i].start();
		}
	}

	// 静态内部类式
	private static void test04() {
		Thread[] t4 = new Thread[10];
		for (int i = 0; i < 10; i++) {
			t4[i] = new Thread(() -> {
				System.out.println(InnerClassSingleton.getInstance());
			});
			t4[i].start();
		}
	}

	// 双重检测式
	private static void test03() {
		Thread[] t3 = new Thread[10];
		for (int i = 0; i < 10; i++) {
			t3[i] = new Thread(() -> {
				System.out.println(DoubleCheckedSingleton.getInstance());
			});
			t3[i].start();
		}
	}

	// 懒汉式
	private static void test02() {
		Thread[] t2 = new Thread[10];
		for (int i = 0; i < 10; i++) {
			t2[i] = new Thread(() -> {
				System.out.println(LazySingleton.getInstance());
			});
			t2[i].start();
		}
	}

	// 测试饿汉式
	private static void test01() {
		Thread[] t1 = new Thread[10];
		for (int i = 0; i < 10; i++) {
			t1[i] = new Thread(() -> {
				System.out.println(HungrierSingleton.getInstance());
			});
			t1[i].start();
		}
	}

}
