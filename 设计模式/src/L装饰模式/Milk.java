package Lװ��ģʽ;

/**
 * 4.����װ����
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
		return super.info() + "--������ţ��";
	}

}