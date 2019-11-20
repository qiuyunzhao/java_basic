package DOM4J解析;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.io.Writer;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

public class WriteXML {

	public static void main(String[] args) throws Exception {

		// 【1】 通过DocumentHelper获得一个Document对象
		Document document = DocumentHelper.createDocument();

		// 【2】 添加根元素
		Element root = document.addElement("books");

		// 【3】 为根元素添加子元素
		Element book1 = root.addElement("book1");

		// 【4】 为book1添加属性
		Element book = book1.addAttribute("id", "1")
		             .addAttribute("date", "2019");  		//	返回值还是book1对象，为了方便链式编程
		
		System.out.println(book1);
		System.out.println(book);
		
		// 【5】为book1添加子元素
		Element name = book1.addElement("name");
		Element author = book1.addElement("author");
		Element price = book1.addElement("price");
		
		// 【6】 为book1的子元素添加文本
		name.addText("射雕英雄传");
		author.addText("金庸");
		price.addText("10$");
		
		// 【7】将 document 输出到  .xml文件中
		OutputFormat format = OutputFormat.createPrettyPrint();	//良好的输出格式
		XMLWriter writer=new XMLWriter(new OutputStreamWriter(new FileOutputStream("books.xml"), "UTF-8"),format);
		writer.write(document);
		
		// 【8】 关闭资源
		writer.close();
	}

}
