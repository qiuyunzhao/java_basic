package UDP�����ֽ�����_����;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * ���ն� -- ��������
 * 
 * 1��ʹ��DatagramSocket �������ݱ��׽��� (ָ��������Ϣ�Ķ˿�)
 * 
 * 2��׼����������,��װ��DatagramPacket ����(ָ��Ҫ���յ����ݵĻ���λ�úͳ���)(�д�С����)
 * 
 * 3������ʽ���հ���
 * 
 * 4����ȡ���ݡ���������(�ֽ�����)
 * 
 * 5���ͷ���Դ
 *
 * �������Address already in use: Cannot bind ��ʾͬһ��Э���¶˿ڲ������ͻ
 */
public class UPDServer {

	public static void main(String[] args) throws IOException {
		System.out.println("���ն˽���......");
		// 1��ʹ��DatagramSocket �������ݱ��׽��� (ָ��������Ϣ�Ķ˿�)
		DatagramSocket server = new DatagramSocket(6666);
		// 2��׼����������,��װ��DatagramPacket ����(ָ��Ҫ���յ����ݵĻ���λ�úͳ���)
		byte[] container = new byte[1024 * 60];
		DatagramPacket packet = new DatagramPacket(container, 0, container.length);
		// 3������ʽ���հ���
		server.receive(packet);
		// 4����ȡ���ݡ���������
		byte[] datas = packet.getData();
		int len = packet.getLength();
		System.out.println(new String(datas, 0, len));
//		5���ͷ���Դ
		server.close();
	}

}
