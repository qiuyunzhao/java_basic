package L装饰模式;

/**
 * 3.抽象装饰类
 */
public abstract class Decorate implements Drink {
	
	// 对抽象组件的引用
	private Drink drink;

	public Decorate(Drink drink) {
		this.drink = drink;
	}

	@Override
	public double cost() {
		return this.drink.cost();
	}

	@Override
	public String info() {
		return this.drink.info();
	}

}