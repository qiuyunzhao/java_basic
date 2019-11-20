package Apache组件;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.LineIterator;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.SuffixFileFilter;

public class FileUtilsTest {

	public static void main(String[] args) throws IOException {
		// 文件大小
		long len = FileUtils.sizeOf(new File("D:/eclipse-workspace/File_IO/IO流资源/开篇.mp4"));
		System.out.println(len);
		// 目录大小
		len = FileUtils.sizeOf(new File("D:/eclipse-workspace/File_IO/IO流资源"));
		System.out.println(len);
		// 列出
		// Collection<File> files = FileUtils.listFiles(new File("D:/eclipse-workspace/File_IO/IO流资源"),EmptyFileFilter.NOT_EMPTY, null); //列出当前目录
		// Collection<File> files = FileUtils.listFiles(new File("D:/eclipse-workspace/File_IO/IO流资源"),EmptyFileFilter.NOT_EMPTY, DirectoryFileFilter.DIRECTORY);//列出当前目录及其子目录
		Collection<File> files = FileUtils.listFiles(new File("D:/eclipse-workspace/File_IO/IO流资源"),
				FileFilterUtils.or(new SuffixFileFilter("mp4"), new SuffixFileFilter("ser")), null);	//文件后缀为mp4，ser
		for (File file : files) {
			System.out.println(file.getAbsolutePath());
		}
		
		//读取文件
		String msg = FileUtils.readFileToString(new File("IO流资源/PrintStream.txt"),"GBK");
		System.out.println(msg);
		
		byte[] datas = FileUtils.readFileToByteArray(new File("IO流资源/PrintStream.txt"));
		System.out.println(datas.length);
		
		List<String> msgs = FileUtils.readLines(new File("IO流资源/PrintStream.txt"), "GBK");
		for (String line : msgs) {
			System.out.println(line);
		}
		
		LineIterator it = FileUtils.lineIterator(new File("IO流资源/PrintStream.txt"), "GBK");
		while(it.hasNext()) {
			System.out.println(it.nextLine());
		}
		
		//写文件
		FileUtils.write(new File("IO流资源/FileUtils.txt"),"学习是伟大的事情\r\n", "GBK");
		FileUtils.writeStringToFile(new File("IO流资源/FileUtils.txt"),"学习是快乐的事情\r\n", "GBK",true);
		FileUtils.writeByteArrayToFile(new File("IO流资源/FileUtils.txt"),"学习是幸福的事情\r\n".getBytes("GBK"),true);
		List<String> list = new ArrayList<>();
		list.add("星期1");
		list.add("星期2");
		list.add("星期3");
		FileUtils.writeLines(new File("IO流资源/FileUtils.txt"), list, "-->", true);
		
		//拷贝
		String url = "http://dingyue.nosdn.127.net/RqoXIDH5UQHPTVhtJhva1HkRlXqHW9pOkiLs9ykREBaYz1554459697256compressflag.jpeg?imageView";
		FileUtils.copyURLToFile(new URL(url), new File("IO流资源/赵敏.jpg"));
		
		FileUtils.copyFile(new File("IO流资源/赵敏.jpg"),new File("IO流资源/赵敏copy.jpg"));
		
		String baidusource = IOUtils.toString(new URL("http://www.baidu.com"),"UTF-8");
		System.out.println(baidusource);
	}

}
