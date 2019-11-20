package com.TestString;

/** String------不可变字符序列
 	全局字符串常量池(String Pool)
 	全局字符串常量池中存放的内容是在类加载完成后存到String Pool中的，在每个VM中只有一份，存放的是字符串常量的引用值(在堆中生成字符串对象实例)。
 *
 */
public class TestString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("*********Test1*********");
//		对字符串进行比较时使用 equals() 方法，由于系统实现String类的机制特殊，使用  == 容易出各种问题
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
        System.out.println(s1.charAt(3));//提取下标为3的字符
        System.out.println(s2.length());//字符串的长度
        System.out.println(s1.equals(s2));//比较两个字符串内容是否相等
        System.out.println(s1.equalsIgnoreCase(s2));//比较两个字符串（忽略大小写）
        System.out.println(s1.indexOf("Java"));//字符串s1中是否包含Java
        System.out.println(s1.indexOf("apple"));//字符串s1中是否包含apple
        String s = s1.replace(' ', '&');//将s1中的空格替换成&
        System.out.println("result is :" + s);

		System.out.println("*********Test3*********");
        String string = "";
        String string1 = "How are you?";
        System.out.println(string1.startsWith("How"));//是否以How开头
        System.out.println(string1.endsWith("you"));//是否以you结尾
        
        string = string1.substring(4);//提取子字符串：从下标为4的开始到字符串结尾为止
        System.out.println(string);
        string = string1.substring(4, 7);//提取子字符串：下标[4, 7) 不包括7

        String string2 = "  How old are you!! ";
        string = string2.trim();//去除字符串首尾的空格。注意：中间的空格不能去除
        System.out.println(string);
        System.out.println(string2);//因为String是不可变字符串，所以s2不变
        
        System.out.println(string);
        string = string1.toLowerCase();//转小写
        System.out.println(string);
        string = string1.toUpperCase();//转大写
        System.out.println(string);
        
        System.out.println("*********Test3*********");
        String[] str = string.split(" ");	//将字符串分割
        for(String str10:str) {
        	System.out.println(str10);
        }
        
        String string3 = "2019:03:21-11:11:11";
        str = string3.split(":", 2);		//取字符串头部元素
        for(String str11:str) {
        	System.out.println(str11);
        }
	}

}
