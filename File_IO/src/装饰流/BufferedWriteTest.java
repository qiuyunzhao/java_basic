package 装饰流;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 缓冲字符流：修饰FileWriter
 * 不可以操作图片和视频等 中文不会出现乱码 
 * 操作步骤： 1 创建源 --> 2 选择流 --> 3 操作 --> 4 释放资源
 */
public class BufferedWriteTest {

	public static void main(String[] args) {
		// 1 创建源
		File file = new File("D:/eclipse-workspace/File_IO/IO流资源/IO_output.txt");
		// 2 选择流
		BufferedWriter bufferedWriter = null; // BufferedWriter新增许多有用的方法不能用多态
		try {
			bufferedWriter = new BufferedWriter(new FileWriter(file, true));
			String message = "BufferedWriter：BBC News with Marian Marshall";
			bufferedWriter.append(message);
			bufferedWriter.newLine();
			bufferedWriter.append("BufferedWriter：newLine()方法");
			bufferedWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 4 释放资源
			try {
				if (bufferedWriter != null) {
					bufferedWriter.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
