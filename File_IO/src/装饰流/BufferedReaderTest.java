package װ����;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * �����ַ���������FileReader
 * �����Բ���ͼƬ����Ƶ��
 * ���Ŀɲ����������
 * �������裺 1 ����Դ --> 2 ѡ���� --> 3 ���� --> 4 �ͷ���Դ
 */
public class BufferedReaderTest {

	public static void main(String[] args) {
		// 1 ����Դ
		File file = new File("D:/eclipse-workspace/File_IO/IO����Դ/IO_input.txt");
		// 2 ѡ����
		BufferedReader bufferedReader = null;	//BufferedReader����������õķ��������ö�̬
		try {
			bufferedReader = new BufferedReader(new FileReader(file));
			// 3 ����
			// ÿ�ζ�ȡһ�������ֽ�
			String line = null;
			while ((line = bufferedReader.readLine()) != null) {
				System.out.println(line);
				System.out.println("************************************");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 4 �ͷ���Դ
			try {
				if (bufferedReader != null) {
					bufferedReader.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
