package com.TestString;

/**
 * StringBuffer和StringBuilder非常类似，均代表可变的字符序列,都是抽象类AbstractStringBuilder的子类，方法几乎一模一样。
 * 
 * 1. StringBuffer JDK1.0版本提供的类，线程安全，做线程同步检查， 效率较低。
 * 2. StringBuilder JDK1.5版本提供的类，线程不安全，不做线程同步检查，因此效率较高(建议采用该类)。
 */
public class TestStringBuilderANDStringBuffer {

	public static void main(String[] args) {
		
		testStringBuilder();
		StringBuffer();
		errorExample();
	}
	
	static void testStringBuilder() {
		System.out.println("*************StringBuilder*************");
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < 7; i++) {
            sb.append((char) ('a' + i));//追加单个字符
        }
        System.out.println(sb);//直接输出
        System.out.println(sb.toString());//转换成String输出
        sb.append(", I can sing my abc!");//追加字符串
        System.out.println(sb);

        sb.setCharAt(9, '我');	//设置某个字符
        System.out.println(sb);
        
        String sb1 = sb.substring(8, 19);//获取子串
        System.out.println(sb1);
	}

	
	static void StringBuffer() {
        System.out.println("*************StringBuffer*************");
        StringBuffer sb2 = new StringBuffer("中华人民共和国");
        
        sb2.insert(0, "爱").insert(0, "我");//插入字符串
        System.out.println(sb2);
        
        sb2.delete(0, 2);//删除子字符串
        System.out.println(sb2);
        sb2.deleteCharAt(0).deleteCharAt(0);//删除某个字符
        
        System.out.println(sb2.charAt(0));//获取某个字符
        
        System.out.println(sb2.reverse());//字符串逆序
	}

	static void errorExample() {
		 
        /**使用StringBuilder进行字符串的拼接*/
        StringBuilder sb4 = new StringBuilder("");
        long num3 = Runtime.getRuntime().freeMemory();
        long time3 = System.currentTimeMillis();
        //正确做法
        for (int i = 0; i < 5000; i++) {
            sb4.append(i);
        }
        long num4 = Runtime.getRuntime().freeMemory();
        long time4 = System.currentTimeMillis();
        System.out.println("StringBuilder占用内存 : " + (num3 - num4));
        System.out.println("StringBuilder占用时间 : " + (time4 - time3));
        
        
        /**使用String进行字符串的拼接*/
        String str8 = "";
        //本质上使用StringBuilder拼接, 但是每次循环都会生成一个StringBuilder对象
        long num1 = Runtime.getRuntime().freeMemory();//获取系统剩余内存空间
        long time1 = System.currentTimeMillis();//获取系统的当前时间
        
        /**错误做法，这样做会产生很多对象，服务器每个访问客户会产生一次，很快导致服务器崩溃*/
        for (int i = 0; i < 5000; i++) {
            str8 = str8 + i;//相当于产生了10000个对象
        }
        long num2 = Runtime.getRuntime().freeMemory();
        long time2 = System.currentTimeMillis();
        System.out.println("String占用内存 : " + (num1 - num2));
        System.out.println("String占用时间 : " + (time2 - time1));
        
	}
	
}
