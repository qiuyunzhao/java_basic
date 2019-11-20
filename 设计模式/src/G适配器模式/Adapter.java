package G适配器模式;

/**
 * 实现方法1(类适配方式)：采用了继承的方式，以后该类就不能继承其他类了，有很大局限性
 * 
 * 适配器 (类适配器方式) (相当于usb和ps/2的转接器)
 */
public class Adapter extends Adapted implements Target {
	@Override
	public void handleReq() {
		super.request();
	}
}