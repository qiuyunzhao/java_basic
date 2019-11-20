package A单例模式;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * 单例模式要求类能够有返回对象一个引用(永远是同一个)和一个获得该实例的方法（必须是静态方法，通常使用getInstance这个名称）。
 * 
 * 懒汉式单例模式（线程安全，调用效率不高，可以延时加载）
 * 
 * 单例的实现主要是通过以下步骤：
 * 
 * 1.将该类的构造方法私有化 --> 其他处的代码就无法调用该类的构造方法来实例化该类的对象，只有通过该类提供的静态方法来得到该类的唯一实例；
 * 
 * 2.该类提供私有的静态属性 --> 存储对象的地址；
 * 
 * 3.该类内提供一个静态方法 --> 获取属性（对象的地址）；
 *
 */
public class LazySingleton2 implements Serializable {

	// 2 类初始化时，不初始化这个对象--懒汉式（延时加载，真正用的时候再创建）。
	private static LazySingleton2 instance;

	// 1 构造方法私有化
	private LazySingleton2() {
	}

	// 3 方法同步，调用效率低（多线程要等待）！
	public static synchronized LazySingleton2 getInstance() {
		if (instance == null) {
			instance = new LazySingleton2();
		}
		return instance;
	}

	// 反序列化时，如果定义了readResolve()则直接返回此方法指定的对象。而不需要单独再创建新对象！（防止序列化和反序列化过程中破坏单例模式）
	private Object readResolve() throws ObjectStreamException {
		return instance;
	}

}
