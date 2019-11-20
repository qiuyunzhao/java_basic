package V2观察者模式_利用JDK提供的类和接口实现;

import java.util.Observable;

//广播者
public class ConcreteSubject extends Observable {

	private int state;

	public void set(int s) {
		
		state = s; // 广播对象的状态发生了改变

		setChanged(); // 表示广播对象已经做了更改
		notifyObservers(state); // 通知所有的观察者

	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
	
}