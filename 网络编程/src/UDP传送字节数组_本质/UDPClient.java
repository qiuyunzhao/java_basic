package UDP�����ֽ�����_����;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * ���Ͷ�---��������: 
 * 
 * 1��ʹ��DatagramSocket �������ݱ��׽��� (ָ��������Ϣ�Ķ˿�)
 * 
 * 2��׼�����ݣ�ת���ֽ�����
 * 
 * 3�� ��װ��DatagramPacket ���� (ָ��������̨��������ĸ��˿ڣ����͵������Լ����ݵĳ���)
 * 
 * 4���������ݰ���
 * 
 * 5���ͷ���Դ
 */
public class UDPClient {

	public static void main(String[] args) throws IOException {
		System.out.println("���Ͷ˷���......");
		// 1��ʹ��DatagramSocket �������ݱ��׽��� (ָ��������Ϣ�Ķ˿�)
		DatagramSocket client = new DatagramSocket(8888);
		// 2��׼�����ݣ�ת���ֽ�����
		String data = "ѧϰJAVA ����һ�����׵���";
		byte[] datas = data.getBytes();
		// 3�� ��װ��DatagramPacket ���� (ָ��������̨��������ĸ��˿ڣ����͵������Լ����ݵĳ���)
		DatagramPacket packet = new DatagramPacket(datas, 0, datas.length, new InetSocketAddress("127.0.0.1", 6666));
		// 4���������ݰ���
		client.send(packet);
		// 5���ͷ���Դ
		client.close();
	}

}
