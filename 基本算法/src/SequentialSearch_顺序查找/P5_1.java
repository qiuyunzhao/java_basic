package SequentialSearch_顺序查找;

import java.util.Scanner;

public class P5_1 {
	
	static final int N=15;
    
	static int searchFun(int a[],int n,int x) {     		//顺序查找函数
		int i ;
		int f = -1;
		for(i=0;i<n;i++){
			if(x==a[i]) {
				f=i;
				break;
			}
		}
		return f;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x,n,i;
		int[] shuzu = new int[N];
		
		for(i=0;i<N;i++) {
			shuzu[i] = (int)(100+Math.random()*(100+1));       //产生数组
		}
		
		System.out.println("顺序查找算法演示!");
		System.out.println("数据序列：");
		for(i=0;i<N;i++) {
			System.out.print(" "+shuzu[i]);
		}
		System.out.print("\n\n");
		
		System.out.print("输入要查找的数：");
		Scanner input = new Scanner(System.in);
		x = input.nextInt();
		
		n = searchFun(shuzu,N,x);
		if(n<0) {
			System.out.println("没有找到数据："+x);
		}else {
			System.out.println("数据:"+ x +"位于数组的第"+(n+1)+"个元素处。");
		}
	}

}
