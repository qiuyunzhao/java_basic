package TCP˫��ͨ��.copy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * ���������裺
 * 
 * 1. �������ӣ�����Scoket����ָ��Ҫ���ӵķ�������IP�Ͷ˿�;
 * 
 * 2. ���� - ��ȡscoket��������������պͷ�����Ϣ ;
 * 
 * 3. �ͷ���Դ;
 */

public class TCPClient {

	public static void main(String[] args) {

		System.out.println("--------�ͻ���--------");

		Socket socket = null;
		BufferedReader socketIn = null;
		BufferedWriter socketOut = null;
		BufferedReader console = null;
		try {

			// 1. �������ӣ�����Scoket����ָ��Ҫ���ӵķ�������IP�Ͷ˿�;
			socket = new Socket(InetAddress.getLocalHost(), 8888);

			// 2.��ȡscoket��������������պͷ�����Ϣ
			socketIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			socketOut = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			console = new BufferedReader(new InputStreamReader(System.in));

			while (true) {
				String str = console.readLine(); // ��ȡ����̨����
				socketOut.write(str + "\n"); // �������������Ϣ
				socketOut.flush();
				if (str.equals("end")) {// ����������ϢΪ��end������ֹ����
					break;
				}
				System.out.println("��������˵��" + socketIn.readLine()); // ���ղ��������������Ϣ
			}

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 3. �ͷ���Դ;
			if (socketOut != null) {
				try {
					socketOut.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (socketIn != null) {
				try {
					socketIn.close();
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
