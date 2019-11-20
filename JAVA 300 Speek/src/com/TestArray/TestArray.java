package com.TestArray;

import java.util.Arrays;

public class TestArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] s = { "����", "��ѧ��", "����", "�Ѻ�", "����" };
		String[] sBak = new String[6];
		
		System.out.println("***************Test1***************");
		System.arraycopy(s, 0, sBak, 0, s.length);	//���鿽��
		//�������
		for (int i = 0; i < sBak.length; i++) {
			System.out.print(sBak[i] + "\t");
		}
		System.out.println();
		for (String temp : sBak) {
            System.out.print(temp + "\t");
        }
		System.out.println();
		
		System.out.println("***************Test2***************");
		System.out.println(s); // ��ӡ�������õ�ֵ��
        System.out.println(Arrays.toString(s)); // ��ӡ����Ԫ�ص�ֵ��
        System.out.println(Arrays.toString(removeElementFromArray(s,1))); //ɾ��������ָ����������Ԫ�أ����Ԫ��ǰ��
        
        System.out.println("***************Test3***************");
        int[] a = {1,2,323,23,543,12,59};
        System.out.println(Arrays.toString(a));
        
        Arrays.sort(a);	//��������
        System.out.println(Arrays.toString(a));
        
        //ʹ�ö��ַ����ң������ȶ������������;����������µ�����λ��,��δ�ҵ����ظ�����
        System.out.println("��Ԫ�ص�������"+Arrays.binarySearch(a, 12)); 

        Arrays.fill(a, 2, 4, 100);  //��2��3������Ԫ���滻Ϊ100;
        System.out.println(Arrays.toString(a));
        
        System.out.println("***************Test4***************");
//	      Object�洢�������       
//        1001  "���"   18   "��ʦ"   "2006-2-14"
//        1002  "��С��"  19   "����"   "2007-10-10"
//        1003  "��С��"  20  "������"   "2008-5-5"
        
        Object[] a1 = {1001,"���",18,"��ʦ","2006-2-14"};
        Object[] a2 = {1002,"��С��",19,"����","2007-10-10"};
        Object[] a3 = {1003,"��С��",20,"������","2008-5-5"};
        Object[][]  emps = new Object[3][];
        emps[0] = a1;
        emps[1] = a2;
        emps[2] = a3;
        System.out.println(Arrays.toString(emps[0]));
        System.out.println(Arrays.toString(emps[1]));
        System.out.println(Arrays.toString(emps[2])); 
	}
	
	
	
	//ɾ��������ָ����������Ԫ�أ����Ԫ��ǰ�ƣ�������ԭ����
	public static String[] removeElementFromArray(String[] s, int index) {
		System.arraycopy(s, index+1, s, index, s.length-index-1);
		s[s.length-1] = null;
		return s;
	}
	
	
}
