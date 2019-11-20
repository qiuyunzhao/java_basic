package �쳣;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRuntimeException {

	public static void main(String[] args) {
		
		int b=0;
        if(b!=0){
            System.out.println(1/b);	//ArithmeticException
        }

        String str=null;
        if(str!=null){
            System.out.println(str.charAt(0));	//NullPointerException
        }
        
        Animal a = new Dog();
        if (a instanceof Cat) {	
            Cat c = (Cat) a;	//ClassCastException
        }
        
        
        int[] arr = new int[5];
        int i = 5;
        if (i < arr.length) {
            System.out.println(arr[i]);	//ArrayIndexOutOfBoundsException
        }
        
        
        String str1 = "1234abcf";
        Pattern p = Pattern.compile("^\\d+$");
        Matcher m = p.matcher(str1);
        if (m.matches()) { // ���strƥ��������ֵ�������ʽ,�Ż�ת��
            System.out.println(Integer.parseInt(str1));	//NumberFormatException
        }
        
	}

}

class Animal{
    
}
class Dog extends Animal{
     
}
class Cat extends Animal{
     
}