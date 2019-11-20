package 常用类;

import java.util.Random;

public class TestRandom {

	public static void main(String[] args) {

		Random rand = new Random();
		
		//随机生成false或者true
        System.out.println(rand.nextBoolean());
        
		//随机生成int类型允许范围之内的整型数据
        System.out.println(rand.nextInt());
      //随机生成[0,10)之间的int类型的数据
        System.out.println(rand.nextInt(10));
        //随机生成[20,30)之间的int类型的数据
        System.out.println(20 + rand.nextInt(10));
      
        //随机生成[0,1)之间的float类型的数据
        System.out.println(rand.nextFloat());
        
        //随机生成[0,1)之间的double类型的数据
        System.out.println(rand.nextDouble());
        

        
        

	}

}
