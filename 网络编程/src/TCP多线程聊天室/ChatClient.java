package TCP多线程聊天室;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
 
public class ChatClient {
    public static void main(String[] args) {
    	
    	System.out.println("------客户端------");
        Socket socket = null;
        BufferedReader in = null;
        try {
            socket = new Socket(InetAddress.getByName("127.0.1.1"), 8888);
            // 创建向服务器端发送信息的线程，并启动
            new ClientThread(socket).start();
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            // main线程负责接收服务器发来的信息
            while (true) {
                System.out.println("服务器说：" + in.readLine());
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
 
/**
 * 用于向服务器发送消息
 * 
 * @author Administrator
 *
 */
class ClientThread extends Thread {
    Socket s;
    BufferedWriter out;
    BufferedReader wt;
 
    public ClientThread(Socket s) {
        this.s = s;
        try {
            out = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
            wt = new BufferedReader(new InputStreamReader(System.in));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 
    public void run() {
        try {
            while (true) {
                String str = wt.readLine();
                out.write(str + "\n");
                out.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (wt != null) {
                    wt.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}