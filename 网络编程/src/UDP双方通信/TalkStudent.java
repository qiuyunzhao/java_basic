package UDP˫��ͨ��;

public class TalkStudent {

	public static void main(String[] args) {

		System.out.println("---------------ѧ��---------------");
		new Thread(new UDPSend(7777,"127.0.0.1",9999)).start();//7777�˿ڷ���
		new Thread(new UDPReceive(8888)).start();	//8888�˿ڽ���

	}

}
