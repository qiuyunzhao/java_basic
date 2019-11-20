package I动态代理模式;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 处理接口的 处理器
 */

public class StarHandler implements InvocationHandler {

	private Star realStar;

	public StarHandler(Star star) {
		this.realStar = star;
	}

	/**
	 * @param proxy
	 *            代理类
	 * @param method
	 *            正在调用的方法
	 * @param args
	 *            正在调用的方法的参数
	 * @return
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// 流程控制在该方法内部进行
		System.out.println("************ StarHandler.invoke() **************");

		Object object = null;
		System.out.println("代理进行演唱会的准备工作");
		
		if (method.getName().equals("sing")) {
			object = method.invoke(realStar, args);
		}

		System.out.println("代理进行演唱会的结束工作");
		return object;
	}

}
