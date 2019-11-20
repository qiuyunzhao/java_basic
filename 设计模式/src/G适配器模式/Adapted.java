package G适配器模式;

/**
 * 被适配的类 (相当于例子中的PS/2键盘,是PS/2口)
 */
public class Adapted {
	
	public void request() {
		System.out.println("可以完成客户请求的需要的功能！");
	}
	
}