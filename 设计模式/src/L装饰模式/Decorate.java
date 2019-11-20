package Lװ��ģʽ;

/**
 * 3.����װ����
 */
public abstract class Decorate implements Drink {
	
	// �Գ������������
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