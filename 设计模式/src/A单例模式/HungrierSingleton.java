package A单例模式;

/**
 * 饿汉式单例模式（线程安全，调用效率高，不能延时加载）
 * 
 * 单例的实现主要是通过以下步骤：
 * 
 * 1.将该类的构造方法私有化 --> 其他处的代码就无法调用该类的构造方法来实例化该类的对象，只有通过该类提供的静态方法来得到该类的唯一实例；
 * 
 * 2.该类提供私有的静态属性 --> 存储对象的地址；
 * 
 * 3.该类内提供一个静态方法 --> 获取属性（对象的地址）；
 */

public class HungrierSingleton {

	// 2 类初始化时，立即加载这个对象--饿汉式（没有延时加载的优势）。加载类时，自然的是线程安全的！
	private static HungrierSingleton instance = new HungrierSingleton();

	// 1 构造方法私有化
	private HungrierSingleton() {
	}

	// 3 方法没有同步，调用效率高！
	public static HungrierSingleton getInstance() {
		return instance;
	}

}