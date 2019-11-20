package U状态模式;

/**
 * 房间对象
 * 
 * @author Administrator
 *
 */
public class HomeContext {

	private State state;

	public void setState(State s) {
		System.out.println("修改状态！");
		state = s;
		state.handle(); // 切换状态时调用具体状态类的操作方法
	}

}