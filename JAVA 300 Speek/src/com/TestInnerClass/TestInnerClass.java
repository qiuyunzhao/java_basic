package com.TestInnerClass;


/**
 * 
�ڲ�������ã�
      1. �ڲ����ṩ�˸��õķ�װ��ֻ�����ⲿ��ֱ�ӷ��ʣ�������ͬһ�����е�������ֱ�ӷ��ʡ�
      2. �ڲ������ֱ�ӷ����ⲿ���˽�����ԣ��ڲ��౻�������ⲿ��ĳ�Ա�� ���ⲿ�಻�ܷ����ڲ�����ڲ����ԡ�
      3. �ӿ�ֻ�ǽ���˶��ؼ̳еĲ������⣬���ڲ���ʹ�ö��ؼ̳еĽ��������ø���������
�ڲ����ʹ�ó��ϣ�
      1. �����ڲ����ṩ�˸��õķ�װ���ԣ����ҿ��Ժܷ���ķ����ⲿ������ԡ����ԣ���ֻΪ�ⲿ���ṩ���������¿������ȿ���ʹ���ڲ��ࡣ
      2.  ʹ���ڲ�����ʵ�ֶ�̳У�ÿ���ڲ��඼�ܶ����ؼ̳�һ�������ʵ��ĳЩ�ӿڣ����������ⲿ���Ƿ��Ѿ��̳���ĳ�������ʵ����ĳЩ�ӿڣ������ڲ���û���κ�Ӱ�졣
 *
 *
 *�Ǿ�̬�ڲ���(�ⲿ����ʹ�÷Ǿ�̬�ڲ����ƽʱʹ��������ûʲô��ͬ)
      1. �Ǿ�̬�ڲ������Ĵ���һ���ⲿ��������ˣ������һ���Ǿ�̬�ڲ��������ôһ�����ڶ�Ӧ���ⲿ����󡣷Ǿ�̬�ڲ�����󵥶������ⲿ���ĳ������
      2. �Ǿ�̬�ڲ������ֱ�ӷ����ⲿ��ĳ�Ա�������ⲿ�಻��ֱ�ӷ��ʷǾ�̬�ڲ����Ա��
      3. �Ǿ�̬�ڲ��಻���о�̬��������̬���Ժ;�̬��ʼ���顣
      4. �ⲿ��ľ�̬��������̬����鲻�ܷ��ʷǾ�̬�ڲ��࣬��������ʹ�÷Ǿ�̬�ڲ��ඨ�����������ʵ����
      5. ��Ա��������Ҫ�㣺
        1). �ڲ����﷽���ľֲ���������������
        2). �ڲ������ԣ�this.��������
        3). �ⲿ�����ԣ��ⲿ����.this.��������
        4). �ڲ���ķ��ʣ�  a. �ⲿ���ж����ڲ��ࣺnew Inner()  b. �ⲿ������ĵط�ʹ�÷Ǿ�̬�ڲ��ࣺ Outer.Inner  varname = new Outer().new Inner()��

 *
 *
 * ��̬�ڲ���
      1. ���巽ʽ��	static  class   ClassName {  //����	}
      2. ʹ��Ҫ�㣺
       1). ��һ����̬�ڲ��������ڣ�����һ�����ڶ�Ӧ���ⲿ����� ��ˣ���̬�ڲ����ʵ����������ֱ�ӷ����ⲿ���ʵ��������
       2). ��̬�ڲ��࿴���ⲿ���һ����̬��Ա�� ��ˣ��ⲿ��ķ����п���ͨ��������̬�ڲ���.���֡��ķ�ʽ���ʾ�̬�ڲ���ľ�̬��Ա��ͨ�� new ��̬�ڲ���()���ʾ�̬�ڲ����ʵ����
 
 *
 *
 *�����ڲ���
          �ʺ�����ֻ��Ҫʹ��һ�ε��ࡣ���磺���̼��������ȵȡ�
	�﷨��
		new  ���๹����(ʵ�����) \ʵ�ֽӿ� () {
           //�����ڲ������壡
		}
 */
public class TestInnerClass {

	public static void main(String[] args) {

		//�Ǿ�̬�ڲ���
		//�ȴ����ⲿ��ʵ����Ȼ��ʹ�ø��ⲿ��ʵ�������ڲ���ʵ��
        Outer.Inner inner = new Outer().new Inner();
        inner.show();
        
        Outer outer = new Outer();
        Outer.Inner inn = outer.new Inner();
        inn.show();

        //��̬�ڲ���
        //ͨ�� new �ⲿ����.�ڲ�����() �������ڲ������(����һ�����ڶ�Ӧ���ⲿ�����)
        Outer.StaticInner statiIinner = new Outer.StaticInner();
        statiIinner.show();
        
        //�����ڲ���
        TestAnnoymousInnerClass test01 = new TestAnnoymousInnerClass();
        test01.test(new AA() {		//���ﴴ���õĶ���ᴫ�ݸ�86�� test(AA aa)�����е�aa

			@Override
			public void aa() {
				// TODO Auto-generated method stub
				System.out.println("�����ڲ���,����ֻ����������");//
			}
        	
        });
        
        
        
	}
}

/**
 * �����ڲ���
 */
interface AA{
	void aa();
}

class TestAnnoymousInnerClass{
	public void test(AA aa) {
		System.out.println();
		System.out.println("�����ڲ���ʵ������������õ�" );
		aa.aa();
	}
}

/** �ⲿ��Outer */
class Outer {
	private int age = 10;

	public void show() {
		System.out.println(age);// 10
	}

	/**�Ǿ�̬�ڲ���Inner*/
    public class Inner {
        //�ڲ����п����������ⲿ��ͬ���������뷽��
        private int age = 20;
        public void show(){
        	int age = 30;
        	System.out.println("�ڲ��෽����ľֲ�����age:" + age);// 30
            System.out.println("�ڲ���ĳ�Ա����age:" + this.age);// 20
            System.out.println("�ⲿ��ĳ�Ա����age:" + Outer.this.age);// 10
        }
    }
    
    /**��̬�ڲ���StaticInner 
                �൱���ⲿ���һ����̬��Ա*/
    static class StaticInner {
    	private String name = "��̬�ڲ������";
    	public void show() {
    		String name = "�ֲ�����";
    		System.out.println();
    		System.out.println("�ڲ��෽����ľֲ�����age:" + name);// 30
    		System.out.println("�ڲ���ĳ�Ա����age:" + this.name);// 20
    	}
    	
    }    
     
}



