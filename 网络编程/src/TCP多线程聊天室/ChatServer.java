package TCP���߳�������;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
 
public class ChatServer {
    public static void main(String[] args) {
    	System.out.println("------��������------");
    	
        ServerSocket server = null;
        Socket socket = null;
        BufferedReader in = null;
        try {
            server = new ServerSocket(8888);
            socket = server.accept();
            //������ͻ��˷�����Ϣ���̣߳�������
            new ServerThread(socket).start();
            // main�̸߳����ȡ�ͻ��˷�������Ϣ
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while (true) {
                String str = in.readLine();
                System.out.println("�ͻ���˵��" + str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
 
/**
 * ר����ͻ��˷�����Ϣ���߳�
 */
class ServerThread extends Thread {
    Socket ss;
    BufferedWriter out;
    BufferedReader br;
 
    public ServerThread(Socket ss) {
        this.ss = ss;
        try {
            out = new BufferedWriter(new OutputStreamWriter(ss.getOutputStream()));
            br = new BufferedReader(new InputStreamReader(System.in));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 
    public void run() {
        try {
            while (true) {
                String str2 = br.readLine();
                out.write(str2 + "\n");
                out.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(out != null){
                out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(br != null){
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}