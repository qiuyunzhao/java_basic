package UDP传送自定义对象;

import java.io.Serializable;

// Person类实现Serializable接口后，Person对象才能被序列化
public class Person implements Serializable {
	// 添加序列化ID，它决定着是否能够成功反序列化！
	private static final long serialVersionUID = 1L;
	private int age;
	private boolean isMan;
	private transient String name; // 该属性不进行序列化

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