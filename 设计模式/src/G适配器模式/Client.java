package G适配器模式;

/**
 * 客户端类 (相当于例子中的笔记本，只有USB口)
 * 
 * @author Administrator
 *
 */
public class Client {

	public static void main(String[] args) {
		Client c = new Client();
		Adapted a = new Adapted();

//		 Target t = new Adapter();
		 Target t = new Adapter2(a);

		 t.handleReq();
	}
	
}