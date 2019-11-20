package L装饰模式;

/**
 * 4.具体装饰类
 */
public class Milk extends Decorate {

	public Milk(Drink drink) {
		super(drink);

	}

	@Override
	public double cost() {
		return super.cost() + 5;
	}

	@Override
	public String info() {
		return super.info() + "--加入了牛奶";
	}

}