package H静态代理模式;

/**
 * 静态代理：自定义代理类
 * 
 * 动态代理：由程序自动生成代理类
 * 
 * 静态代理 核心：实现相同接口的两个角色类：1.真实角色 2.代理角色
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
 * 共同的接口
 */
interface Star {
	// 面谈
	void confer();

	// 签合同
	void signContract();

	// 订票
	void bookTicket();

	// 唱歌
	void sing();

	// 收钱
	void collectMoney();
}

/**
 * 真实角色
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
		System.out.println("RealStar(周杰伦本人).sing()");
	}

}

/**
 * 代理角色
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
