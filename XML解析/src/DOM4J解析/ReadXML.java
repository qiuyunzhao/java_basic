package DOM4J解析;

import java.io.File;
import java.util.Iterator;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class ReadXML {

	public static void main(String[] args) throws Exception {

		// 【1】 获得一个SAXReader解析器,用于读取xml对象
		SAXReader saxreader = new SAXReader();

		// 【2】 读取XML文件，得到Document对象（就是整个xml文件）
		Document document = saxreader.read(new File("scores.xml"));

		// 【3】 获取根元素(scores)
		Element root = document.getRootElement();

		// 【4】 获取根元素下所有子元素
		Iterator<Element> it = root.elementIterator();
		
		while (it.hasNext()) {
			Element e = it.next(); // 取出子元素(student)
			System.out.println(e.getName());

			// 获取student的属性
			Iterator<Attribute> it1 = e.attributeIterator();
			while (it1.hasNext()) {
				Attribute a = it1.next(); // 取出子元素
				System.out.print(a.getName() + "=" + a.getValue() + "\t");
			}
			System.out.println();

			// 获取student的子元素
			Element name = e.element("name");
			Element course = e.element("course");
			Element score = e.element("score");
			System.out.println(name.getName() + "=" + name.getStringValue());
			System.out.println(course.getName() + "=" + course.getText());
			System.out.println(score.getName() + "=" + score.getText());

			System.out.println("----------------------------------");
		}

	}

}
