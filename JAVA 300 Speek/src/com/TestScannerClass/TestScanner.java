package com.TestScannerClass;

import java.util.Scanner;

/**
 * ��������
 * @author ������ 
 * @version 2019/4/8
 */

public class TestScanner {

	public static void main(String[] args) {
		Scanner   scanner =  new Scanner(System.in);
        System.out.println("���������֣�");
        String   name =  scanner.nextLine();
        System.out.println("��������İ��ã�");
        String  favor = scanner.nextLine();
        System.out.println("������������䣺");
        int   age = scanner.nextInt();
         
        System.out.println("###############");
        System.out.println(name);
        System.out.println(favor);
        System.out.println("���������������"+age*365);
        System.out.println("�뿪�����������"+(92-age)*365);
        
	}

}
