package 装饰流;

import java.io.BufferedOutputStream;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * 用的不多
 *
 */
public class PrintStreamANDPrintWriter {

	public static void main(String[] args) throws FileNotFoundException {
		
		PrintStream ps = System.out;
		
		//控制台打印
		ps.println("控制台打印流");
		ps.println(true);
		//打印到文件
		ps = new PrintStream(new BufferedOutputStream(new FileOutputStream("IO流资源/PrintStream.txt")),true);	//自动刷新
		ps.println("文件打印流");
		//输出重定向到文件
		System.setOut(ps);	//以后输出都在重定向的位置，而不是控制台
		System.out.println("输出重定向到文件");
		//重定向回控制台
		System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream(FileDescriptor.out)),true));
		System.out.println("输出重定回控制台");
		
		ps.close();
		
		PrintWriter pw = new PrintWriter(new BufferedOutputStream(new FileOutputStream("IO流资源/PrintStream.txt")),true);	//自动刷新
		pw.append("PrintWriter打印流");
		pw.close();
	}

}
