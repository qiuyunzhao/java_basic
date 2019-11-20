package UDP˫��ͨ��;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * UDP���Ͷ�
 */
public class UDPSend implements Runnable {

	private DatagramSocket client;
	private BufferedReader bRead;
	private String targetIP;
	private int targetPort;

	public UDPSend(int selfPort,String targetIP,int targetPort) {
		this.targetIP = targetIP;
		this.targetPort = targetPort;
		this.bRead = new BufferedReader(new InputStreamReader(System.in));
		try {
			// 1��ʹ��DatagramSocket �������ݱ��׽��� (ָ��������Ϣ�Ķ˿�)
			this.client = new DatagramSocket(selfPort);
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while (true) {
			String data;
			try {
				// 2��׼�����ݣ�ת���ֽ�����
				data = bRead.readLine();
				byte[] datas = data.getBytes();
				// 3�� ��װ��DatagramPacket ���� (ָ��������̨��������ĸ��˿ڣ����͵������Լ����ݵĳ���)
				DatagramPacket packet = new DatagramPacket(datas, 0, datas.length,new InetSocketAddress(targetIP, targetPort));
				// 4���������ݰ���
				client.send(packet);
				if (data.equals("bye")) {
					break;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		// 5���ͷ���Դ
		client.close();
	}

}
