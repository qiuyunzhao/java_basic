package UDP˫��ͨ��;

public class Talkteacher {

	public static void main(String[] args) {

		System.out.println("---------------��ʦ---------------");
		new Thread(new UDPReceive(9999)).start();	//9999�˿ڽ���
		new Thread(new UDPSend(6666,"127.0.0.1",8888)).start();;	//6666�˿ڷ���

	}

}
