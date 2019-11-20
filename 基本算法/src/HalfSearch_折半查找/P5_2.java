package HalfSearch_折半查找;

import java.util.Scanner;

public class P5_2 {
	
	static final int  N=15;
	
	//快速排序
	static void quickSort(int[] arr,int left,int right) {
		int t;                          //交换时临时存储变量
		int ltemp = left;
		int rtemp = right;
		int f = arr[(ltemp+rtemp)/2];   //分界值
		
		while(ltemp<rtemp) {
			while(arr[ltemp]<f) {
				++ltemp;
			}
			while(arr[rtemp]>f) {
				--rtemp;
			}
			if(ltemp<=rtemp) {
				t = arr[ltemp];
				arr[ltemp] = arr[rtemp];
				arr[rtemp] = t;
				--rtemp;
				++ltemp;
			}
		}
		if(ltemp == rtemp) {
			ltemp++;
		}
		
		if(left<rtemp) {
			quickSort(arr,left,ltemp-1);  //递归调用
		}
		if(ltemp<right) {
			quickSort(arr,rtemp+1,right); //递归调用
		}
	}
	
	//折半查找
	static int searchFun(int a[],int n,int x) {
		int mid;
		int low = 0;
		int high = n-1;
		
		while(low<=high) {
			mid = (low+high)/2;
			if(a[mid]==x) {
				return mid;         //找到
			}else if(a[mid]>x){
				high = mid-1;
			}else {
				low = mid+1;
			}
		}
		return -1;                 //没有找到
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x,n,i;
		int[] shuzu = new int[N];
		
		for(i=0;i<N;i++) {
			shuzu[i] = (int)(100+Math.random()*(100+1));       //产生数组
		}
		
		System.out.println("折半查找算法演示!");
		System.out.println("排序前数据序列：");
		for(i=0;i<N;i++) {
			System.out.print(" "+shuzu[i]);
		}
		System.out.print("\n\n");
		
		quickSort(shuzu,0,N-1);		
		System.out.println("排序后数据序列：");
		for(i=0;i<N;i++) {
			System.out.print(" "+shuzu[i]);
		}
		System.out.println("");
		
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
