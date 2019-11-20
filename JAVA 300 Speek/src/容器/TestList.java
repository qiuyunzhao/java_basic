package 容器;

import java.util.ArrayList;
import java.util.List;

public class TestList {

	/**
	 * List是有序、可重复的容器。继承了Collection接口的所有方法并加入了索引操作
	 * 
	 * 有序：List中每个元素都有索引标记。可以根据元素的索引标记(在List中的位置)访问元素，从而精确控制这些元素。
	 * 
	 * 可重复：List允许加入重复的元素。更确切地讲，List通常允许满足 e1.equals(e2) 的元素重复加入容器
	 * 
	 */
	public static void main(String[] args) {
		
		List<String> list = new ArrayList<String>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        System.out.println(list); // [A, B, C, D]
        
        list.add(2, "高");
        System.out.println(list); // [A, B, 高, C, D]
        
        list.remove(2);
        System.out.println(list); // [A, B, C, D]
        
        list.set(2, "低");
        System.out.println(list); // [A, B, 低, D]
        
        System.out.println(list.get(1)); // 返回：B
        
        list.add("B");
        System.out.println(list); // [A, B, 低, D, B]
        
        System.out.println(list.indexOf("B")); // 1 从头到尾找到第一个"B"
        System.out.println(list.lastIndexOf("B")); // 4 从尾到头找到第一个"B"
	}

}
