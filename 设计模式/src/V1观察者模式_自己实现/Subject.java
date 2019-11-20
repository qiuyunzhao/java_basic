package V1观察者模式_自己实现;

import java.util.ArrayList;
import java.util.List;

/**
 * 广播类
 */
public class Subject {

	protected List<Observer> list = new ArrayList<Observer>();

	public void registerObserver(Observer obs) {
		list.add(obs);
	}

	public void removeObserver(Observer obs) {
		list.add(obs);
	}

	// 通知所有的观察者更新状态
	public void notifyAllObservers() {
		for (Observer obs : list) {
			obs.update(this);
		}
	}
	
}