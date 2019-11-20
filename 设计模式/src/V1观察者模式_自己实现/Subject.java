package V1�۲���ģʽ_�Լ�ʵ��;

import java.util.ArrayList;
import java.util.List;

/**
 * �㲥��
 */
public class Subject {

	protected List<Observer> list = new ArrayList<Observer>();

	public void registerObserver(Observer obs) {
		list.add(obs);
	}

	public void removeObserver(Observer obs) {
		list.add(obs);
	}

	// ֪ͨ���еĹ۲��߸���״̬
	public void notifyAllObservers() {
		for (Observer obs : list) {
			obs.update(this);
		}
	}
	
}