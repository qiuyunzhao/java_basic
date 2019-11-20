package TCP双向通信.copy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 服务器步骤：
 * 
 * 1. 建立连接：创建Scoket对象：指定要连接的服务器的IP和端口;
 * 
 * 2. 操作 - 获取scoket的输入输出流接收和发送信息 ;
 * 
 * 3. 释放资源;
 */

public class TCPClient {

	public static void main(String[] args) {

		System.out.println("--------客户端--------");

		Socket socket = null;
		BufferedReader socketIn = null;
		BufferedWriter socketOut = null;
		BufferedReader console = null;
		try {

			// 1. 建立连接：创建Scoket对象：指定要连接的服务器的IP和端口;
			socket = new Socket(InetAddress.getLocalHost(), 8888);

			// 2.获取scoket的输入输出流接收和发送信息
			socketIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			socketOut = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			console = new BufferedReader(new InputStreamReader(System.in));

			while (true) {
				String str = console.readLine(); // 读取控制台输入
				socketOut.write(str + "\n"); // 向服务器发送消息
				socketOut.flush();
				if (str.equals("end")) {// 如果输入的信息为“end”则终止连接
					break;
				}
				System.out.println("服务器端说：" + socketIn.readLine()); // 接收并输出服务器端信息
			}

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 3. 释放资源;
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
