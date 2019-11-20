package 装饰流;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

/**
 * 把Java对象转换为字节序列的过程称为对象的序列化。把字节序列恢复为Java对象的过程称为对象的反序列化。 对象序列化的作用有如下两种：
 * 1.持久化：把对象的字节序列永久地保存到硬盘上，通常存放在一个文件中。 2. 网络通信：在网络上传送对象的字节序列。
 * 
 * 对象流： ObjectOutputStream代表对象输出流，它的writeObject(Object
 * obj)方法可对参数指定的obj对象进行序列化，把得到的字节序列写到一个目标输出流中。
 * ObjectInputStream代表对象输入流，它的readObject()方法从一个源输入流中读取字节序列，再把它们反序列化为一个对象，并将其返回。
 * 
 * 1.先写出后读取 2.读取顺序必须与写出顺序一致 3.只有实现了Serializable接口的类的对象才能被序列化。
 * Serializable接口是一个空接口，只起到标记作用。
 */
public class ObjectInputStreamANDObjectOutputStream {

	public static void main(String[] args) {

		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		try {
			oos = new ObjectOutputStream(
					new BufferedOutputStream(new FileOutputStream("IO流资源/ObjectOutputStream.ser")));
			// 将如下数据写入到文件中
			oos.writeChar('a');
			oos.writeInt(10);
			oos.writeDouble(Math.random());
			oos.writeBoolean(true);
			oos.writeUTF("北京尚学堂"); // 写字符串
			// 写对象
			oos.writeObject("好好学习，天天向上");
			oos.writeObject(new Date());
			Person person = new Person(18, true, "高淇");
			oos.writeObject(person);

			oos.flush();// 手动刷新缓冲区：将流中数据写入到文件中

			ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream("IO流资源/ObjectOutputStream.ser")));// ObjectInputStream创建时"IO流资源/ObjectOutputStream.ser"必须已经存在
			System.out.println("char: " + ois.readChar());
			System.out.println("int: " + ois.readInt());
			System.out.println("double: " + ois.readDouble());
			System.out.println("boolean: " + ois.readBoolean());
			System.out.println("String: " + ois.readUTF());
			// 强转回原类型
			try {
				Object str = ois.readObject();
				if (str instanceof String) {
					System.out.println("StringObject: " + (String) str);
				}
				Object date = ois.readObject();
				if (date instanceof Date) {
					System.out.println("DateObject: " + (Date) date);
				}
				Object employee = ois.readObject();
				if (employee instanceof Person) {
					System.out.println("PersonObject: " + (Person) employee);
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (ois != null) {
				try {
					ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

}

// Person类实现Serializable接口后，Person对象才能被序列化
class Person implements Serializable {
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
