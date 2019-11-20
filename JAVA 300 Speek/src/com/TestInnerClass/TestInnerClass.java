package com.TestInnerClass;


/**
 * 
内部类的作用：
      1. 内部类提供了更好的封装。只能让外部类直接访问，不允许同一个包中的其他类直接访问。
      2. 内部类可以直接访问外部类的私有属性，内部类被当成其外部类的成员。 但外部类不能访问内部类的内部属性。
      3. 接口只是解决了多重继承的部分问题，而内部类使得多重继承的解决方案变得更加完整。
内部类的使用场合：
      1. 由于内部类提供了更好的封装特性，并且可以很方便的访问外部类的属性。所以，在只为外部类提供服务的情况下可以优先考虑使用内部类。
      2.  使用内部类间接实现多继承：每个内部类都能独立地继承一个类或者实现某些接口，所以无论外部类是否已经继承了某个类或者实现了某些接口，对于内部类没有任何影响。
 *
 *
 *非静态内部类(外部类里使用非静态内部类和平时使用其他类没什么不同)
      1. 非静态内部类必须寄存在一个外部类对象里。因此，如果有一个非静态内部类对象那么一定存在对应的外部类对象。非静态内部类对象单独属于外部类的某个对象。
      2. 非静态内部类可以直接访问外部类的成员，但是外部类不能直接访问非静态内部类成员。
      3. 非静态内部类不能有静态方法、静态属性和静态初始化块。
      4. 外部类的静态方法、静态代码块不能访问非静态内部类，包括不能使用非静态内部类定义变量、创建实例。
      5. 成员变量访问要点：
        1). 内部类里方法的局部变量：变量名。
        2). 内部类属性：this.变量名。
        3). 外部类属性：外部类名.this.变量名。
        4). 内部类的访问：  a. 外部类中定义内部类：new Inner()  b. 外部类以外的地方使用非静态内部类： Outer.Inner  varname = new Outer().new Inner()。

 *
 *
 * 静态内部类
      1. 定义方式：	static  class   ClassName {  //类体	}
      2. 使用要点：
       1). 当一个静态内部类对象存在，并不一定存在对应的外部类对象。 因此，静态内部类的实例方法不能直接访问外部类的实例方法。
       2). 静态内部类看做外部类的一个静态成员。 因此，外部类的方法中可以通过：“静态内部类.名字”的方式访问静态内部类的静态成员，通过 new 静态内部类()访问静态内部类的实例。
 
 *
 *
 *匿名内部类
          适合那种只需要使用一次的类。比如：键盘监听操作等等。
	语法：
		new  父类构造器(实参类表) \实现接口 () {
           //匿名内部类类体！
		}
 */
public class TestInnerClass {

	public static void main(String[] args) {

		//非静态内部类
		//先创建外部类实例，然后使用该外部类实例创建内部类实例
        Outer.Inner inner = new Outer().new Inner();
        inner.show();
        
        Outer outer = new Outer();
        Outer.Inner inn = outer.new Inner();
        inn.show();

        //静态内部类
        //通过 new 外部类名.内部类名() 来创建内部类对象(并不一定存在对应的外部类对象)
        Outer.StaticInner statiIinner = new Outer.StaticInner();
        statiIinner.show();
        
        //匿名内部类
        TestAnnoymousInnerClass test01 = new TestAnnoymousInnerClass();
        test01.test(new AA() {		//这里创建好的对象会传递给86行 test(AA aa)方法中的aa

			@Override
			public void aa() {
				// TODO Auto-generated method stub
				System.out.println("匿名内部类,这里只是声明类体");//
			}
        	
        });
        
        
        
	}
}

/**
 * 匿名内部类
 */
interface AA{
	void aa();
}

class TestAnnoymousInnerClass{
	public void test(AA aa) {
		System.out.println();
		System.out.println("匿名内部类实际是在这里调用的" );
		aa.aa();
	}
}

/** 外部类Outer */
class Outer {
	private int age = 10;

	public void show() {
		System.out.println(age);// 10
	}

	/**非静态内部类Inner*/
    public class Inner {
        //内部类中可以声明与外部类同名的属性与方法
        private int age = 20;
        public void show(){
        	int age = 30;
        	System.out.println("内部类方法里的局部变量age:" + age);// 30
            System.out.println("内部类的成员变量age:" + this.age);// 20
            System.out.println("外部类的成员变量age:" + Outer.this.age);// 10
        }
    }
    
    /**静态内部类StaticInner 
                相当于外部类的一个静态成员*/
    static class StaticInner {
    	private String name = "静态内部类变量";
    	public void show() {
    		String name = "局部变量";
    		System.out.println();
    		System.out.println("内部类方法里的局部变量age:" + name);// 30
    		System.out.println("内部类的成员变量age:" + this.name);// 20
    	}
    	
    }    
     
}



