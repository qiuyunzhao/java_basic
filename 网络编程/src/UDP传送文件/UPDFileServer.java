package UDP传送文件;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Date;

import org.apache.commons.io.FileUtils;


/**
 * 接收端(自定义对象) -- 基本流程
 * 
 * 1、使用DatagramSocket 创建数据报套接字 (指定接收信息的端口)
 * 
 * 2、准备接收容器,封装成DatagramPacket 包裹(指定要接收的数据的缓存位置和长度)(有大小限制)
 * 
 * 3、阻塞式接收包裹
 * 
 * 4、获取数据、分析数据(字节数组还原为对应类型)
 * 
 * 5、释放资源
 *
 * 如果报错：Address already in use: Cannot bind 表示同一个协议下端口不允许冲突
 */
public class UPDFileServer {

	public static void main(String[] args) throws IOException {
		System.out.println("接收端接收......");

		// 1、使用DatagramSocket 创建数据报套接字 (指定接收信息的端口)
		DatagramSocket server = new DatagramSocket(6666);

		// 2、准备接收容器,封装成DatagramPacket 包裹(指定要接收的数据的缓存位置和长度)
		byte[] container = new byte[1024 * 60];
		DatagramPacket packet = new DatagramPacket(container, 0, container.length);

		// 3、阻塞式接收包裹
		server.receive(packet);

		// 4、获取数据、分析数据(字节数组还原为对应类型)
		byte[] datas = packet.getData();
		
		FileUtils.writeByteArrayToFile(new File("文件资源/logo_copy.png"),datas,true);

		// 5、释放资源
		server.close();
	}

}
