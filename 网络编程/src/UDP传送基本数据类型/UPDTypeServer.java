package UDP���ͻ�����������;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * ���ն�(��������) -- ��������
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
public class UPDTypeServer {

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
		
		DataInputStream dis = new DataInputStream(new BufferedInputStream(new ByteArrayInputStream(datas))); 
		// ֱ�Ӷ�ȡ���ݣ���ȡ��˳��Ҫ��д���˳��һ�£���������ȷ��ȡ���ݡ�
		System.out.println("char: " + dis.readChar());
		System.out.println("int: " + dis.readInt());
		System.out.println("double: " + dis.readDouble());
		System.out.println("boolean: " + dis.readBoolean());
		System.out.println("String: " + dis.readUTF());
		
		// 5���ͷ���Դ
		server.close();
	}

}
