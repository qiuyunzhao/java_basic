package 装饰流;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * 缓冲字符流：修饰FileReader
 * 不可以操作图片和视频等
 * 中文可不会出现乱码
 * 操作步骤： 1 创建源 --> 2 选择流 --> 3 操作 --> 4 释放资源
 */
public class BufferedReaderTest {

	public static void main(String[] args) {
		// 1 创建源
		File file = new File("D:/eclipse-workspace/File_IO/IO流资源/IO_input.txt");
		// 2 选择流
		BufferedReader bufferedReader = null;	//BufferedReader新增许多有用的方法不能用多态
		try {
			bufferedReader = new BufferedReader(new FileReader(file));
			// 3 操作
			// 每次读取一定长度字节
			String line = null;
			while ((line = bufferedReader.readLine()) != null) {
				System.out.println(line);
				System.out.println("************************************");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 4 释放资源
			try {
				if (bufferedReader != null) {
					bufferedReader.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
