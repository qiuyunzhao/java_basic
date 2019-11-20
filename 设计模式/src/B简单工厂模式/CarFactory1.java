package B简单工厂模式;

/**
 * 工厂：实现了创建者和调用者的分离
 * 
 * 简单工厂模式缺点：增加新的类工厂中需要添加新的方法（但是是最常用的工厂模式）
 * 
 * oop设计原则：
 * 
 * ocp:对源码关闭，对扩展开放原则
 * 
 * dip:依赖翻转原则
 * 
 * 迪米特法则：
 */

// Card的工厂类
public class CarFactory1 {

	public static Car createAudi() {
		return new AudiCar();  //可以用克隆模式（原型模式）来创建
	}

	public static Car createByd() {
		return new BydCar();
	}

}
