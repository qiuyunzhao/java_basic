package ����;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class TestIterator {

	public static void main(String[] args) {

		// ����List ���򣬿��ظ�
		List<String> aList = new ArrayList<String>();
		for (int i = 0; i < 6; i++) {
			aList.add("arrayList" + i);
		}
		System.out.println(aList);

		// ����Set ���򣬲����ظ�
		Set<String> hSet = new HashSet<String>();
		for (int i = 0; i < 6; i++) {
			hSet.add("set" + i);
		}
		System.out.println(hSet);

		// ����Map ���򣬼������ظ�
		Map<Integer, String> hMap = new HashMap<Integer, String>();
		for (int i = 0; i < 6; i++) {
			hMap.put(i, "map" + i);
		}
		System.out.println(hMap);

		// ����List
		 traverseList1(aList); //���÷��� ���Ҫ����ʱ�����������е�Ԫ�أ�����ʹ�����ַ�ʽ��
		// traverseList2(aList); //��ǿforѭ�� ����ʱ�����������е�Ԫ�أ�������ʹ�����ַ�ʽ��ɾ�����ܻ������
		// traverseList3(aList);
		// traverseList4(aList);

		 traverseSet1(hSet); //���÷��� ���Ҫ����ʱ�����������е�Ԫ�أ�����ʹ�����ַ�ʽ��
		// traverseSet2(hSet); //��ǿforѭ�� ����ʱ�����������е�Ԫ�أ�������ʹ�����ַ�ʽ��ɾ�����ܻ������
		// traverseSet3(hSet);

		 traverseMap1(hMap);
		// traverseMap1(hMap);
	}

	/**
	 * ���÷��� ���Ҫ����ʱ�����������е�Ԫ�أ�����ʹ�����ַ�ʽ��
	 * 
	 * @param alist
	 */
	public static void traverseList1(List<String> alist) {
		Iterator iter = alist.iterator();
		while (iter.hasNext()) {
			String temp = (String) iter.next();
			if (temp.endsWith("4")) {
				iter.remove();
			} else {
				System.out.println(temp);
			}
		}
		System.out.println(alist);
	}

	/**
	 * ��ǿforѭ�� ����ʱ�����������е�Ԫ�أ�������ʹ�����ַ�ʽ�����ܻ������
	 * 
	 * @param alist
	 */
	public static void traverseList2(List<String> alist) {
		int i = 0;
		for (String temp : alist) { // ѭ�������У���alist�����仯ʱ�ᱨ��
			if (temp.endsWith("4")) {
				// alist.remove(i);// ɾ���ᱨ��
				alist.set(i, "arrayList");
			} else {
				System.out.println(temp);
			}
			i++;
		}
		System.out.println(alist);
	}

	/**
	 * ���Ҫ����ʱ�����������е�Ԫ�أ�����ʹ�����ַ�ʽ��
	 * 
	 * @param alist
	 */
	public static void traverseList3(List<String> alist) {
		for (Iterator iter = alist.iterator(); iter.hasNext();) {
			String temp = (String) iter.next();
			if (temp.endsWith("4")) { // ɾ��4��β���ַ���
				iter.remove();
			} else {
				System.out.println(temp);
			}

		}
		System.out.println(alist);
	}

	/**
	 * ��ͨforѭ�� ������
	 * 
	 * @param alist
	 */
	public static void traverseList4(List<String> alist) {
		for (int i = 0; i < alist.size(); i++) {// listΪ���ϵĶ�����
			String temp = (String) alist.get(i);
			if (temp.endsWith("4")) {
				alist.remove(i); // �����С����
				i--; // �����Ԫ�طŵ��˵�ǰλ��
			} else {
				System.out.println(temp);
			}
		}
		System.out.println(alist);
	}

	/**
	 * ���÷��� ���Ҫ����ʱ�����������е�Ԫ�أ�����ʹ�����ַ�ʽ��
	 * 
	 * @param alist
	 */
	public static void traverseSet1(Set<String> hSet) {
		Iterator iter = hSet.iterator();
		while (iter.hasNext()) {
			String temp = (String) iter.next();
			if (temp.endsWith("4")) {
				iter.remove();
			} else {
				System.out.println(temp);
			}
		}
		System.out.println(hSet);
	}

	/**
	 * ��ǿforѭ�� ����ʱ�����������е�Ԫ�أ�������ʹ�����ַ�ʽ�����ܻ������
	 * 
	 * @param alist
	 */
	public static void traverseSet2(Set<String> hSet) {
		for (String temp : hSet) { 
			if (temp.endsWith("4")) {
				hSet.remove(temp);	// ɾ��ʱ�ᱨ��
			} else {
				System.out.println(temp);
			}
		}
		System.out.println(hSet);
	}

	/**
	 * ���Ҫ����ʱ�����������е�Ԫ�أ�����ʹ�����ַ�ʽ��
	 * 
	 * @param alist
	 */
	public static void traverseSet3(Set<String> hSet) {
		for (Iterator iter = hSet.iterator(); iter.hasNext();) {
			String temp = (String) iter.next();
			if (temp.endsWith("4")) { // ɾ��4��β���ַ���
				iter.remove();
			} else {
				System.out.println(temp);
			}

		}
		System.out.println(hSet);
	}

	/**
	 * ͨ��Set<Integer>��ȡ���Ա���Key�� iterator
	 * ,ͨ��iterator.next()��ȡKey,ͨ��Map.get(key)��ȡ��ӦValue
	 * 
	 * @param alist
	 */
	public static void traverseMap1(Map<Integer, String> hMap) {

		Set<Integer> ss = hMap.keySet();
		Iterator<Integer> iterator = ss.iterator();

		while (iterator.hasNext()) {
			Integer key = iterator.next();
			String value = hMap.get(key);

			if (value.endsWith("4")) {
				hMap.replace(key, "map");
				// hMap.remove(key); //ɾ���ᱨ��
			} else {
				System.out.println(key + "--" + value);
			}
		}
		System.out.println(hMap);
	}

	/**
	 * ͨ��Set<Entry<Integer, String>>��ȡ����Key��Value�� iterator,
	 * ͨ��iterator.next()��ȡ��װKey��Value�� Entry<Integer, String>, ͨ��Entry<String,
	 * String>��getKey()��ȡKey, getValue()��ȡValue
	 * 
	 * @param alist
	 */
	public static void traverseMap2(Map<Integer, String> hMap) {

		Set<Entry<Integer, String>> ss = hMap.entrySet(); // ͨ��Set����ȡiterator
		for (Iterator<Entry<Integer, String>> iterator = ss.iterator(); iterator.hasNext();) {
			Entry<Integer, String> e = iterator.next();
			int key = e.getKey();
			String value = e.getValue();
			if (value.endsWith("4")) {
				hMap.replace(key, "map");
				// hMap.remove(key); //ɾ���ᱨ��
			} else {
				System.out.println(key + "--" + value);
			}
		}
		System.out.println(hMap);
	}

}
