package 容器;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * Collection接口的两个子接口是List、Set接口
 * 
 */
public class TestCollection {

	public static void main(String[] args) {

		Collection<String> collection1 = new ArrayList<>();
		Collection<String> collection2 = new ArrayList<>();
		Collection<String> collection3 = new ArrayList<>();
		Collection<String> collection4 = new ArrayList<>();

		System.out.println("collection1是否为空：" + collection1.isEmpty()); // 是否为空
		collection1.add("A"); // 添加
		collection1.add("B");
		collection1.add("C");
		collection1.add("A");
		System.out.println(collection1);
		collection1.remove("A"); // 移除第一个
		System.out.println(collection1);
		System.out.println("collection1是否含有A：" + collection1.contains("A")); // 是否包含

		collection2.add("a");
		collection2.add("b");
		collection2.add("c");
		System.out.println(collection2);
		Object[] objs = collection2.toArray(); // 转换为数组
		System.out.println("collection2转化成Object数组：" + Arrays.toString(objs));

		collection3.addAll(collection1); // 添加整个容器
		collection3.addAll(collection2);
		System.out.println(collection3);

		System.out.println("collection3是否含有collection1所有元素：" + collection3.containsAll(collection1)); // 是否包含某个容器所有内容

		collection3.removeAll(collection2); // 移除两个容器中都含有的内容
		System.out.println(collection3);

		collection4.add("A");
		collection4.add("B");

		collection3.retainAll(collection4); // 取两个容器的交集内容
		System.out.println(collection3);

		collection3.clear(); // 清空容器
		System.out.println("collection3的大小：" + collection3.size()); // 容器大小
	}

}
