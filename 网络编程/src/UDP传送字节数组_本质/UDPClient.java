package UDP传送字节数组_本质;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * 发送端---基本流程: 
 * 
 * 1、使用DatagramSocket 创建数据报套接字 (指定发送信息的端口)
 * 
 * 2、准备数据，转成字节数组
 * 
 * 3、 封装成DatagramPacket 包裹 (指定发到哪台计算机的哪个端口，发送的数据以及数据的长度)
 * 
 * 4、发送数据包裹
 * 
 * 5、释放资源
 */
public class UDPClient {

	public static void main(String[] args) throws IOException {
		System.out.println("发送端发送......");
		// 1、使用DatagramSocket 创建数据报套接字 (指定发送信息的端口)
		DatagramSocket client = new DatagramSocket(8888);
		// 2、准备数据，转成字节数组
		String data = "学习JAVA 不是一件容易的事";
		byte[] datas = data.getBytes();
		// 3、 封装成DatagramPacket 包裹 (指定发到哪台计算机的哪个端口，发送的数据以及数据的长度)
		DatagramPacket packet = new DatagramPacket(datas, 0, datas.length, new InetSocketAddress("127.0.0.1", 6666));
		// 4、发送数据包裹
		client.send(packet);
		// 5、释放资源
		client.close();
	}

}
