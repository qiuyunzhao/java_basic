package A单例模式;

/**
 * 饿汉式单例模式（对懒汉式的锁优化，由于JVM底层内部模型原因，偶尔会出问题，不建议使用）
 * 
 * 基本的实现思路
 * 
 * 1.将该类的构造方法私有化 --> 其他处的代码就无法调用该类的构造方法来实例化该类的对象，只有通过该类提供的静态方法来得到该类的唯一实例；
 * 
 * 2.该类提供私有的静态属性 --> 存储对象的地址；
 * 
 * 3.该类内提供一个静态方法 --> 获取属性（对象的地址）；
 */
public class DoubleCheckedSingleton {
	// 2.该类提供私有的静态属性(懒汉式)
	private static volatile DoubleCheckedSingleton instance; // volatile防止指令重排，其他线程拿到没有初始化的对象

	// 1.将类的构造方法私有化
	private DoubleCheckedSingleton() {

	}

	// 3.该类内提供一个静态方法
	public static DoubleCheckedSingleton getInstance() {
		// 双重检测，防止不必要的同步
		if (null != instance) {
			return instance;
		}
		synchronized (DoubleCheckedSingleton.class) {
			if (null == instance) {
				// 执行步骤1.开辟空间 2.初始化对象 3.返回对象的地址
				// 可能存在指令重排问题，2没执行完之前先执行3，导致一个线程正在初始化对象，另一个线程却拿到了该对象的地址，导致空指针异常
				instance = new DoubleCheckedSingleton();
			}
		}
		return instance;
	}



}
