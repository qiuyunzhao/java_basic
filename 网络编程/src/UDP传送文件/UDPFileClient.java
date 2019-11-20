package UDP�����ļ�;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.util.Date;

import org.apache.commons.io.FileUtils;

/**
 * ���Ͷ�(�Զ������)---��������: 
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
public class UDPFileClient {

	public static void main(String[] args) throws IOException {
		System.out.println("���Ͷ˷���......");
		// 1��ʹ��DatagramSocket �������ݱ��׽��� (ָ��������Ϣ�Ķ˿�)
		DatagramSocket client = new DatagramSocket(8888);
		
		// 2��׼�����ݣ�����������ת���ֽ�����
		byte[] datas = FileUtils.readFileToByteArray(new File("�ļ���Դ/logo.png"));
		System.out.println(datas.length);
		
		// 3�� ��װ��DatagramPacket ���� (ָ��������̨��������ĸ��˿ڣ����͵������Լ����ݵĳ���)
		DatagramPacket packet = new DatagramPacket(datas, 0, datas.length, new InetSocketAddress("127.0.0.1", 6666));
		
		// 4���������ݰ���
		client.send(packet);
		
		// 5���ͷ���Դ
		client.close();
	}

}
