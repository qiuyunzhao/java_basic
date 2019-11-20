package I动态代理模式;

import java.lang.reflect.Proxy;

public class Client {

	public static void main(String[] args) {

		Star realStar = new RealStar(); // 真实对象
		StarHandler handler = new StarHandler(realStar); // 处理接口的 处理器对象

		// 获取代理类对象
		Star proxy = (Star) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[] { Star.class },handler);
		
		//通过代理类对象调用真实对象的方法，都会先进入处理器的invoke方法，在调用真实类中的方法
		proxy.confer();
		proxy.signContract();
		proxy.bookTicket();
		proxy.sing(); // 会调用真实类
		proxy.collectMoney();

	}

}
