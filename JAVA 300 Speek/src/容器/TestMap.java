package 容器;

import java.util.HashMap;
import java.util.Map;

public class TestMap {

	public static void main(String[] args) {

		test1();
		test2();
	}

	private static void test2() {
		Map<Integer, Employee> m = new HashMap<Integer, Employee>();
		
		Employee employee1 = new Employee(1001,"小明",3000);
		Employee employee2 = new Employee(1001,"小红",5000);
		Employee employee3 = new Employee(1001,"小刚",6000);
		
		m.put(1001, employee1);
		m.put(1002, employee1);
		m.put(1003, employee1);
		
		System.out.println(m);
	}

	public static void test1() {
		Map<Integer, String> m1 = new HashMap<Integer, String>();
		Map<Integer, String> m2 = new HashMap<Integer, String>();
		m1.put(1, "one");
		m1.put(2, "two");
		m1.put(3, "three");
		m1.put(3, "三"); // 键重复了，则会替换旧的键值对
		System.out.println("键为3对应的值：" + m1.get(3)); // 获取键所对应的值
		System.out.println("m1是否为空：" + m1.isEmpty()); // 包含键值对数量
		System.out.println("m1键值对数量：" + m1.size()); // 包含键值对数量
		System.out.println("m1是否包含键：" + m1.containsKey(1)); // 是否包含某个键
		System.out.println("m1是否包含值：" + m1.containsValue("two")); // 是否包含某个值

		m2.put(1, "一");
		m2.put(2, "二");

		Map<Integer, String> m3 = new HashMap<Integer, String>();
		m3.putAll(m1); // 将一个map所有元素复制到另一个map
		m3.putAll(m2); // 键重复了，则会替换旧的键值对
		System.out.println("m1:" + m1);
		System.out.println("m2:" + m2);
		System.out.println("m3:" + m3);

		m3.remove(3); // 删除键值对
		System.out.println("m3:" + m3);
		m3.clear(); // 清空
	}
}

class Employee {
	private int id;
	private String name;
	private int salary;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Employee(int id, String name, int salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "("+id+","+name+","+salary+")";
	}

}