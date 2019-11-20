package ����;

import java.util.ArrayList;
import java.util.List;

public class TestList {

	/**
	 * List�����򡢿��ظ����������̳���Collection�ӿڵ����з�������������������
	 * 
	 * ����List��ÿ��Ԫ�ض���������ǡ����Ը���Ԫ�ص��������(��List�е�λ��)����Ԫ�أ��Ӷ���ȷ������ЩԪ�ء�
	 * 
	 * ���ظ���List��������ظ���Ԫ�ء���ȷ�еؽ���Listͨ���������� e1.equals(e2) ��Ԫ���ظ���������
	 * 
	 */
	public static void main(String[] args) {
		
		List<String> list = new ArrayList<String>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        System.out.println(list); // [A, B, C, D]
        
        list.add(2, "��");
        System.out.println(list); // [A, B, ��, C, D]
        
        list.remove(2);
        System.out.println(list); // [A, B, C, D]
        
        list.set(2, "��");
        System.out.println(list); // [A, B, ��, D]
        
        System.out.println(list.get(1)); // ���أ�B
        
        list.add("B");
        System.out.println(list); // [A, B, ��, D, B]
        
        System.out.println(list.indexOf("B")); // 1 ��ͷ��β�ҵ���һ��"B"
        System.out.println(list.lastIndexOf("B")); // 4 ��β��ͷ�ҵ���һ��"B"
	}

}
