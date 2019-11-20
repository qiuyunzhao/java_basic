package �ڵ���;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * �ֽ�����
 * ���Բ���ͼƬ����Ƶ��
 * ���Ŀ��ܻ�������루��ȡ�ֽ���������
 * �������裺 1 ����Դ --> 2 ѡ���� --> 3 ���� --> 4 �ͷ���Դ
 */
public class TestFileOuputStream {

	public static void main(String[] args) {
		// 1 ����Դ
		File file = new File("D:/eclipse-workspace/File_IO/IO����Դ/IO_output.txt");
		// 2 ѡ����
		OutputStream outputStream = null;
		try {
			// outputStream = new FileOutputStream(file);
			outputStream = new FileOutputStream(file,true); // ׷�ӵķ�ʽ
			// 3 ����
			String message = "BBC News with Marian Marshall\n";
			byte[] datas = message.getBytes(); // �ַ���->�ֽ�����(����)
			outputStream.write(datas, 0, datas.length);
			outputStream.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 4 �ͷ���Դ
			try {
				if (outputStream != null) {
					outputStream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
