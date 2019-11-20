package Lװ��ģʽ;

/**
 * �Կ���Ϊ�� 1.�����������Ҫװ�εĳ�����󣨽ӿڻ�����ࣩ
 * 
 * 2.�����������Ҫװ�εĶ���
 * 
 * 3.����װ���ࣺ�����˶Գ�������������Լ�װ���Ź��еķ���
 * 
 * 4.����װ���ࣺװ�εĶ���
 */
public class Client {

	public static void main(String[] args) {

		Drink coffee = new Coffee();
		System.out.println(coffee.info() + "-->" + coffee.cost());

		Drink suger = new Suger(coffee);
		System.out.println(suger.info() + "-->" + suger.cost());

		Drink milk = new Milk(coffee);
		System.out.println(milk.info() + "-->" + milk.cost());

		milk = new Milk(suger);
		System.out.println(milk.info() + "-->" + milk.cost());
		
		Drink mix = new Suger(new Milk(new Coffee()));
		System.out.println(mix.info() + "-->" + mix.cost());
	}
}
