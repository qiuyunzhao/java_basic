package DOM4J����;

import java.io.File;
import java.util.Iterator;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class ReadXML {

	public static void main(String[] args) throws Exception {

		// ��1�� ���һ��SAXReader������,���ڶ�ȡxml����
		SAXReader saxreader = new SAXReader();

		// ��2�� ��ȡXML�ļ����õ�Document���󣨾�������xml�ļ���
		Document document = saxreader.read(new File("scores.xml"));

		// ��3�� ��ȡ��Ԫ��(scores)
		Element root = document.getRootElement();

		// ��4�� ��ȡ��Ԫ����������Ԫ��
		Iterator<Element> it = root.elementIterator();
		
		while (it.hasNext()) {
			Element e = it.next(); // ȡ����Ԫ��(student)
			System.out.println(e.getName());

			// ��ȡstudent������
			Iterator<Attribute> it1 = e.attributeIterator();
			while (it1.hasNext()) {
				Attribute a = it1.next(); // ȡ����Ԫ��
				System.out.print(a.getName() + "=" + a.getValue() + "\t");
			}
			System.out.println();

			// ��ȡstudent����Ԫ��
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
