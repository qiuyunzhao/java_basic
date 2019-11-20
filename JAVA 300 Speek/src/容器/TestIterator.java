package 容器;

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

		// 创建List 有序，可重复
		List<String> aList = new ArrayList<String>();
		for (int i = 0; i < 6; i++) {
			aList.add("arrayList" + i);
		}
		System.out.println(aList);

		// 创建Set 无序，不可重复
		Set<String> hSet = new HashSet<String>();
		for (int i = 0; i < 6; i++) {
			hSet.add("set" + i);
		}
		System.out.println(hSet);

		// 创建Map 有序，键不能重复
		Map<Integer, String> hMap = new HashMap<Integer, String>();
		for (int i = 0; i < 6; i++) {
			hMap.put(i, "map" + i);
		}
		System.out.println(hMap);

		// 遍历List
		 traverseList1(aList); //常用方法 如果要遍历时，操作集合中的元素，建议使用这种方式！
		// traverseList2(aList); //增强for循环 遍历时，操作集合中的元素，不建议使用这种方式（删除可能会出错）！
		// traverseList3(aList);
		// traverseList4(aList);

		 traverseSet1(hSet); //常用方法 如果要遍历时，操作集合中的元素，建议使用这种方式！
		// traverseSet2(hSet); //增强for循环 遍历时，操作集合中的元素，不建议使用这种方式（删除可能会出错）！
		// traverseSet3(hSet);

		 traverseMap1(hMap);
		// traverseMap1(hMap);
	}

	/**
	 * 常用方法 如果要遍历时，操作集合中的元素，建议使用这种方式！
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
	 * 增强for循环 遍历时，操作集合中的元素，不建议使用这种方式（可能会出错）！
	 * 
	 * @param alist
	 */
	public static void traverseList2(List<String> alist) {
		int i = 0;
		for (String temp : alist) { // 循环过程中，当alist发生变化时会报错
			if (temp.endsWith("4")) {
				// alist.remove(i);// 删除会报错
				alist.set(i, "arrayList");
			} else {
				System.out.println(temp);
			}
			i++;
		}
		System.out.println(alist);
	}

	/**
	 * 如果要遍历时，操作集合中的元素，建议使用这种方式！
	 * 
	 * @param alist
	 */
	public static void traverseList3(List<String> alist) {
		for (Iterator iter = alist.iterator(); iter.hasNext();) {
			String temp = (String) iter.next();
			if (temp.endsWith("4")) { // 删除4结尾的字符串
				iter.remove();
			} else {
				System.out.println(temp);
			}

		}
		System.out.println(alist);
	}

	/**
	 * 普通for循环 遍历！
	 * 
	 * @param alist
	 */
	public static void traverseList4(List<String> alist) {
		for (int i = 0; i < alist.size(); i++) {// list为集合的对象名
			String temp = (String) alist.get(i);
			if (temp.endsWith("4")) {
				alist.remove(i); // 数组大小变了
				i--; // 后面的元素放到了当前位置
			} else {
				System.out.println(temp);
			}
		}
		System.out.println(alist);
	}

	/**
	 * 常用方法 如果要遍历时，操作集合中的元素，建议使用这种方式！
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
	 * 增强for循环 遍历时，操作集合中的元素，不建议使用这种方式（可能会出错）！
	 * 
	 * @param alist
	 */
	public static void traverseSet2(Set<String> hSet) {
		for (String temp : hSet) { 
			if (temp.endsWith("4")) {
				hSet.remove(temp);	// 删除时会报错
			} else {
				System.out.println(temp);
			}
		}
		System.out.println(hSet);
	}

	/**
	 * 如果要遍历时，操作集合中的元素，建议使用这种方式！
	 * 
	 * @param alist
	 */
	public static void traverseSet3(Set<String> hSet) {
		for (Iterator iter = hSet.iterator(); iter.hasNext();) {
			String temp = (String) iter.next();
			if (temp.endsWith("4")) { // 删除4结尾的字符串
				iter.remove();
			} else {
				System.out.println(temp);
			}

		}
		System.out.println(hSet);
	}

	/**
	 * 通过Set<Integer>获取可以遍历Key的 iterator
	 * ,通过iterator.next()获取Key,通过Map.get(key)获取对应Value
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
				// hMap.remove(key); //删除会报错
			} else {
				System.out.println(key + "--" + value);
			}
		}
		System.out.println(hMap);
	}

	/**
	 * 通过Set<Entry<Integer, String>>获取遍历Key和Value的 iterator,
	 * 通过iterator.next()获取封装Key和Value的 Entry<Integer, String>, 通过Entry<String,
	 * String>的getKey()获取Key, getValue()获取Value
	 * 
	 * @param alist
	 */
	public static void traverseMap2(Map<Integer, String> hMap) {

		Set<Entry<Integer, String>> ss = hMap.entrySet(); // 通过Set来获取iterator
		for (Iterator<Entry<Integer, String>> iterator = ss.iterator(); iterator.hasNext();) {
			Entry<Integer, String> e = iterator.next();
			int key = e.getKey();
			String value = e.getValue();
			if (value.endsWith("4")) {
				hMap.replace(key, "map");
				// hMap.remove(key); //删除会报错
			} else {
				System.out.println(key + "--" + value);
			}
		}
		System.out.println(hMap);
	}

}
