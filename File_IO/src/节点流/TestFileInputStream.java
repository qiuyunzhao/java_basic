package 节点流;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 字节流：
 * 可以操作图片和视频等
 * 中文可能会出现乱码（截取字节数不够）
 * 操作步骤： 1 创建源 --> 2 选择流 --> 3 操作 --> 4 释放资源
 */
public class TestFileInputStream {

	public static void main(String[] args) {
		// 1 创建源
		File file = new File("D:/eclipse-workspace/File_IO/IO流资源/IO_input.txt");
		// 2 选择流
		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(file);
			// 3 操作
			// 每次读取一定长度字节
			byte[] flush = new byte[1024 * 1]; // 缓冲容器
			int length = -1; // 接收长度
			while ((length = inputStream.read(flush)) != -1) {
				String content = new String(flush, 0, length); // 字符数组->字符串(解码)
				System.out.println(content);
				System.out.println("************************************");
			}
			// 每次读取一个字节
			// int temp;
			// while ((temp = inputStream.read()) != -1) {
			// System.out.println((char)temp);
			// }
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 4 释放资源
			try {
				if (inputStream != null) {
					inputStream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
