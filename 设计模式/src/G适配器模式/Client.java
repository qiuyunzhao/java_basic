package G������ģʽ;

/**
 * �ͻ����� (�൱�������еıʼǱ���ֻ��USB��)
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