package 节点流;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * 字节数组流：
 * 可以操作图片和视频等
 * 中文可能会出现乱码（截取字节数不够）
 * 操作步骤： 1 创建源(内部维护) --> 2 选择流 （不关联源）--> 3 操作 --> 4 释放资源（可以不用释放）
 */
public class TestByteArrayOutputStream {

	public static void main(String[] args) {
		// 1 创建源
		byte[] dest = null;	//流输出到该数组中
		// 2 选择流
		ByteArrayOutputStream byteArrayOutputStream = null;
		try {
			byteArrayOutputStream = new ByteArrayOutputStream(); // ByteArrayOutputStream类中新增方法
			// 3 操作
			String message = "BBC News with Marian Marshall";
			byte[] datas = message.getBytes(); // 字符串->字节数组(编码)
			byteArrayOutputStream.write(datas, 0, datas.length);
			byteArrayOutputStream.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 4 释放资源（可以不用释放）
			try {
				if (byteArrayOutputStream != null) {
					byteArrayOutputStream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
 
		dest = byteArrayOutputStream.toByteArray();
		System.out.println(dest.length + "---" + new String(dest,0,byteArrayOutputStream.size()));
		
	}

}
