package UDP双方通信;

public class Talkteacher {

	public static void main(String[] args) {

		System.out.println("---------------老师---------------");
		new Thread(new UDPReceive(9999)).start();	//9999端口接收
		new Thread(new UDPSend(6666,"127.0.0.1",8888)).start();;	//6666端口发送

	}

}
