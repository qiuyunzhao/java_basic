package UDP�����Զ������;

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
public class UDPObjectClient {

	public static void main(String[] args) throws IOException {
		System.out.println("���Ͷ˷���......");
		// 1��ʹ��DatagramSocket �������ݱ��׽��� (ָ��������Ϣ�Ķ˿�)
		DatagramSocket client = new DatagramSocket(8888);
		
		// 2��׼�����ݣ�����������ת���ֽ�����
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(baos));
		// д������������
		oos.writeChar('a');
		oos.writeInt(10);
		oos.writeDouble(Math.random());
		oos.writeBoolean(true);
		oos.writeUTF("������ѧ��"); // д�ַ���
		// д����
		oos.writeObject("�ú�ѧϰ����������");
		oos.writeObject(new Date());
		Person person = new Person(18, true, "���");
		oos.writeObject(person);
		oos.flush();// �ֶ�ˢ�»�����������������д�뵽�ļ���
		
		byte[] datas = baos.toByteArray();
		
		// 3�� ��װ��DatagramPacket ���� (ָ��������̨��������ĸ��˿ڣ����͵������Լ����ݵĳ���)
		DatagramPacket packet = new DatagramPacket(datas, 0, datas.length, new InetSocketAddress("127.0.0.1", 6666));
		
		// 4���������ݰ���
		client.send(packet);
		
		// 5���ͷ���Դ
		client.close();
	}

}
