package TCP���̵���ͨ��;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ���������裺
 * 
 * 1. ʹ��SeverSocket������������ָ�������Ķ˿�;
 * 
 * 2. ����ʽ�ȴ����� - accept()����;
 * 
 * 3. ���� - ��������� ;
 * 
 * 4. �ͷ���Դ;
 */

public class TCPSever {

	public static void main(String[] args) {
		Socket socket = null;
		BufferedWriter bw = null;

		try {
			// 1. ʹ��SeverSocket������������ָ�������Ľӿ�;
			ServerSocket serverSocket = new ServerSocket(8888);
			System.out.println("����˽�������");

			// 2. ����ʽ�ȴ����� - accept()����;
			socket = serverSocket.accept();
			System.out.println("��һ���ͻ����Ѿ���������");

			// 3. ���� - ��ȡsocket�������,��ʹ�û��������а�װ,��ͻ��˷�����Ϣ ;
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			bw.write("����Ѿ�����������ӣ�"); // ��ͻ��˷��ͷ�����Ϣ

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 4. �ͷ���Դ;
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (socket != null) {
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
