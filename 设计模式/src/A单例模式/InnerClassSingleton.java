package A单例模式;

/**
 * 静态内部类单例模式（线程安全，调用效率高，可以延迟加载-懒加载）--常用
 * 
 * 基本的实现思路
 * 
 * 1.将该类的构造方法私有化 --> 其他处的代码就无法调用该类的构造方法来实例化该类的对象，只有通过该类提供的静态方法来得到该类的唯一实例；
 * 
 * 2.该类提供私有的静态内部类--> 存储对象的地址；
 * 
 * 3.该类内提供一个静态方法 --> 获取属性（对象的地址）；
 */

public class InnerClassSingleton {

	// 2 类初始化时，不会初始化内部类--懒加载！
	private static class SingletonClassInstance {
		private static final InnerClassSingleton instance = new InnerClassSingleton(); // 加载类时是线程安全的
	}

	// 1 构造方法私有化
	private InnerClassSingleton() {
	}

	// 3 方法不用同步，调用效率高！
	public static InnerClassSingleton getInstance() {
		return SingletonClassInstance.instance; // 外部调用getInstance()执行此处时时才会加载--延迟加载
	}

}
