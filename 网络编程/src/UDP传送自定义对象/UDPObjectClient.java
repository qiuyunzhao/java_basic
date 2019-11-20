package UDP传送自定义对象;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.util.Date;

/**
 * 发送端(自定义对象)---基本流程: 
 * 
 * 1、使用DatagramSocket 创建数据报套接字 (指定发送信息的端口)
 * 
 * 2、准备数据，将基本类型转成字节数组
 * 
 * 3、 封装成DatagramPacket 包裹 (指定发到哪台计算机的哪个端口，发送的数据以及数据的长度)
 * 
 * 4、发送数据包裹
 * 
 * 5、释放资源
 */
public class UDPObjectClient {

	public static void main(String[] args) throws IOException {
		System.out.println("发送端发送......");
		// 1、使用DatagramSocket 创建数据报套接字 (指定发送信息的端口)
		DatagramSocket client = new DatagramSocket(8888);
		
		// 2、准备数据，将基本类型转成字节数组
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(baos));
		// 写基本数据类型
		oos.writeChar('a');
		oos.writeInt(10);
		oos.writeDouble(Math.random());
		oos.writeBoolean(true);
		oos.writeUTF("北京尚学堂"); // 写字符串
		// 写对象
		oos.writeObject("好好学习，天天向上");
		oos.writeObject(new Date());
		Person person = new Person(18, true, "高淇");
		oos.writeObject(person);
		oos.flush();// 手动刷新缓冲区：将流中数据写入到文件中
		
		byte[] datas = baos.toByteArray();
		
		// 3、 封装成DatagramPacket 包裹 (指定发到哪台计算机的哪个端口，发送的数据以及数据的长度)
		DatagramPacket packet = new DatagramPacket(datas, 0, datas.length, new InetSocketAddress("127.0.0.1", 6666));
		
		// 4、发送数据包裹
		client.send(packet);
		
		// 5、释放资源
		client.close();
	}

}
