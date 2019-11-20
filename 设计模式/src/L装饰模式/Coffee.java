package L装饰模式;

/**
 * 2.具体组件(被装饰对象)
 */
public class Coffee implements Drink {

	private String name = "原味咖啡";

	@Override
	public double cost() {
		return 10;
	}

	@Override
	public String info() {
		return name;
	}

}