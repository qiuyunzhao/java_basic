package UDP传送自定义对象;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Date;


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
public class UPDObjectServer {

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

		ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new ByteArrayInputStream(datas)));
		System.out.println("char: " + ois.readChar());
		System.out.println("int: " + ois.readInt());
		System.out.println("double: " + ois.readDouble());
		System.out.println("boolean: " + ois.readBoolean());
		System.out.println("String: " + ois.readUTF());
		// 强转回原类型
		try {
			Object str = ois.readObject();
			if (str instanceof String) {
				System.out.println("StringObject: " + (String) str);
			}
			Object date = ois.readObject();
			if (date instanceof Date) {
				System.out.println("DateObject: " + (Date) date);
			}
			Object employee = ois.readObject();
			if (employee instanceof Person) {
				System.out.println("PersonObject: " + (Person) employee);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		// 5、释放资源
		server.close();
	}

}
