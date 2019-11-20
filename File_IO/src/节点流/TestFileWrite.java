package 节点流;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * 字符流：
 * 不可以操作图片和视频等
 * 中文可能不会出现乱码
 * 操作步骤： 1 创建源 --> 2 选择流 --> 3 操作 --> 4 释放资源
 */
public class TestFileWrite {

	public static void main(String[] args) {
		// 1 创建源
		File file = new File("D:/eclipse-workspace/File_IO/IO流资源/IO_output.txt");
		// 2 选择流
		Writer writer = null;
		try {
			writer = new FileWriter(file, true); // 追加的方式
			// 3 操作
			// //********************写法1********************
			// String message = "写法1：BBC News with Marian Marshall\n";
			// char[] datas = message.toCharArray(); // 字符串->字符数组
			// writer.write(datas, 0, datas.length);
			
			// //********************写法2********************
			// String message = "写法2：BBC News with Marian Marshall\n";
			// writer.write(message);
			
			// ********************写法3********************
			String message = "写法3：BBC News with Marian Marshall";
			writer.append(message).append("\t append方法\n");
			
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 4 释放资源
			try {
				if (writer != null) {
					writer.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
