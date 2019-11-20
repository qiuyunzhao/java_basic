package 节点流;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 字节数组流：
 * ByteArrayInputStream是把内存中的”某个字节数组对象”当做数据源
 * 操作步骤： 1 创建源(不与文件关联) --> 2 选择流 --> 3 操作 --> 4 释放资源(可以不用释放，自动释放)
 */
public class TestByteArrayInputStream {

	public static void main(String[] args) {
		// 1 创建源
		byte[] b = "a b c d e f g".getBytes();
		// 2 选择流
		InputStream inputStream = null;
		try {
			inputStream = new ByteArrayInputStream(b);
			// 3 操作
			// 每次读取一定长度字节
			byte[] flush = new byte[2]; // 缓冲容器
			int length = -1; // 接收长度
			while ((length = inputStream.read(flush)) != -1) {
				String content = new String(flush, 0, length); // 字符数组->字符串(解码)
				System.out.println(content);
			}
			// 每次读取一个字节
			// int temp;
			// while ((temp = inputStream.read()) != -1) {
			// System.out.println((char)temp);
			// }
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 4 释放资源（可以不用写代码释放，会自动释放，这里只是为了风格统一）
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
