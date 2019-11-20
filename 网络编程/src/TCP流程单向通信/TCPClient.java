package TCP流程单向通信;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;

/**
 * 服务器步骤：
 * 
 * 1. 建立连接：创建Scoket对象：指定要连接的服务器的IP和端口;
 * 
 * 2. 操作 - 输入输出流 ;
 * 
 * 3. 释放资源;
 */

public class TCPClient {

	public static void main(String[] args) {
		Socket socket = null;
		BufferedReader br = null;
		try {
			// 1.创建Scoket对象：指定要连接的服务器的IP和端口(自己机器的发送端口是随机的)。
			socket = new Socket("localhost", 8888);

			// 2. 操作 - (获取scoket的输入流，并使用缓冲流进行包装，读取服务器端返回的消息)
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			System.out.println(br.readLine()); // 接收服务器端发送的信息

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 3. 释放资源;
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
