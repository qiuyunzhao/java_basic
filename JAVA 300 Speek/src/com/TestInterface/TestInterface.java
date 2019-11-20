package com.TestInterface;

/**
 * ������ʽ�� [�������η�] interface �ӿ��� [extends ���ӿ�1�����ӿ�2��] { �������壻 �������壻 }
 * 
 * ����ӿڵ���ϸ˵���� 
 *  1. �������η���ֻ����public��Ĭ�ϡ�
 *  2. �ӿ�����������������ͬ�������ơ� 
 *  3. extends���ӿڿ��Զ�̳С�
 *  4. * �������ӿ��е�����ֻ���ǳ��������ǣ�public static final ���Ρ���дҲ�ǡ� 5. �������ӿ��еķ���ֻ���ǣ�public abstract�� ʡ�ԵĻ���Ҳ��public abstract��
 * 
 * Ҫ��
 *  1. ����ͨ��implements��ʵ�ֽӿ��еĹ淶�� 
 *  2. �ӿڲ��ܴ���ʵ�������ǿ������������ñ������͡�
 *  3. һ����ʵ���˽ӿڣ�����ʵ�ֽӿ������еķ�����������Щ����ֻ����public�ġ�
 *  4. JDK1.7֮ǰ���ӿ���ֻ�ܰ�����̬���������󷽷�����������ͨ���ԡ����췽������ͨ������ 
 *  5. JDK1.8�󣬽ӿ��а�����ͨ�ľ�̬������
 */

public class TestInterface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Volant volant = new AngelBaby();
        volant.fly();
        System.out.println(Volant.FLY_HIGHT);
         
        Honest honest = new GoodMan();
        honest.helpOther();
	}

}

/**
 * ���нӿ�
 */
interface Volant {
	int FLY_HIGHT = 100; // ���ǣ�public static final���͵ģ�
	void fly(); // ���ǣ�public abstract void fly();
}

/**
 * �����ӿ�
 */
interface Honest {
	void helpOther();
}

/**
 * һ���ӿڼ̳ж���ӿ�
 */
interface Angel extends Volant,Honest{
	void speek();
}

/**
 * û��ʵ�����нӿڵ����з����������Ϊ������
 */
abstract class Bird implements Volant, Honest {
	@Override
	public void fly() {
		// TODO Auto-generated method stub
		System.out.println("����С���һ�ɣ�");
	}
}

class AngelBaby implements Volant, Honest {

	@Override
	public void helpOther() {
		// TODO Auto-generated method stub
		System.out.println("�������̹���·��");
	}

	@Override
	public void fly() {
		// TODO Auto-generated method stub
		System.out.println("������ʹ������������");
	}

}

class GoodMan implements Honest {
	public void helpOther() {
		System.out.println("�������̹���·��");
	}
}

class BirdMan implements Volant {
	public void fly() {
		System.out.println("�������ˣ����ڷɣ�");
	}
}
