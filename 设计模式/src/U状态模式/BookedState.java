package U状态模式;

/**
 * 已预订状态
 */
public class BookedState implements State {

	@Override
	public void handle() {
		System.out.println("---房间已被预订！");
	}

}