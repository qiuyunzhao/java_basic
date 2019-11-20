package V1观察者模式_自己实现;

public class ObserverB implements Observer {

	private int state; //值与广播者对象的值保持一致
	
	@Override
	public void update(Subject subject) {
		this.state = ((ConcreteSubject)subject).getState();		
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

}
