package 节点流;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * 字符流：
 * 不可以操作图片和视频等
 * 中文可能不会出现乱码
 * 操作步骤： 1 创建源 --> 2 选择流 --> 3 操作 --> 4 释放资源
 */
public class TestFileReader {

	public static void main(String[] args) {
		// 1 创建源
		File file = new File("D:/eclipse-workspace/File_IO/IO流资源/IO_input.txt");
		// 2 选择流
		Reader reader = null;
		try {
			reader = new FileReader(file);
			// 3 操作
			// 每次读取一定长度字节
			char[] flush = new char[1024 * 1]; // 缓冲容器
			int length = -1; // 接收长度
			while ((length = reader.read(flush)) != -1) {
				String content = new String(flush, 0, length); // 字符数组->字符串
				System.out.println(content);
				System.out.println("************************************");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 4 释放资源
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
