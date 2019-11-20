package L装饰模式;

/**
 * 4.具体装饰类
 */
public class Suger extends Decorate {

	public Suger(Drink drink) {
		super(drink);

	}

	@Override
	public double cost() {
		return super.cost() + 2;
	}

	@Override
	public String info() {
		return super.info() + "--加入了糖";
	}

}