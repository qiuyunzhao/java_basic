package װ����;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * �������������������������ַ������͡���Ϊ����Դ���Ӷ����������������޹صķ�ʽ�ӵײ�����������в���Java���������������ַ������͡�
 * DataInputStream��DataOutputStream�ṩ�˿��Դ�ȡ������޹ص�����Java������������(�磺int��double��String��)�ķ�����
 * �����������Զ������ڵ������������а�װ
 * 
 * 1.��д�����ȡ 2.��ȡ˳�������д��˳��һ��
 */
public class DataInputStreamANDDataOutputStream {

	public static void main(String[] args) {

		DataOutputStream dos = null;
		DataInputStream dis = null;
		try {
			dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("IO����Դ/DataOutputStream.txt")));
			// ����������д�뵽�ļ���
			dos.writeChar('a');
			dos.writeInt(10);
			dos.writeDouble(Math.random());
			dos.writeBoolean(true);
			dos.writeUTF("������ѧ��"); // д�ַ���

			dos.flush();// �ֶ�ˢ�»�����������������д�뵽�ļ���
			
			dis = new DataInputStream(new BufferedInputStream(new FileInputStream("IO����Դ/DataOutputStream.txt"))); //dis ����ʱ "IO����Դ/DataOutputStream.txt"�����Ѿ�����
			// ֱ�Ӷ�ȡ���ݣ���ȡ��˳��Ҫ��д���˳��һ�£���������ȷ��ȡ���ݡ�
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
