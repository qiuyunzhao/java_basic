package ������;

import java.util.Random;

public class TestRandom {

	public static void main(String[] args) {

		Random rand = new Random();
		
		//�������false����true
        System.out.println(rand.nextBoolean());
        
		//�������int��������Χ֮�ڵ���������
        System.out.println(rand.nextInt());
      //�������[0,10)֮���int���͵�����
        System.out.println(rand.nextInt(10));
        //�������[20,30)֮���int���͵�����
        System.out.println(20 + rand.nextInt(10));
      
        //�������[0,1)֮���float���͵�����
        System.out.println(rand.nextFloat());
        
        //�������[0,1)֮���double���͵�����
        System.out.println(rand.nextDouble());
        

        
        

	}

}
