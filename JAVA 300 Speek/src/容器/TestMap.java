package ����;

import java.util.HashMap;
import java.util.Map;

public class TestMap {

	public static void main(String[] args) {

		test1();
		test2();
	}

	private static void test2() {
		Map<Integer, Employee> m = new HashMap<Integer, Employee>();
		
		Employee employee1 = new Employee(1001,"С��",3000);
		Employee employee2 = new Employee(1001,"С��",5000);
		Employee employee3 = new Employee(1001,"С��",6000);
		
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
		m1.put(3, "��"); // ���ظ��ˣ�����滻�ɵļ�ֵ��
		System.out.println("��Ϊ3��Ӧ��ֵ��" + m1.get(3)); // ��ȡ������Ӧ��ֵ
		System.out.println("m1�Ƿ�Ϊ�գ�" + m1.isEmpty()); // ������ֵ������
		System.out.println("m1��ֵ��������" + m1.size()); // ������ֵ������
		System.out.println("m1�Ƿ��������" + m1.containsKey(1)); // �Ƿ����ĳ����
		System.out.println("m1�Ƿ����ֵ��" + m1.containsValue("two")); // �Ƿ����ĳ��ֵ

		m2.put(1, "һ");
		m2.put(2, "��");

		Map<Integer, String> m3 = new HashMap<Integer, String>();
		m3.putAll(m1); // ��һ��map����Ԫ�ظ��Ƶ���һ��map
		m3.putAll(m2); // ���ظ��ˣ�����滻�ɵļ�ֵ��
		System.out.println("m1:" + m1);
		System.out.println("m2:" + m2);
		System.out.println("m3:" + m3);

		m3.remove(3); // ɾ����ֵ��
		System.out.println("m3:" + m3);
		m3.clear(); // ���
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