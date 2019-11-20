package UDP�����ļ�;

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
public class UPDFileServer {

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
		
		FileUtils.writeByteArrayToFile(new File("�ļ���Դ/logo_copy.png"),datas,true);

		// 5���ͷ���Դ
		server.close();
	}

}
