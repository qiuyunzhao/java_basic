package 装饰流;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 数据流将“基本数据类型与字符串类型”作为数据源，从而允许程序以与机器无关的方式从底层输入输出流中操作Java基本数据类型与字符串类型。
 * DataInputStream和DataOutputStream提供了可以存取与机器无关的所有Java基础类型数据(如：int、double、String等)的方法。
 * 处理流，可以对其他节点流或处理流进行包装
 * 
 * 1.先写出后读取 2.读取顺序必须与写出顺序一致
 */
public class DataInputStreamANDDataOutputStream {

	public static void main(String[] args) {

		DataOutputStream dos = null;
		DataInputStream dis = null;
		try {
			dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("IO流资源/DataOutputStream.txt")));
			// 将如下数据写入到文件中
			dos.writeChar('a');
			dos.writeInt(10);
			dos.writeDouble(Math.random());
			dos.writeBoolean(true);
			dos.writeUTF("北京尚学堂"); // 写字符串

			dos.flush();// 手动刷新缓冲区：将流中数据写入到文件中
			
			dis = new DataInputStream(new BufferedInputStream(new FileInputStream("IO流资源/DataOutputStream.txt"))); //dis 创建时 "IO流资源/DataOutputStream.txt"必须已经存在
			// 直接读取数据：读取的顺序要与写入的顺序一致，否则不能正确读取数据。
			System.out.println("char: " + dis.readChar());
			System.out.println("int: " + dis.readInt());
			System.out.println("double: " + dis.readDouble());
			System.out.println("boolean: " + dis.readBoolean());
			System.out.println("String: " + dis.readUTF());

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (dos != null) {
				try {
					dos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (dis != null) {
				try {
					dis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
