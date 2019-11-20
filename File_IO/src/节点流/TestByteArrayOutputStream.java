package �ڵ���;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * �ֽ���������
 * ���Բ���ͼƬ����Ƶ��
 * ���Ŀ��ܻ�������루��ȡ�ֽ���������
 * �������裺 1 ����Դ(�ڲ�ά��) --> 2 ѡ���� ��������Դ��--> 3 ���� --> 4 �ͷ���Դ�����Բ����ͷţ�
 */
public class TestByteArrayOutputStream {

	public static void main(String[] args) {
		// 1 ����Դ
		byte[] dest = null;	//���������������
		// 2 ѡ����
		ByteArrayOutputStream byteArrayOutputStream = null;
		try {
			byteArrayOutputStream = new ByteArrayOutputStream(); // ByteArrayOutputStream������������
			// 3 ����
			String message = "BBC News with Marian Marshall";
			byte[] datas = message.getBytes(); // �ַ���->�ֽ�����(����)
			byteArrayOutputStream.write(datas, 0, datas.length);
			byteArrayOutputStream.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 4 �ͷ���Դ�����Բ����ͷţ�
			try {
				if (byteArrayOutputStream != null) {
					byteArrayOutputStream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
 
		dest = byteArrayOutputStream.toByteArray();
		System.out.println(dest.length + "---" + new String(dest,0,byteArrayOutputStream.size()));
		
	}

}
