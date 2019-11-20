package UDP双方通信;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * UDP接收端
 */
public class UDPReceive implements Runnable {


	private DatagramSocket server;
	
	public UDPReceive(int selfPort) {
		try {
			// 1、使用DatagramSocket 创建数据报套接字 (指定接收信息的端口)
			server = new DatagramSocket(selfPort);
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while (true) {
			// 2、准备接收容器,封装成DatagramPacket 包裹(指定要接收的数据的缓存位置和长度)
			byte[] container = new byte[1024 * 60];
			DatagramPacket packet = new DatagramPacket(container, 0, container.length);
			// 3、阻塞式接收包裹
			try {
				server.receive(packet);
			} catch (IOException e) {
				e.printStackTrace();
			}
			// 4、获取数据、分析数据
			byte[] datas = packet.getData();
			int len = packet.getLength();
			String data = new String(datas, 0, len);
			System.out.println(data);
			if (data.equals("bye")) {
				break;
			}
		}
		// 5、释放资源
		server.close();
	}

}
