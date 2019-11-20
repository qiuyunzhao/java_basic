package װ����;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * �����ַ���������FileWriter
 * �����Բ���ͼƬ����Ƶ�� ���Ĳ���������� 
 * �������裺 1 ����Դ --> 2 ѡ���� --> 3 ���� --> 4 �ͷ���Դ
 */
public class BufferedWriteTest {

	public static void main(String[] args) {
		// 1 ����Դ
		File file = new File("D:/eclipse-workspace/File_IO/IO����Դ/IO_output.txt");
		// 2 ѡ����
		BufferedWriter bufferedWriter = null; // BufferedWriter����������õķ��������ö�̬
		try {
			bufferedWriter = new BufferedWriter(new FileWriter(file, true));
			String message = "BufferedWriter��BBC News with Marian Marshall";
			bufferedWriter.append(message);
			bufferedWriter.newLine();
			bufferedWriter.append("BufferedWriter��newLine()����");
			bufferedWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 4 �ͷ���Դ
			try {
				if (bufferedWriter != null) {
					bufferedWriter.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
