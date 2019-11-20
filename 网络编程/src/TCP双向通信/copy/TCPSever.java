package TCP˫��ͨ��.copy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
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
 * 3. ���� - ��ȡsocket��������������պͷ�����Ϣ;
 * 
 * 4. �ͷ���Դ;
 */

public class TCPSever {

	public static void main(String[] args) {

		System.out.println("--------��������--------");

		Socket socket = null;
		BufferedReader socketIn = null;
		BufferedWriter socketOut = null;
		BufferedReader console = null;

		try {

			// 1. ʹ��SeverSocket������������ָ�������Ķ˿�;
			ServerSocket server = new ServerSocket(8888);

			// 2. ����ʽ�ȴ����� - accept()����;
			socket = server.accept();

			// 3. ���� - ��ȡsocket��������������պͷ�����Ϣ;
			socketIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			socketOut = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			console = new BufferedReader(new InputStreamReader(System.in));
			while (true) {
				String str = socketIn.readLine(); // ���տͻ��˵���Ϣ
				System.out.println("�ͻ���˵��" + str);
				if (str.equals("end")) { // ����ͻ��˷��͵��ǡ�end������ֹ����
					break;
				}
				String str2 = "";
				str2 = console.readLine(); // ��ȡ����̨����
				socketOut.write(str2 + "\n"); //��ͻ��˷���
				socketOut.flush();
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 4. �ͷ���Դ;
			if (socketIn != null) {
				try {
					socketIn.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (socketOut != null) {
				try {
					socketOut.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (console != null) {
				try {
					console.close();
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
