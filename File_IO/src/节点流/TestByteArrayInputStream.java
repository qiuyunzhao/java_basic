package �ڵ���;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * �ֽ���������
 * ByteArrayInputStream�ǰ��ڴ��еġ�ĳ���ֽ�������󡱵�������Դ
 * �������裺 1 ����Դ(�����ļ�����) --> 2 ѡ���� --> 3 ���� --> 4 �ͷ���Դ(���Բ����ͷţ��Զ��ͷ�)
 */
public class TestByteArrayInputStream {

	public static void main(String[] args) {
		// 1 ����Դ
		byte[] b = "a b c d e f g".getBytes();
		// 2 ѡ����
		InputStream inputStream = null;
		try {
			inputStream = new ByteArrayInputStream(b);
			// 3 ����
			// ÿ�ζ�ȡһ�������ֽ�
			byte[] flush = new byte[2]; // ��������
			int length = -1; // ���ճ���
			while ((length = inputStream.read(flush)) != -1) {
				String content = new String(flush, 0, length); // �ַ�����->�ַ���(����)
				System.out.println(content);
			}
			// ÿ�ζ�ȡһ���ֽ�
			// int temp;
			// while ((temp = inputStream.read()) != -1) {
			// System.out.println((char)temp);
			// }
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 4 �ͷ���Դ�����Բ���д�����ͷţ����Զ��ͷţ�����ֻ��Ϊ�˷��ͳһ��
			try {
				if (inputStream != null) {
					inputStream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
