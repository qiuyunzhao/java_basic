package װ����;

import java.io.BufferedOutputStream;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * �õĲ���
 *
 */
public class PrintStreamANDPrintWriter {

	public static void main(String[] args) throws FileNotFoundException {
		
		PrintStream ps = System.out;
		
		//����̨��ӡ
		ps.println("����̨��ӡ��");
		ps.println(true);
		//��ӡ���ļ�
		ps = new PrintStream(new BufferedOutputStream(new FileOutputStream("IO����Դ/PrintStream.txt")),true);	//�Զ�ˢ��
		ps.println("�ļ���ӡ��");
		//����ض����ļ�
		System.setOut(ps);	//�Ժ���������ض����λ�ã������ǿ���̨
		System.out.println("����ض����ļ�");
		//�ض���ؿ���̨
		System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream(FileDescriptor.out)),true));
		System.out.println("����ض��ؿ���̨");
		
		ps.close();
		
		PrintWriter pw = new PrintWriter(new BufferedOutputStream(new FileOutputStream("IO����Դ/PrintStream.txt")),true);	//�Զ�ˢ��
		pw.append("PrintWriter��ӡ��");
		pw.close();
	}

}
