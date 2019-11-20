package H��̬����ģʽ;

/**
 * ��̬�����Զ��������
 * 
 * ��̬�����ɳ����Զ����ɴ�����
 * 
 * ��̬���� ���ģ�ʵ����ͬ�ӿڵ�������ɫ�ࣺ1.��ʵ��ɫ 2.�����ɫ
 *
 */
public class StaticProxyDemo02 {

	public static void main(String[] args) {

		Star real = new RealStar();
		Star proxy = new ProxyStar(real);
		 
		proxy.confer();
		proxy.signContract();
		proxy.bookTicket();
		proxy.sing();
		proxy.collectMoney();
		
	}
}

/**
 * ��ͬ�Ľӿ�
 */
interface Star {
	// ��̸
	void confer();

	// ǩ��ͬ
	void signContract();

	// ��Ʊ
	void bookTicket();

	// ����
	void sing();

	// ��Ǯ
	void collectMoney();
}

/**
 * ��ʵ��ɫ
 */
class RealStar implements Star {

	@Override
	public void bookTicket() {
		System.out.println("RealStar.bookTicket()");
	}

	@Override
	public void collectMoney() {
		System.out.println("RealStar.collectMoney()");
	}

	@Override
	public void confer() {
		System.out.println("RealStar.confer()");
	}

	@Override
	public void signContract() {
		System.out.println("RealStar.signContract()");
	}

	@Override
	public void sing() {
		System.out.println("RealStar(�ܽ��ױ���).sing()");
	}

}

/**
 * �����ɫ
 */
class ProxyStar implements Star {

	private Star star;

	public ProxyStar(Star star) {
		this.star = star;
	}

	@Override
	public void bookTicket() {
		System.out.println("ProxyStar.bookTicket()");
	}

	@Override
	public void collectMoney() {
		System.out.println("ProxyStar.collectMoney()");
	}

	@Override
	public void confer() {
		System.out.println("ProxyStar.confer()");
	}

	@Override
	public void signContract() {
		System.out.println("ProxyStar.signContract()");
	}

	@Override
	public void sing() {
		star.sing();
	}

}
