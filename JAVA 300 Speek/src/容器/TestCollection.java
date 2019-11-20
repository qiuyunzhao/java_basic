package ����;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * Collection�ӿڵ������ӽӿ���List��Set�ӿ�
 * 
 */
public class TestCollection {

	public static void main(String[] args) {

		Collection<String> collection1 = new ArrayList<>();
		Collection<String> collection2 = new ArrayList<>();
		Collection<String> collection3 = new ArrayList<>();
		Collection<String> collection4 = new ArrayList<>();

		System.out.println("collection1�Ƿ�Ϊ�գ�" + collection1.isEmpty()); // �Ƿ�Ϊ��
		collection1.add("A"); // ���
		collection1.add("B");
		collection1.add("C");
		collection1.add("A");
		System.out.println(collection1);
		collection1.remove("A"); // �Ƴ���һ��
		System.out.println(collection1);
		System.out.println("collection1�Ƿ���A��" + collection1.contains("A")); // �Ƿ����

		collection2.add("a");
		collection2.add("b");
		collection2.add("c");
		System.out.println(collection2);
		Object[] objs = collection2.toArray(); // ת��Ϊ����
		System.out.println("collection2ת����Object���飺" + Arrays.toString(objs));

		collection3.addAll(collection1); // �����������
		collection3.addAll(collection2);
		System.out.println(collection3);

		System.out.println("collection3�Ƿ���collection1����Ԫ�أ�" + collection3.containsAll(collection1)); // �Ƿ����ĳ��������������

		collection3.removeAll(collection2); // �Ƴ����������ж����е�����
		System.out.println(collection3);

		collection4.add("A");
		collection4.add("B");

		collection3.retainAll(collection4); // ȡ���������Ľ�������
		System.out.println(collection3);

		collection3.clear(); // �������
		System.out.println("collection3�Ĵ�С��" + collection3.size()); // ������С
	}

}
