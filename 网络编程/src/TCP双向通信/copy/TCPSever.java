package TCP双向通信.copy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务器步骤：
 * 
 * 1. 使用SeverSocket创建服务器，指定监听的端口;
 * 
 * 2. 阻塞式等待连接 - accept()方法;
 * 
 * 3. 操作 - 获取socket的输入输出流接收和发送信息;
 * 
 * 4. 释放资源;
 */

public class TCPSever {

	public static void main(String[] args) {

		System.out.println("--------服务器端--------");

		Socket socket = null;
		BufferedReader socketIn = null;
		BufferedWriter socketOut = null;
		BufferedReader console = null;

		try {

			// 1. 使用SeverSocket创建服务器，指定监听的端口;
			ServerSocket server = new ServerSocket(8888);

			// 2. 阻塞式等待连接 - accept()方法;
			socket = server.accept();

			// 3. 操作 - 获取socket的输入输出流接收和发送信息;
			socketIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			socketOut = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			console = new BufferedReader(new InputStreamReader(System.in));
			while (true) {
				String str = socketIn.readLine(); // 接收客户端的信息
				System.out.println("客户端说：" + str);
				if (str.equals("end")) { // 如果客户端发送的是“end”则终止连接
					break;
				}
				String str2 = "";
				str2 = console.readLine(); // 读取控制台输入
				socketOut.write(str2 + "\n"); //向客户端发送
				socketOut.flush();
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 4. 释放资源;
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
