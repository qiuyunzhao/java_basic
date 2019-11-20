package com.TestArray;

import java.util.Arrays;

public class TestArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] s = { "阿里", "尚学堂", "京东", "搜狐", "网易" };
		String[] sBak = new String[6];
		
		System.out.println("***************Test1***************");
		System.arraycopy(s, 0, sBak, 0, s.length);	//数组拷贝
		//数组遍历
		for (int i = 0; i < sBak.length; i++) {
			System.out.print(sBak[i] + "\t");
		}
		System.out.println();
		for (String temp : sBak) {
            System.out.print(temp + "\t");
        }
		System.out.println();
		
		System.out.println("***************Test2***************");
		System.out.println(s); // 打印数组引用的值；
        System.out.println(Arrays.toString(s)); // 打印数组元素的值；
        System.out.println(Arrays.toString(removeElementFromArray(s,1))); //删除数组中指定索引处的元素，后边元素前移
        
        System.out.println("***************Test3***************");
        int[] a = {1,2,323,23,543,12,59};
        System.out.println(Arrays.toString(a));
        
        Arrays.sort(a);	//数组排序
        System.out.println(Arrays.toString(a));
        
        //使用二分法查找，必须先对数组进行排序;返回排序后新的索引位置,若未找到返回负数。
        System.out.println("该元素的索引："+Arrays.binarySearch(a, 12)); 

        Arrays.fill(a, 2, 4, 100);  //将2到3索引的元素替换为100;
        System.out.println(Arrays.toString(a));
        
        System.out.println("***************Test4***************");
//	      Object存储表格数据       
//        1001  "高淇"   18   "讲师"   "2006-2-14"
//        1002  "高小七"  19   "助教"   "2007-10-10"
//        1003  "高小琴"  20  "班主任"   "2008-5-5"
        
        Object[] a1 = {1001,"高淇",18,"讲师","2006-2-14"};
        Object[] a2 = {1002,"高小七",19,"助教","2007-10-10"};
        Object[] a3 = {1003,"高小琴",20,"班主任","2008-5-5"};
        Object[][]  emps = new Object[3][];
        emps[0] = a1;
        emps[1] = a2;
        emps[2] = a3;
        System.out.println(Arrays.toString(emps[0]));
        System.out.println(Arrays.toString(emps[1]));
        System.out.println(Arrays.toString(emps[2])); 
	}
	
	
	
	//删除数组中指定索引处的元素，后边元素前移，并返回原数组
	public static String[] removeElementFromArray(String[] s, int index) {
		System.arraycopy(s, index+1, s, index, s.length-index-1);
		s[s.length-1] = null;
		return s;
	}
	
	
}
