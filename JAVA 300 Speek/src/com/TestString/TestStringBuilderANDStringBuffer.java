package com.TestString;

/**
 * StringBuffer��StringBuilder�ǳ����ƣ�������ɱ���ַ�����,���ǳ�����AbstractStringBuilder�����࣬��������һģһ����
 * 
 * 1. StringBuffer JDK1.0�汾�ṩ���࣬�̰߳�ȫ�����߳�ͬ����飬 Ч�ʽϵ͡�
 * 2. StringBuilder JDK1.5�汾�ṩ���࣬�̲߳���ȫ�������߳�ͬ����飬���Ч�ʽϸ�(������ø���)��
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
            sb.append((char) ('a' + i));//׷�ӵ����ַ�
        }
        System.out.println(sb);//ֱ�����
        System.out.println(sb.toString());//ת����String���
        sb.append(", I can sing my abc!");//׷���ַ���
        System.out.println(sb);

        sb.setCharAt(9, '��');	//����ĳ���ַ�
        System.out.println(sb);
        
        String sb1 = sb.substring(8, 19);//��ȡ�Ӵ�
        System.out.println(sb1);
	}

	
	static void StringBuffer() {
        System.out.println("*************StringBuffer*************");
        StringBuffer sb2 = new StringBuffer("�л����񹲺͹�");
        
        sb2.insert(0, "��").insert(0, "��");//�����ַ���
        System.out.println(sb2);
        
        sb2.delete(0, 2);//ɾ�����ַ���
        System.out.println(sb2);
        sb2.deleteCharAt(0).deleteCharAt(0);//ɾ��ĳ���ַ�
        
        System.out.println(sb2.charAt(0));//��ȡĳ���ַ�
        
        System.out.println(sb2.reverse());//�ַ�������
	}

	static void errorExample() {
		 
        /**ʹ��StringBuilder�����ַ�����ƴ��*/
        StringBuilder sb4 = new StringBuilder("");
        long num3 = Runtime.getRuntime().freeMemory();
        long time3 = System.currentTimeMillis();
        //��ȷ����
        for (int i = 0; i < 5000; i++) {
            sb4.append(i);
        }
        long num4 = Runtime.getRuntime().freeMemory();
        long time4 = System.currentTimeMillis();
        System.out.println("StringBuilderռ���ڴ� : " + (num3 - num4));
        System.out.println("StringBuilderռ��ʱ�� : " + (time4 - time3));
        
        
        /**ʹ��String�����ַ�����ƴ��*/
        String str8 = "";
        //������ʹ��StringBuilderƴ��, ����ÿ��ѭ����������һ��StringBuilder����
        long num1 = Runtime.getRuntime().freeMemory();//��ȡϵͳʣ���ڴ�ռ�
        long time1 = System.currentTimeMillis();//��ȡϵͳ�ĵ�ǰʱ��
        
        /**����������������������ܶ���󣬷�����ÿ�����ʿͻ������һ�Σ��ܿ쵼�·���������*/
        for (int i = 0; i < 5000; i++) {
            str8 = str8 + i;//�൱�ڲ�����10000������
        }
        long num2 = Runtime.getRuntime().freeMemory();
        long time2 = System.currentTimeMillis();
        System.out.println("Stringռ���ڴ� : " + (num1 - num2));
        System.out.println("Stringռ��ʱ�� : " + (time2 - time1));
        
	}
	
}
