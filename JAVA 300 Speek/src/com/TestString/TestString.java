package com.TestString;

/** String------���ɱ��ַ�����
 	ȫ���ַ���������(String Pool)
 	ȫ���ַ����������д�ŵ����������������ɺ�浽String Pool�еģ���ÿ��VM��ֻ��һ�ݣ���ŵ����ַ�������������ֵ(�ڶ��������ַ�������ʵ��)��
 *
 */
public class TestString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("*********Test1*********");
//		���ַ������бȽ�ʱʹ�� equals() ����������ϵͳʵ��String��Ļ������⣬ʹ��  == ���׳���������
		String str1 = "abc";
		String str2 = new String("def");
		String str3 = "abc";
		String str4 = str2.intern();
		String str5 = "def";
		System.out.println(str1 == str3);// true
		System.out.println(str2 == str5);// false
		System.out.println(str2 == str4);// false
		System.out.println(str4 == str5);// true
		
		System.out.println("*********Test2*********");
        String s1 = "core Java";
        String s2 = "Core Java";
        System.out.println(s1.charAt(3));//��ȡ�±�Ϊ3���ַ�
        System.out.println(s2.length());//�ַ����ĳ���
        System.out.println(s1.equals(s2));//�Ƚ������ַ��������Ƿ����
        System.out.println(s1.equalsIgnoreCase(s2));//�Ƚ������ַ��������Դ�Сд��
        System.out.println(s1.indexOf("Java"));//�ַ���s1���Ƿ����Java
        System.out.println(s1.indexOf("apple"));//�ַ���s1���Ƿ����apple
        String s = s1.replace(' ', '&');//��s1�еĿո��滻��&
        System.out.println("result is :" + s);

		System.out.println("*********Test3*********");
        String string = "";
        String string1 = "How are you?";
        System.out.println(string1.startsWith("How"));//�Ƿ���How��ͷ
        System.out.println(string1.endsWith("you"));//�Ƿ���you��β
        
        string = string1.substring(4);//��ȡ���ַ��������±�Ϊ4�Ŀ�ʼ���ַ�����βΪֹ
        System.out.println(string);
        string = string1.substring(4, 7);//��ȡ���ַ������±�[4, 7) ������7

        String string2 = "  How old are you!! ";
        string = string2.trim();//ȥ���ַ�����β�Ŀո�ע�⣺�м�Ŀո���ȥ��
        System.out.println(string);
        System.out.println(string2);//��ΪString�ǲ��ɱ��ַ���������s2����
        
        System.out.println(string);
        string = string1.toLowerCase();//תСд
        System.out.println(string);
        string = string1.toUpperCase();//ת��д
        System.out.println(string);
        
        System.out.println("*********Test3*********");
        String[] str = string.split(" ");	//���ַ����ָ�
        for(String str10:str) {
        	System.out.println(str10);
        }
        
        String string3 = "2019:03:21-11:11:11";
        str = string3.split(":", 2);		//ȡ�ַ���ͷ��Ԫ��
        for(String str11:str) {
        	System.out.println(str11);
        }
	}

}
