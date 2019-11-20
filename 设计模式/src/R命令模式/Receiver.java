package R命令模式;

/**
 * 真正的命令的执行者
 */
public class Receiver {
	
	public void buy() {
		System.out.println("买货");
	}
	
	public void pay() {
		System.out.println("付钱，取货");
	}
	
}