package W备忘录模式;

import java.util.ArrayList;
import java.util.List;

/**
 * 负责人类
 * 
 * 负责管理备忘录对象
 */
public class CareTaker {

	private List<Memento> mementoList = new ArrayList<Memento>();

	public void add(Memento state) {
		mementoList.add(state);
	}

	public Memento get(int index) {
		return mementoList.get(index);
	}

}