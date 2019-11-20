package TCP���̵���ͨ��;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;

/**
 * ���������裺
 * 
 * 1. �������ӣ�����Scoket����ָ��Ҫ���ӵķ�������IP�Ͷ˿�;
 * 
 * 2. ���� - ��������� ;
 * 
 * 3. �ͷ���Դ;
 */

public class TCPClient {

	public static void main(String[] args) {
		Socket socket = null;
		BufferedReader br = null;
		try {
			// 1.����Scoket����ָ��Ҫ���ӵķ�������IP�Ͷ˿�(�Լ������ķ��Ͷ˿��������)��
			socket = new Socket("localhost", 8888);

			// 2. ���� - (��ȡscoket������������ʹ�û��������а�װ����ȡ�������˷��ص���Ϣ)
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			System.out.println(br.readLine()); // ���շ������˷��͵���Ϣ

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 3. �ͷ���Դ;
			if (br != null) {
				try {
					br.close();
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
