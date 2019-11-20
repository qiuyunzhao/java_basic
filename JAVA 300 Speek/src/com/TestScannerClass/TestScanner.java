package com.TestScannerClass;

import java.util.Scanner;

/**
 * 键盘输入
 * @author 邱云钊 
 * @version 2019/4/8
 */

public class TestScanner {

	public static void main(String[] args) {
		Scanner   scanner =  new Scanner(System.in);
        System.out.println("请输入名字：");
        String   name =  scanner.nextLine();
        System.out.println("请输入你的爱好：");
        String  favor = scanner.nextLine();
        System.out.println("请输入你的年龄：");
        int   age = scanner.nextInt();
         
        System.out.println("###############");
        System.out.println(name);
        System.out.println(favor);
        System.out.println("来到地球的天数："+age*365);
        System.out.println("离开地球的天数："+(92-age)*365);
        
	}

}
