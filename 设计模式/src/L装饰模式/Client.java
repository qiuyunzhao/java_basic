package L装饰模式;

/**
 * 以咖啡为例 1.抽象组件：需要装饰的抽象对象（接口或抽象父类）
 * 
 * 2.具体组件：需要装饰的对象
 * 
 * 3.抽象装饰类：包含了对抽象组件的引用以及装饰着共有的方法
 * 
 * 4.具体装饰类：装饰的对象
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
