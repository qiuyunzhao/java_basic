package �ڵ���;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * �ַ�����
 * �����Բ���ͼƬ����Ƶ��
 * ���Ŀ��ܲ����������
 * �������裺 1 ����Դ --> 2 ѡ���� --> 3 ���� --> 4 �ͷ���Դ
 */
public class TestFileReader {

	public static void main(String[] args) {
		// 1 ����Դ
		File file = new File("D:/eclipse-workspace/File_IO/IO����Դ/IO_input.txt");
		// 2 ѡ����
		Reader reader = null;
		try {
			reader = new FileReader(file);
			// 3 ����
			// ÿ�ζ�ȡһ�������ֽ�
			char[] flush = new char[1024 * 1]; // ��������
			int length = -1; // ���ճ���
			while ((length = reader.read(flush)) != -1) {
				String content = new String(flush, 0, length); // �ַ�����->�ַ���
				System.out.println(content);
				System.out.println("************************************");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 4 �ͷ���Դ
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
