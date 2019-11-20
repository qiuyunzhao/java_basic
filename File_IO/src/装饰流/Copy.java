package װ����;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Copy {

	public static void main(String[] args) {
		// ʹ�û����ֽ���ʵ�ָ���,Ч�ʸ�
		long time1 = System.currentTimeMillis();
		byteCopyFileByBuffer("D:/eclipse-workspace/File_IO/IO����Դ/��ƪ.mp4", "IO����Դ/��ƪcopy.mp4");
		long time2 = System.currentTimeMillis();
		System.out.println("�����ֽ������ѵ�ʱ��Ϊ��" + (time2 - time1));

		// ʹ����ͨ�ֽ���ʵ�ָ���
		long time3 = System.currentTimeMillis();
		byteCopyFile("D:/eclipse-workspace/File_IO/IO����Դ/��ƪ.mp4", "IO����Դ/��ƪcopy2.mp4");
		long time4 = System.currentTimeMillis();
		System.out.println("��ͨ�ֽ������ѵ�ʱ��Ϊ��" + (time4 - time3));

		// ʹ�û����ַ���ʵ�ָ���,Ч�ʸ�
		charCopyFileByBuffer("D:/eclipse-workspace/File_IO/IO����Դ/IO_input.txt", "IO����Դ/IO_input_copy.txt");
	}

	/** �����ֽ���ʵ�ֵ��ļ����Ƶķ��� */
	static void byteCopyFileByBuffer(String src, String dec) {
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		try {
			// 1 ����Դ
			fis = new FileInputStream(src);
			fos = new FileOutputStream(dec);
			// 2 ѡ����
			// ʹ�û����ֽ�����װ�ļ��ֽ��������ӻ��幦�ܣ����Ч�ʡ��������Ĵ�С����������ĳ��ȣ�Ĭ����8192��Ҳ�����Լ�ָ����С
			bis = new BufferedInputStream(fis); // ���׼�����û�õ�
			bos = new BufferedOutputStream(fos);
			// 3 ����
			// ÿ�ζ�ȡһ�������ֽ�
			byte[] flush = new byte[1024 * 1]; // �������� ����Խ���ٶȿ죨�����ޣ�
			int length = -1; // ���ճ���
			while ((length = bis.read(flush)) != -1) {
				bos.write(length);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 4 �ͷ���Դ
			// ע�⣺���Ӵ�������ע�����Ĺر�˳�򣡡��󿪵��ȹرգ���
			try {
				if (bos != null) {
					bos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if (bis != null) {
					bis.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/** ��ͨ�ڵ���ʵ�ֵ��ļ����Ƶķ��� */
	static void byteCopyFile(String src, String dec) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			// 1 ����Դ 2 ѡ����
			fis = new FileInputStream(src);
			fos = new FileOutputStream(dec);
			// 3 ����
			// ÿ�ζ�ȡһ�������ֽ�
			byte[] flush = new byte[1024 * 1]; // ��������
			int length = -1; // ���ճ���
			while ((length = fis.read(flush)) != -1) {
				fos.write(length);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 4 �ͷ���Դ
			try {
				if (fos != null) {
					fos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if (fis != null) {
					fis.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * ע�������ڴ����ı��ļ�ʱ��ʵ�ʿ����п���������д�����򵥸�Ч����
	 */
	private static void charCopyFileByBuffer(String src, String dec) {
		FileReader fr = null;
		FileWriter fw = null;
		BufferedReader br = null;
		BufferedWriter bw = null;
		try {
			fr = new FileReader(src);
			fw = new FileWriter(dec);
			// ʹ�û����ַ������а�װ
			br = new BufferedReader(fr);
			bw = new BufferedWriter(fw);
			// BufferedReader�ṩ�˸������readLine()������ֱ�Ӱ��ж�ȡ�ı�,br.readLine()�����ķ���ֵ��һ���ַ������󣬼��ı��е�һ������
			String tempString = "";
			while ((tempString = br.readLine()) != null) {
				bw.write(tempString); // ����ȡ��һ���ַ���д���ļ���
				bw.newLine(); // �´�д��֮ǰ�Ȼ��У����������һ�к�߼���׷�ӣ�����������һ��
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bw != null) {
					bw.close();
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			try {
				if (br != null) {
					br.close();
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

}
