package �����÷�_1;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo01 {

	public static void main(String[] args) {

		test1();
		test2();
		test3();
		test4();
	}

	/**
	 * ����������ʽ����Ļ����÷�
	 */
	private static void test1() {
		System.out.println("------test1------");
		// ������ַ�����asfsdf23323���Ƿ����ָ����������ʽ��\w+
		Pattern p = Pattern.compile("\\w+"); // ���ʽ����(������ʽ�еġ�/��������Ҫ��Ϊ��//��)
		Matcher m = p.matcher("asfsdf2&&3323"); // ����Matcher����
		
		 boolean yesorno = m.matches(); //���Խ������ַ��������ģʽƥ��
		 System.out.println(yesorno);

		while (m.find()) {	//�÷���ɨ����������У��������ģʽƥ�����һ��������
			System.out.println(m.group()); // group(),group(0)����ƥ���������ʽ�����ַ���
			System.out.println(m.group(0));
		}
	}
	
	
	/**
	 * ����������ʽ�����з���Ĵ���
	 */
	private static void test2() {
		System.out.println("------test2------");
		
		Pattern p = Pattern.compile("([a-z]+)([0-9]+)"); //���ʽ����
		Matcher m = p.matcher("aa232**ssd445*sds223"); //����Matcher����
		 
		while(m.find()){
		System.out.println(m.group()); //group(),group(0)ƥ����ʽ��([a-z]+)([0-9]+)
		System.out.println(m.group(1)); //ƥ�� ���ʽ�� [a-z]+
		System.out.println(m.group(2)); //ƥ�� ���ʽ�� [0-9]+
		}  
	}
	
	
	/**
	 * ����������ʽ������滻����
	 */
	private static void test3() {
		System.out.println("------test3------");
		
		Pattern p = Pattern.compile("[0-9]");
		Matcher m = p.matcher("aa232**ssd445*sds223");
		
		//�滻
		String newStr = m.replaceAll("#"); //���ı�ԭ�ַ������������ַ���
		System.out.println(newStr);  
	}
	
 
	/**
	 * ����������ʽ����ķָ��ַ����Ĳ���
	 */
	private static void test4() {
		System.out.println("------test4------");
		
		String str = "a232b4334c3434";
		String[] arrs = str.split("\\d+");
		System.out.println(Arrays.toString(arrs));
	}

}
