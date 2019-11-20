package G适配器模式;

/**
 * 适配器 (对象适配器方式,使用了组合的方式跟被适配对象整合) (相当于usb和ps/2的转接器)
 * 
 * @author Administrator
 *
 */
public class Adapter2 implements Target {
	private Adapted adapted;

	@Override
	public void handleReq() {
		adapted.request();
	}

	public Adapter2(Adapted adapted) {
		this.adapted = adapted;
	}
}
