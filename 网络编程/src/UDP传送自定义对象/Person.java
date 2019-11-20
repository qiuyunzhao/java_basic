package UDP�����Զ������;

import java.io.Serializable;

// Person��ʵ��Serializable�ӿں�Person������ܱ����л�
public class Person implements Serializable {
	// ������л�ID�����������Ƿ��ܹ��ɹ������л���
	private static final long serialVersionUID = 1L;
	private int age;
	private boolean isMan;
	private transient String name; // �����Բ��������л�

	public Person(int age, boolean isMan, String name) {
		super();
		this.age = age;
		this.isMan = isMan;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person [age=" + age + ", isMan=" + isMan + ", name=" + name + "]";
	}
}