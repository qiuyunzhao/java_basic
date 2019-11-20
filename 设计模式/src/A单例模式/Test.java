package A����ģʽ;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.util.concurrent.CountDownLatch;

public class Test {

	public static void main(String[] args) throws Exception {

		// test01();// ���Զ���ʽ

		// test02();// ����ʽ

		// test03();// ˫�ؼ��ʽ

		// test04();// ��̬�ڲ���ʽ

		// test05();// ö��ʽ

		// test06();// ͨ������ķ�ʽֱ�ӵ���˽�й��������ƽⵥ��ģʽ

		// test07(); // ͨ�����л��ͷ����л��ķ�ʽ���ƽⵥ��ģʽ

		// test08(); //��ֹ�����л��ƻ�����ģʽ

		test09(); // ���ֵ���ģʽ��Ч�ʲ���

	}

	// ���Ը��ֵ���ģʽ��Ч��
	private static void test09() throws InterruptedException {
		long start = System.currentTimeMillis();
		int threadNum = 10;
		// countDownLatch�൱�ڼ�¼��ǰ�߳����ļ�����������һ���߳�countDownLatch��һ
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

					countDownLatch.countDown(); // ��������һ
				}
			}).start();
		}
		countDownLatch.await(); // main�߳�������ֱ����������Ϊ0���Ż��������ִ�У�
		long end = System.currentTimeMillis();
		System.out.println("�ܺ�ʱ��" + (end - start) + "ms");
	}

	// ��ֹ�����л��ƻ�����ģʽ
	private static void test08() throws Exception {
		// ͨ�������л��ķ�ʽ����������
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

	// ͨ�����л��ͷ����л��ķ�ʽ���ƽⵥ��ģʽ
	private static void test07() throws Exception {
		// ͨ�������л��ķ�ʽ����������
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

	// ͨ������ķ�ʽֱ�ӵ���˽�й��������ƽⵥ��ģʽ
	private static void test06() throws Exception {
		Class<LazySingleton> clazz = (Class<LazySingleton>) Class.forName("A����ģʽ.LazySingleton");
		Constructor<LazySingleton> c = clazz.getDeclaredConstructor(null);
		c.setAccessible(true); // ʹ˽�й��췽�����Զ���ʹ���ˣ�����ƻ��˵���ģʽ
		LazySingleton s3 = c.newInstance();
		LazySingleton s4 = c.newInstance();
		System.out.println(s3);
		System.out.println(s4);
	}

	// ö��ʽ
	private static void test05() {
		Thread[] t5 = new Thread[10];
		for (int i = 0; i < 10; i++) {
			t5[i] = new Thread(() -> {
				System.out.println(EnumSingleton.INSTANCE);
			});
			t5[i].start();
		}
	}

	// ��̬�ڲ���ʽ
	private static void test04() {
		Thread[] t4 = new Thread[10];
		for (int i = 0; i < 10; i++) {
			t4[i] = new Thread(() -> {
				System.out.println(InnerClassSingleton.getInstance());
			});
			t4[i].start();
		}
	}

	// ˫�ؼ��ʽ
	private static void test03() {
		Thread[] t3 = new Thread[10];
		for (int i = 0; i < 10; i++) {
			t3[i] = new Thread(() -> {
				System.out.println(DoubleCheckedSingleton.getInstance());
			});
			t3[i].start();
		}
	}

	// ����ʽ
	private static void test02() {
		Thread[] t2 = new Thread[10];
		for (int i = 0; i < 10; i++) {
			t2[i] = new Thread(() -> {
				System.out.println(LazySingleton.getInstance());
			});
			t2[i].start();
		}
	}

	// ���Զ���ʽ
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
