package A单例模式;

/**
 * 枚举单例模式（线程安全，调用效率高，不能延迟加载，防止反射和反序列化漏洞）
 * 
 * 基本的实现思路
 * 
 * 定义一个枚举元素，枚举元素本身就是唯一的
 */

public enum EnumSingleton {

	// 这个枚举元素，本身就是单例对象！
	INSTANCE;

	// 添加自己需要的操作！
	public void singletonOperation() {
	}

}
