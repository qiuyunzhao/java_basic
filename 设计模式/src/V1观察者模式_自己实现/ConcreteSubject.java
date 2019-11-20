package V1观察者模式_自己实现;

/**
 * 具体广播类
 */
public class ConcreteSubject extends Subject {

	private int state; //属性值

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
		this.notifyAllObservers(); // 主题对象(目标对象)值发生了变化，请通知所有的观察者进行值变化
	}
	
}