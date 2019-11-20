package UDP˫��ͨ��;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * UDP���ն�
 */
public class UDPReceive implements Runnable {


	private DatagramSocket server;
	
	public UDPReceive(int selfPort) {
		try {
			// 1��ʹ��DatagramSocket �������ݱ��׽��� (ָ��������Ϣ�Ķ˿�)
			server = new DatagramSocket(selfPort);
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while (true) {
			// 2��׼����������,��װ��DatagramPacket ����(ָ��Ҫ���յ����ݵĻ���λ�úͳ���)
			byte[] container = new byte[1024 * 60];
			DatagramPacket packet = new DatagramPacket(container, 0, container.length);
			// 3������ʽ���հ���
			try {
				server.receive(packet);
			} catch (IOException e) {
				e.printStackTrace();
			}
			// 4����ȡ���ݡ���������
			byte[] datas = packet.getData();
			int len = packet.getLength();
			String data = new String(datas, 0, len);
			System.out.println(data);
			if (data.equals("bye")) {
				break;
			}
		}
		// 5���ͷ���Դ
		server.close();
	}

}
