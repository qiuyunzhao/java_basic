package UDP双方通信;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * UDP发送端
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
			// 1、使用DatagramSocket 创建数据报套接字 (指定发送信息的端口)
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
				// 2、准备数据，转成字节数组
				data = bRead.readLine();
				byte[] datas = data.getBytes();
				// 3、 封装成DatagramPacket 包裹 (指定发到哪台计算机的哪个端口，发送的数据以及数据的长度)
				DatagramPacket packet = new DatagramPacket(datas, 0, datas.length,new InetSocketAddress(targetIP, targetPort));
				// 4、发送数据包裹
				client.send(packet);
				if (data.equals("bye")) {
					break;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		// 5、释放资源
		client.close();
	}

}
