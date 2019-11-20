package com.TestInterface;

/**
 * 声明格式： [访问修饰符] interface 接口名 [extends 父接口1，父接口2…] { 常量定义； 方法定义； }
 * 
 * 定义接口的详细说明： 
 *  1. 访问修饰符：只能是public或默认。
 *  2. 接口名：和类名采用相同命名机制。 
 *  3. extends：接口可以多继承。
 *  4. * 常量：接口中的属性只能是常量，总是：public static final 修饰。不写也是。 5. 方法：接口中的方法只能是：public abstract。 省略的话，也是public abstract。
 * 
 * 要点
 *  1. 子类通过implements来实现接口中的规范。 
 *  2. 接口不能创建实例，但是可用于声明引用变量类型。
 *  3. 一个类实现了接口，必须实现接口中所有的方法，并且这些方法只能是public的。
 *  4. JDK1.7之前，接口中只能包含静态常量、抽象方法，不能有普通属性、构造方法、普通方法。 
 *  5. JDK1.8后，接口中包含普通的静态方法。
 */

public class TestInterface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Volant volant = new AngelBaby();
        volant.fly();
        System.out.println(Volant.FLY_HIGHT);
         
        Honest honest = new GoodMan();
        honest.helpOther();
	}

}

/**
 * 飞行接口
 */
interface Volant {
	int FLY_HIGHT = 100; // 总是：public static final类型的；
	void fly(); // 总是：public abstract void fly();
}

/**
 * 善良接口
 */
interface Honest {
	void helpOther();
}

/**
 * 一个接口继承多个接口
 */
interface Angel extends Volant,Honest{
	void speek();
}

/**
 * 没有实现所有接口的所有方法的类必须为抽象类
 */
abstract class Bird implements Volant, Honest {
	@Override
	public void fly() {
		// TODO Auto-generated method stub
		System.out.println("我是小鸟，我会飞！");
	}
}

class AngelBaby implements Volant, Honest {

	@Override
	public void helpOther() {
		// TODO Auto-generated method stub
		System.out.println("扶老奶奶过马路！");
	}

	@Override
	public void fly() {
		// TODO Auto-generated method stub
		System.out.println("我是天使，飞起来啦！");
	}

}

class GoodMan implements Honest {
	public void helpOther() {
		System.out.println("扶老奶奶过马路！");
	}
}

class BirdMan implements Volant {
	public void fly() {
		System.out.println("我是鸟人，正在飞！");
	}
}
