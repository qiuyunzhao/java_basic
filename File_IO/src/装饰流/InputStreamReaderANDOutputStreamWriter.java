package װ����;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;

/**
 * ת�����������ֽ���
 *  1. ���ַ�������ʽ�����ֽ��� ���ײ㴫�䣩�ֽ���<-->�ַ�������������� 
 *  2. ָ���ַ���
 */
public class InputStreamReaderANDOutputStreamWriter {

	public static void main(String[] args) {

		// try-catch-with��ʽ�����쳣����������Լ��ر���
		// �����ַ�����������:ʹ��ת�������ֽ���ת�����ַ���
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new URL("http://www.baidu.com").openStream(), "UTF-8")); // �ַ�������(ת����(�ֽ���))
			 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("IO����Դ/baidu.html"), "UTF-8"));) { // �ַ�������(ת����(�ֽ���))

			String str = "";
			while((str = br.readLine()) != null){
				bw.write(str);
				bw.newLine();
			}
			bw.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
