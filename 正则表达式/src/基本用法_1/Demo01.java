package 基本用法_1;

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
	 * 测试正则表达式对象的基本用法
	 */
	private static void test1() {
		System.out.println("------test1------");
		// 在这个字符串：asfsdf23323，是否符合指定的正则表达式：\w+
		Pattern p = Pattern.compile("\\w+"); // 表达式对象(正则表达式中的“/”在这里要变为“//”)
		Matcher m = p.matcher("asfsdf2&&3323"); // 创建Matcher对象
		
		 boolean yesorno = m.matches(); //尝试将整个字符序列与该模式匹配
		 System.out.println(yesorno);

		while (m.find()) {	//该方法扫描输入的序列，查找与该模式匹配的下一个子序列
			System.out.println(m.group()); // group(),group(0)都是匹配整个表达式的子字符串
			System.out.println(m.group(0));
		}
	}
	
	
	/**
	 * 测试正则表达式对象中分组的处理
	 */
	private static void test2() {
		System.out.println("------test2------");
		
		Pattern p = Pattern.compile("([a-z]+)([0-9]+)"); //表达式对象
		Matcher m = p.matcher("aa232**ssd445*sds223"); //创建Matcher对象
		 
		while(m.find()){
		System.out.println(m.group()); //group(),group(0)匹配表达式：([a-z]+)([0-9]+)
		System.out.println(m.group(1)); //匹配 表达式： [a-z]+
		System.out.println(m.group(2)); //匹配 表达式： [0-9]+
		}  
	}
	
	
	/**
	 * 测试正则表达式对象的替换操作
	 */
	private static void test3() {
		System.out.println("------test3------");
		
		Pattern p = Pattern.compile("[0-9]");
		Matcher m = p.matcher("aa232**ssd445*sds223");
		
		//替换
		String newStr = m.replaceAll("#"); //不改变原字符串，返回新字符串
		System.out.println(newStr);  
	}
	
 
	/**
	 * 测试正则表达式对象的分割字符串的操作
	 */
	private static void test4() {
		System.out.println("------test4------");
		
		String str = "a232b4334c3434";
		String[] arrs = str.split("\\d+");
		System.out.println(Arrays.toString(arrs));
	}

}
