package com.TestAbstractClass;

/**
 * ���󷽷� 
 * ʹ��abstract���εķ�����û�з����壬ֻ���������������һ�֡��淶�������Ǹ����������Ҫ�����󷽷��ṩ�����ʵ�֡�
 * ������
 * �������󷽷�������ǳ����ࡣͨ��abstract��������淶��Ȼ��Ҫ��������붨�����ʵ�֡�ͨ�������࣬���ǾͿ��������ϸ������������ƣ�ʹ����֮�����ͨ�á�
 * 
 * �������ʹ��Ҫ��:
     1. �г��󷽷�����ֻ�ܶ���ɳ�����
     2. �����಻��ʵ��������������new��ʵ���������ࡣ
     3. ��������԰������ԡ����������췽�������ǹ��췽����������newʵ����ֻ��������������á�
     4. ������ֻ���������̳С�
     5. ���󷽷����뱻����ʵ��
 */
abstract class Animal {
	private String name;
	private int age;
	
	abstract public void shout();
	
	public void run() {
		System.out.println("ƴ�����ܣ�");
	}
}

class Dog extends Animal{
	//�������ʵ�ָ���ĳ��󷽷�������������
	@Override
	public void shout() {
		// TODO Auto-generated method stub
		System.out.println("��������");
	}
	
	public void seeDoor(){
        System.out.println("������....");
    }	
}

//���Գ�����
public class TestAbstractClass {
  public static void main(String[] args) {
      Animal a = new Dog();	//��̬
      Dog d = (Dog) a;		//ǿ��ת��
      a.shout();
      d.seeDoor();
  }
}