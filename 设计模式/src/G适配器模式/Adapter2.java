package G������ģʽ;

/**
 * ������ (������������ʽ,ʹ������ϵķ�ʽ���������������) (�൱��usb��ps/2��ת����)
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
