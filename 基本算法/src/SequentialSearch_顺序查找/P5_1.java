package SequentialSearch_˳�����;

import java.util.Scanner;

public class P5_1 {
	
	static final int N=15;
    
	static int searchFun(int a[],int n,int x) {     		//˳����Һ���
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
			shuzu[i] = (int)(100+Math.random()*(100+1));       //��������
		}
		
		System.out.println("˳������㷨��ʾ!");
		System.out.println("�������У�");
		for(i=0;i<N;i++) {
			System.out.print(" "+shuzu[i]);
		}
		System.out.print("\n\n");
		
		System.out.print("����Ҫ���ҵ�����");
		Scanner input = new Scanner(System.in);
		x = input.nextInt();
		
		n = searchFun(shuzu,N,x);
		if(n<0) {
			System.out.println("û���ҵ����ݣ�"+x);
		}else {
			System.out.println("����:"+ x +"λ������ĵ�"+(n+1)+"��Ԫ�ش���");
		}
	}

}
