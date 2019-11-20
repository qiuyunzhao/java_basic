package TCP流程单向通信;

import java.io.BufferedWriter;
import java.io.IOException;
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
 * 3. 操作 - 输入输出流 ;
 * 
 * 4. 释放资源;
 */

public class TCPSever {

	public static void main(String[] args) {
		Socket socket = null;
		BufferedWriter bw = null;

		try {
			// 1. 使用SeverSocket创建服务器，指定监听的接口;
			ServerSocket serverSocket = new ServerSocket(8888);
			System.out.println("服务端建立监听");

			// 2. 阻塞式等待连接 - accept()方法;
			socket = serverSocket.accept();
			System.out.println("有一个客户端已经建立连接");

			// 3. 操作 - 获取socket的输出流,并使用缓冲流进行包装,向客户端反馈消息 ;
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			bw.write("你好已经与您完成连接！"); // 向客户端发送反馈信息

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 4. 释放资源;
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
