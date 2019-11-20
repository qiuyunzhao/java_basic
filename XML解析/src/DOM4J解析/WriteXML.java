package DOM4J����;

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

		// ��1�� ͨ��DocumentHelper���һ��Document����
		Document document = DocumentHelper.createDocument();

		// ��2�� ��Ӹ�Ԫ��
		Element root = document.addElement("books");

		// ��3�� Ϊ��Ԫ�������Ԫ��
		Element book1 = root.addElement("book1");

		// ��4�� Ϊbook1�������
		Element book = book1.addAttribute("id", "1")
		             .addAttribute("date", "2019");  		//	����ֵ����book1����Ϊ�˷�����ʽ���
		
		System.out.println(book1);
		System.out.println(book);
		
		// ��5��Ϊbook1�����Ԫ��
		Element name = book1.addElement("name");
		Element author = book1.addElement("author");
		Element price = book1.addElement("price");
		
		// ��6�� Ϊbook1����Ԫ������ı�
		name.addText("���Ӣ�۴�");
		author.addText("��ӹ");
		price.addText("10$");
		
		// ��7���� document �����  .xml�ļ���
		OutputFormat format = OutputFormat.createPrettyPrint();	//���õ������ʽ
		XMLWriter writer=new XMLWriter(new OutputStreamWriter(new FileOutputStream("books.xml"), "UTF-8"),format);
		writer.write(document);
		
		// ��8�� �ر���Դ
		writer.close();
	}

}
