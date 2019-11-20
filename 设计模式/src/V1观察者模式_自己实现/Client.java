package V1观察者模式_自己实现;

public class Client {
	public static void main(String[] args) {
		// 目标对象
		ConcreteSubject subject = new ConcreteSubject();

		// 创建多个观察者
		ObserverA obsA1 = new ObserverA();
		ObserverA obsA2 = new ObserverA();
		ObserverB obsB1 = new ObserverB();
		ObserverB obsB2 = new ObserverB();

		// 将这三个观察者添加到subject对象的观察者队伍中
		subject.registerObserver(obsA1);
		subject.registerObserver(obsA2);
		subject.registerObserver(obsB1);
		subject.registerObserver(obsB2);

		// 改变subject的状态
		subject.setState(3000);
		System.out.println("########################");
		// 我们看看，观察者的状态是不是也发生了变化
		System.out.println(obsA1.getState());
		System.out.println(obsA2.getState());
		System.out.println(obsB1.getState());
		System.out.println(obsB2.getState());

		// 改变subject的状态
		subject.setState(30);
		System.out.println("########################");
		// 我们看看，观察者的状态是不是也发生了变化
		System.out.println(obsA1.getState());
		System.out.println(obsA2.getState());
		System.out.println(obsB1.getState());
		System.out.println(obsB2.getState());
	}
}