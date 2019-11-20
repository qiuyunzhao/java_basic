package UDP传送字节数组_本质;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * 接收端 -- 基本流程
 * 
 * 1、使用DatagramSocket 创建数据报套接字 (指定接收信息的端口)
 * 
 * 2、准备接收容器,封装成DatagramPacket 包裹(指定要接收的数据的缓存位置和长度)(有大小限制)
 * 
 * 3、阻塞式接收包裹
 * 
 * 4、获取数据、分析数据(字节数组)
 * 
 * 5、释放资源
 *
 * 如果报错：Address already in use: Cannot bind 表示同一个协议下端口不允许冲突
 */
public class UPDServer {

	public static void main(String[] args) throws IOException {
		System.out.println("接收端接收......");
		// 1、使用DatagramSocket 创建数据报套接字 (指定接收信息的端口)
		DatagramSocket server = new DatagramSocket(6666);
		// 2、准备接收容器,封装成DatagramPacket 包裹(指定要接收的数据的缓存位置和长度)
		byte[] container = new byte[1024 * 60];
		DatagramPacket packet = new DatagramPacket(container, 0, container.length);
		// 3、阻塞式接收包裹
		server.receive(packet);
		// 4、获取数据、分析数据
		byte[] datas = packet.getData();
		int len = packet.getLength();
		System.out.println(new String(datas, 0, len));
//		5、释放资源
		server.close();
	}

}
