package Q�н���ģʽ;

import java.util.HashMap;
import java.util.Map;

public class President implements Mediator {

	private Map<String, Department> map = new HashMap<String, Department>();

	//���ż�Ľ�������Ҫ�ڸ÷����������
	@Override
	public void command(String dname) {
		System.out.println("����---->����");
		map.get(dname).selfAction();
	}

	@Override
	public void register(String dname, Department d) {
		map.put(dname, d);
	}
	
}
