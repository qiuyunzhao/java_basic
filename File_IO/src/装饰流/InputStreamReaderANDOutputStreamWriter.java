package 装饰流;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;

/**
 * 转换流：修饰字节流
 *  1. 义字符流的形式操作字节流 （底层传输）字节流<-->字符流（程序操作） 
 *  2. 指定字符集
 */
public class InputStreamReaderANDOutputStreamWriter {

	public static void main(String[] args) {

		// try-catch-with方式捕获异常，虚拟机会自己关闭流
		// 创建字符输入和输出流:使用转换流将字节流转换成字符流
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new URL("http://www.baidu.com").openStream(), "UTF-8")); // 字符缓冲流(转换流(字节流))
			 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("IO流资源/baidu.html"), "UTF-8"));) { // 字符缓冲流(转换流(字节流))

			String str = "";
			while((str = br.readLine()) != null){
				bw.write(str);
				bw.newLine();
			}
			bw.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
