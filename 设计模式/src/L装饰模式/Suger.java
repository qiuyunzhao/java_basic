package Lװ��ģʽ;

/**
 * 4.����װ����
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
		return super.info() + "--��������";
	}

}