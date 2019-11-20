package B简单工厂模式;

/**
 * 简单工厂模式缺点：增加新的类工厂中需要添加新的方法
 * 
 * 工厂：实现了创建者和调用者的分离
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
public class CarFactory2 {

	public static Car createCar(String type) {
		
		if(null == type) {
			return null;
		}
		if ("奥迪".equals(type)) {
			return new AudiCar();
		} else if ("比亚迪".equals(type)) {
			return new BydCar();
		} else {
			return null;
		}
	}

}
