package UDP�����Զ������;

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
 * ���ն�(�Զ������) -- ��������
 * 
 * 1��ʹ��DatagramSocket �������ݱ��׽��� (ָ��������Ϣ�Ķ˿�)
 * 
 * 2��׼����������,��װ��DatagramPacket ����(ָ��Ҫ���յ����ݵĻ���λ�úͳ���)(�д�С����)
 * 
 * 3������ʽ���հ���
 * 
 * 4����ȡ���ݡ���������(�ֽ����黹ԭΪ��Ӧ����)
 * 
 * 5���ͷ���Դ
 *
 * �������Address already in use: Cannot bind ��ʾͬһ��Э���¶˿ڲ������ͻ
 */
public class UPDObjectServer {

	public static void main(String[] args) throws IOException {
		System.out.println("���ն˽���......");

		// 1��ʹ��DatagramSocket �������ݱ��׽��� (ָ��������Ϣ�Ķ˿�)
		DatagramSocket server = new DatagramSocket(6666);

		// 2��׼����������,��װ��DatagramPacket ����(ָ��Ҫ���յ����ݵĻ���λ�úͳ���)
		byte[] container = new byte[1024 * 60];
		DatagramPacket packet = new DatagramPacket(container, 0, container.length);

		// 3������ʽ���հ���
		server.receive(packet);

		// 4����ȡ���ݡ���������(�ֽ����黹ԭΪ��Ӧ����)
		byte[] datas = packet.getData();

		ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new ByteArrayInputStream(datas)));
		System.out.println("char: " + ois.readChar());
		System.out.println("int: " + ois.readInt());
		System.out.println("double: " + ois.readDouble());
		System.out.println("boolean: " + ois.readBoolean());
		System.out.println("String: " + ois.readUTF());
		// ǿת��ԭ����
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

		// 5���ͷ���Դ
		server.close();
	}

}
