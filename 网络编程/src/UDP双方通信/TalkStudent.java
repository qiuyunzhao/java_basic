package UDP双方通信;

public class TalkStudent {

	public static void main(String[] args) {

		System.out.println("---------------学生---------------");
		new Thread(new UDPSend(7777,"127.0.0.1",9999)).start();//7777端口发送
		new Thread(new UDPReceive(8888)).start();	//8888端口接收

	}

}
