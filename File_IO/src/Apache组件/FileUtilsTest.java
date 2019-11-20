package Apache���;

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
		// �ļ���С
		long len = FileUtils.sizeOf(new File("D:/eclipse-workspace/File_IO/IO����Դ/��ƪ.mp4"));
		System.out.println(len);
		// Ŀ¼��С
		len = FileUtils.sizeOf(new File("D:/eclipse-workspace/File_IO/IO����Դ"));
		System.out.println(len);
		// �г�
		// Collection<File> files = FileUtils.listFiles(new File("D:/eclipse-workspace/File_IO/IO����Դ"),EmptyFileFilter.NOT_EMPTY, null); //�г���ǰĿ¼
		// Collection<File> files = FileUtils.listFiles(new File("D:/eclipse-workspace/File_IO/IO����Դ"),EmptyFileFilter.NOT_EMPTY, DirectoryFileFilter.DIRECTORY);//�г���ǰĿ¼������Ŀ¼
		Collection<File> files = FileUtils.listFiles(new File("D:/eclipse-workspace/File_IO/IO����Դ"),
				FileFilterUtils.or(new SuffixFileFilter("mp4"), new SuffixFileFilter("ser")), null);	//�ļ���׺Ϊmp4��ser
		for (File file : files) {
			System.out.println(file.getAbsolutePath());
		}
		
		//��ȡ�ļ�
		String msg = FileUtils.readFileToString(new File("IO����Դ/PrintStream.txt"),"GBK");
		System.out.println(msg);
		
		byte[] datas = FileUtils.readFileToByteArray(new File("IO����Դ/PrintStream.txt"));
		System.out.println(datas.length);
		
		List<String> msgs = FileUtils.readLines(new File("IO����Դ/PrintStream.txt"), "GBK");
		for (String line : msgs) {
			System.out.println(line);
		}
		
		LineIterator it = FileUtils.lineIterator(new File("IO����Դ/PrintStream.txt"), "GBK");
		while(it.hasNext()) {
			System.out.println(it.nextLine());
		}
		
		//д�ļ�
		FileUtils.write(new File("IO����Դ/FileUtils.txt"),"ѧϰ��ΰ�������\r\n", "GBK");
		FileUtils.writeStringToFile(new File("IO����Դ/FileUtils.txt"),"ѧϰ�ǿ��ֵ�����\r\n", "GBK",true);
		FileUtils.writeByteArrayToFile(new File("IO����Դ/FileUtils.txt"),"ѧϰ���Ҹ�������\r\n".getBytes("GBK"),true);
		List<String> list = new ArrayList<>();
		list.add("����1");
		list.add("����2");
		list.add("����3");
		FileUtils.writeLines(new File("IO����Դ/FileUtils.txt"), list, "-->", true);
		
		//����
		String url = "http://dingyue.nosdn.127.net/RqoXIDH5UQHPTVhtJhva1HkRlXqHW9pOkiLs9ykREBaYz1554459697256compressflag.jpeg?imageView";
		FileUtils.copyURLToFile(new URL(url), new File("IO����Դ/����.jpg"));
		
		FileUtils.copyFile(new File("IO����Դ/����.jpg"),new File("IO����Դ/����copy.jpg"));
		
		String baidusource = IOUtils.toString(new URL("http://www.baidu.com"),"UTF-8");
		System.out.println(baidusource);
	}

}
