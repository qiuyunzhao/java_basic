package ����;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestCollections {

	public static void main(String[] args) {
		
		List<String> aList = new ArrayList<String>();
        for (int i = 0; i < 5; i++){
            aList.add("a" + i);
        }
        System.out.println(aList);
        Collections.reverse(aList); // ����
        System.out.println(aList);
        Collections.shuffle(aList); // �������
        System.out.println(aList);
        Collections.sort(aList); // ����
        System.out.println(aList);
        System.out.println(Collections.binarySearch(aList, "a2")); //���ַ�����
        Collections.fill(aList, "hello");	//�������Ԫ��
        System.out.println(aList);

	}

}
