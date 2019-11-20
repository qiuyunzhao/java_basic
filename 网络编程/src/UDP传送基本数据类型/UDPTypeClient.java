package UDP���ͻ�����������;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * ���Ͷ�(��������)---��������: 
 * 
 * 1��ʹ��DatagramSocket �������ݱ��׽��� (ָ��������Ϣ�Ķ˿�)
 * 
 * 2��׼�����ݣ�����������ת���ֽ�����
 * 
 * 3�� ��װ��DatagramPacket ���� (ָ��������̨��������ĸ��˿ڣ����͵������Լ����ݵĳ���)
 * 
 * 4���������ݰ���
 * 
 * 5���ͷ���Դ
 */
public class UDPTypeClient {

	public static void main(String[] args) throws IOException {
		System.out.println("���Ͷ˷���......");
		// 1��ʹ��DatagramSocket �������ݱ��׽��� (ָ��������Ϣ�Ķ˿�)
		DatagramSocket client = new DatagramSocket(8888);
		
		// 2��׼�����ݣ�����������ת���ֽ�����
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(baos));
		dos.writeChar('a');
		dos.writeInt(10);
		dos.writeDouble(Math.random());
		dos.writeBoolean(true);
		dos.writeUTF("������ѧ��"); // д�ַ���
		dos.flush();
		
		byte[] datas = baos.toByteArray();
		
		// 3�� ��װ��DatagramPacket ���� (ָ��������̨��������ĸ��˿ڣ����͵������Լ����ݵĳ���)
		DatagramPacket packet = new DatagramPacket(datas, 0, datas.length, new InetSocketAddress("127.0.0.1", 6666));
		
		// 4���������ݰ���
		client.send(packet);
		
		// 5���ͷ���Դ
		client.close();
	}

}
