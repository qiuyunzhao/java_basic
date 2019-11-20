package �ڵ���;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * �ֽ�����
 * ���Բ���ͼƬ����Ƶ��
 * ���Ŀ��ܻ�������루��ȡ�ֽ���������
 * �������裺 1 ����Դ --> 2 ѡ���� --> 3 ���� --> 4 �ͷ���Դ
 */
public class TestFileInputStream {

	public static void main(String[] args) {
		// 1 ����Դ
		File file = new File("D:/eclipse-workspace/File_IO/IO����Դ/IO_input.txt");
		// 2 ѡ����
		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(file);
			// 3 ����
			// ÿ�ζ�ȡһ�������ֽ�
			byte[] flush = new byte[1024 * 1]; // ��������
			int length = -1; // ���ճ���
			while ((length = inputStream.read(flush)) != -1) {
				String content = new String(flush, 0, length); // �ַ�����->�ַ���(����)
				System.out.println(content);
				System.out.println("************************************");
			}
			// ÿ�ζ�ȡһ���ֽ�
			// int temp;
			// while ((temp = inputStream.read()) != -1) {
			// System.out.println((char)temp);
			// }
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 4 �ͷ���Դ
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
