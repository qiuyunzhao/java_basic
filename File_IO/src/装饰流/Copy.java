package 装饰流;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Copy {

	public static void main(String[] args) {
		// 使用缓冲字节流实现复制,效率高
		long time1 = System.currentTimeMillis();
		byteCopyFileByBuffer("D:/eclipse-workspace/File_IO/IO流资源/开篇.mp4", "IO流资源/开篇copy.mp4");
		long time2 = System.currentTimeMillis();
		System.out.println("缓冲字节流花费的时间为：" + (time2 - time1));

		// 使用普通字节流实现复制
		long time3 = System.currentTimeMillis();
		byteCopyFile("D:/eclipse-workspace/File_IO/IO流资源/开篇.mp4", "IO流资源/开篇copy2.mp4");
		long time4 = System.currentTimeMillis();
		System.out.println("普通字节流花费的时间为：" + (time4 - time3));

		// 使用缓冲字符流实现复制,效率高
		charCopyFileByBuffer("D:/eclipse-workspace/File_IO/IO流资源/IO_input.txt", "IO流资源/IO_input_copy.txt");
	}

	/** 缓冲字节流实现的文件复制的方法 */
	static void byteCopyFileByBuffer(String src, String dec) {
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		try {
			// 1 创建源
			fis = new FileInputStream(src);
			fos = new FileOutputStream(dec);
			// 2 选择流
			// 使用缓冲字节流包装文件字节流，增加缓冲功能，提高效率。缓存区的大小（缓存数组的长度）默认是8192，也可以自己指定大小
			bis = new BufferedInputStream(fis); // 多套几层是没用的
			bos = new BufferedOutputStream(fos);
			// 3 操作
			// 每次读取一定长度字节
			byte[] flush = new byte[1024 * 1]; // 缓冲容器 容器越大速度快（有上限）
			int length = -1; // 接收长度
			while ((length = bis.read(flush)) != -1) {
				bos.write(length);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 4 释放资源
			// 注意：增加处理流后，注意流的关闭顺序！“后开的先关闭！”
			try {
				if (bos != null) {
					bos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if (bis != null) {
					bis.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/** 普通节点流实现的文件复制的方法 */
	static void byteCopyFile(String src, String dec) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			// 1 创建源 2 选择流
			fis = new FileInputStream(src);
			fos = new FileOutputStream(dec);
			// 3 操作
			// 每次读取一定长度字节
			byte[] flush = new byte[1024 * 1]; // 缓冲容器
			int length = -1; // 接收长度
			while ((length = fis.read(flush)) != -1) {
				fos.write(length);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 4 释放资源
			try {
				if (fos != null) {
					fos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if (fis != null) {
					fis.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 注：仅限于处理文本文件时，实际开发中可以用如下写法，简单高效！！
	 */
	private static void charCopyFileByBuffer(String src, String dec) {
		FileReader fr = null;
		FileWriter fw = null;
		BufferedReader br = null;
		BufferedWriter bw = null;
		try {
			fr = new FileReader(src);
			fw = new FileWriter(dec);
			// 使用缓冲字符流进行包装
			br = new BufferedReader(fr);
			bw = new BufferedWriter(fw);
			// BufferedReader提供了更方便的readLine()方法，直接按行读取文本,br.readLine()方法的返回值是一个字符串对象，即文本中的一行内容
			String tempString = "";
			while ((tempString = br.readLine()) != null) {
				bw.write(tempString); // 将读取的一行字符串写入文件中
				bw.newLine(); // 下次写入之前先换行，否则会在上一行后边继续追加，而不是另起一行
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bw != null) {
					bw.close();
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			try {
				if (br != null) {
					br.close();
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

}
