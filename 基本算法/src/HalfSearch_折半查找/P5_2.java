package HalfSearch_�۰����;

import java.util.Scanner;

public class P5_2 {
	
	static final int  N=15;
	
	//��������
	static void quickSort(int[] arr,int left,int right) {
		int t;                          //����ʱ��ʱ�洢����
		int ltemp = left;
		int rtemp = right;
		int f = arr[(ltemp+rtemp)/2];   //�ֽ�ֵ
		
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
			quickSort(arr,left,ltemp-1);  //�ݹ����
		}
		if(ltemp<right) {
			quickSort(arr,rtemp+1,right); //�ݹ����
		}
	}
	
	//�۰����
	static int searchFun(int a[],int n,int x) {
		int mid;
		int low = 0;
		int high = n-1;
		
		while(low<=high) {
			mid = (low+high)/2;
			if(a[mid]==x) {
				return mid;         //�ҵ�
			}else if(a[mid]>x){
				high = mid-1;
			}else {
				low = mid+1;
			}
		}
		return -1;                 //û���ҵ�
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x,n,i;
		int[] shuzu = new int[N];
		
		for(i=0;i<N;i++) {
			shuzu[i] = (int)(100+Math.random()*(100+1));       //��������
		}
		
		System.out.println("�۰�����㷨��ʾ!");
		System.out.println("����ǰ�������У�");
		for(i=0;i<N;i++) {
			System.out.print(" "+shuzu[i]);
		}
		System.out.print("\n\n");
		
		quickSort(shuzu,0,N-1);		
		System.out.println("������������У�");
		for(i=0;i<N;i++) {
			System.out.print(" "+shuzu[i]);
		}
		System.out.println("");
		
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
