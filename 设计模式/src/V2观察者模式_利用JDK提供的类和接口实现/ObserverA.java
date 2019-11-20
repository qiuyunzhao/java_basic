package V2观察者模式_利用JDK提供的类和接口实现;

import java.util.Observable;
import java.util.Observer;

/**
 * 观察者
 */
public class ObserverA implements Observer {

	private int myState;

	@Override
	public void update(Observable o, Object arg) {
		myState = ((ConcreteSubject) o).getState();
	}

	public int getMyState() {
		return myState;
	}

	public void setMyState(int myState) {
		this.myState = myState;
	}
}
