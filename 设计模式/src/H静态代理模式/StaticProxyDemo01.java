package H静态代理模式;

/**
 * 静态代理：自定义代理类
 * 
 * 动态代理：由程序自动生成代理类
 * 
 * 静态代理 核心：实现相同接口的两个角色类：1.真实角色 2.代理角色
 *
 */
public class StaticProxyDemo01 {

	public static void main(String[] args) {
		Bridegroom bridegroom = new Bridegroom();
		Bride bride = new Bride();
		new WeddingCompany(bridegroom, bride).happyMarry();
	}
}

/**
 * 共同的接口
 */
interface Marry {
	void happyMarry();
}

/**
 * 真实角色
 */
class Bridegroom implements Marry {

	@Override
	public void happyMarry() {
		System.out.println("婚礼的主角：新郎");
	}

}

/**
 * 真实角色
 */
class Bride implements Marry {

	@Override
	public void happyMarry() {
		System.out.println("婚礼的主角：新娘");
	}

}

/**
 * 代理角色
 */
class WeddingCompany implements Marry {
	// 代理对象（真实角色）
	private Bridegroom target1;
	private Bride target2;

	public WeddingCompany(Bridegroom target1, Bride target2) {
		this.target1 = target1;
		this.target2 = target2;
	}

	@Override
	public void happyMarry() {
		readyWork();
		this.target1.happyMarry();
		this.target2.happyMarry();
		afterWork();
	}
	
	//实际应用时可以记录日志
	private void readyWork() {
		System.out.println("收拾会场");
	}

	private void afterWork() {
		System.out.println("布置会场");
	}

}
