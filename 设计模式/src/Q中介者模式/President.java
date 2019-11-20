package Q中介者模式;

import java.util.HashMap;
import java.util.Map;

public class President implements Mediator {

	private Map<String, Department> map = new HashMap<String, Department>();

	//部门间的交互，主要在该方法体内完成
	@Override
	public void command(String dname) {
		System.out.println("经理---->财务");
		map.get(dname).selfAction();
	}

	@Override
	public void register(String dname, Department d) {
		map.put(dname, d);
	}
	
}
