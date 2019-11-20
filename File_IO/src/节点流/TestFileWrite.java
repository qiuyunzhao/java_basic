package �ڵ���;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * �ַ�����
 * �����Բ���ͼƬ����Ƶ��
 * ���Ŀ��ܲ����������
 * �������裺 1 ����Դ --> 2 ѡ���� --> 3 ���� --> 4 �ͷ���Դ
 */
public class TestFileWrite {

	public static void main(String[] args) {
		// 1 ����Դ
		File file = new File("D:/eclipse-workspace/File_IO/IO����Դ/IO_output.txt");
		// 2 ѡ����
		Writer writer = null;
		try {
			writer = new FileWriter(file, true); // ׷�ӵķ�ʽ
			// 3 ����
			// //********************д��1********************
			// String message = "д��1��BBC News with Marian Marshall\n";
			// char[] datas = message.toCharArray(); // �ַ���->�ַ�����
			// writer.write(datas, 0, datas.length);
			
			// //********************д��2********************
			// String message = "д��2��BBC News with Marian Marshall\n";
			// writer.write(message);
			
			// ********************д��3********************
			String message = "д��3��BBC News with Marian Marshall";
			writer.append(message).append("\t append����\n");
			
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 4 �ͷ���Դ
			try {
				if (writer != null) {
					writer.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
