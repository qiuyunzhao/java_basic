package װ����;

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
 * ��Java����ת��Ϊ�ֽ����еĹ��̳�Ϊ��������л������ֽ����лָ�ΪJava����Ĺ��̳�Ϊ����ķ����л��� �������л����������������֣�
 * 1.�־û����Ѷ�����ֽ��������õر��浽Ӳ���ϣ�ͨ�������һ���ļ��С� 2. ����ͨ�ţ��������ϴ��Ͷ�����ֽ����С�
 * 
 * �������� ObjectOutputStream������������������writeObject(Object
 * obj)�����ɶԲ���ָ����obj����������л����ѵõ����ֽ�����д��һ��Ŀ��������С�
 * ObjectInputStream�������������������readObject()������һ��Դ�������ж�ȡ�ֽ����У��ٰ����Ƿ����л�Ϊһ�����󣬲����䷵�ء�
 * 
 * 1.��д�����ȡ 2.��ȡ˳�������д��˳��һ�� 3.ֻ��ʵ����Serializable�ӿڵ���Ķ�����ܱ����л���
 * Serializable�ӿ���һ���սӿڣ�ֻ�𵽱�����á�
 */
public class ObjectInputStreamANDObjectOutputStream {

	public static void main(String[] args) {

		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		try {
			oos = new ObjectOutputStream(
					new BufferedOutputStream(new FileOutputStream("IO����Դ/ObjectOutputStream.ser")));
			// ����������д�뵽�ļ���
			oos.writeChar('a');
			oos.writeInt(10);
			oos.writeDouble(Math.random());
			oos.writeBoolean(true);
			oos.writeUTF("������ѧ��"); // д�ַ���
			// д����
			oos.writeObject("�ú�ѧϰ����������");
			oos.writeObject(new Date());
			Person person = new Person(18, true, "���");
			oos.writeObject(person);

			oos.flush();// �ֶ�ˢ�»�����������������д�뵽�ļ���

			ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream("IO����Դ/ObjectOutputStream.ser")));// ObjectInputStream����ʱ"IO����Դ/ObjectOutputStream.ser"�����Ѿ�����
			System.out.println("char: " + ois.readChar());
			System.out.println("int: " + ois.readInt());
			System.out.println("double: " + ois.readDouble());
			System.out.println("boolean: " + ois.readBoolean());
			System.out.println("String: " + ois.readUTF());
			// ǿת��ԭ����
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

// Person��ʵ��Serializable�ӿں�Person������ܱ����л�
class Person implements Serializable {
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
