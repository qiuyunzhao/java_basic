package 节点流;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 字节流：
 * 可以操作图片和视频等
 * 中文可能会出现乱码（截取字节数不够）
 * 操作步骤： 1 创建源 --> 2 选择流 --> 3 操作 --> 4 释放资源
 */
public class TestFileOuputStream {

	public static void main(String[] args) {
		// 1 创建源
		File file = new File("D:/eclipse-workspace/File_IO/IO流资源/IO_output.txt");
		// 2 选择流
		OutputStream outputStream = null;
		try {
			// outputStream = new FileOutputStream(file);
			outputStream = new FileOutputStream(file,true); // 追加的方式
			// 3 操作
			String message = "BBC News with Marian Marshall\n";
			byte[] datas = message.getBytes(); // 字符串->字节数组(编码)
			outputStream.write(datas, 0, datas.length);
			outputStream.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 4 释放资源
			try {
				if (outputStream != null) {
					outputStream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
