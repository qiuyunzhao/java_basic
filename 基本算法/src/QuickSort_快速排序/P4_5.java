package QuickSort_快速排序;

public class P4_5 {
	
	static final int SIZE = 18;
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

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int shuzu[] = new int[SIZE];
		int i;
		
		for(i=0;i<SIZE;i++) {
			shuzu[i] = (int)(100+Math.random()*(100+1));
		}
		
		System.out.println("排序前的数组为：");
		for(i=0;i<SIZE;i++) {
			System.out.print(shuzu[i]+" ");
		}
		System.out.println("");
		
		quickSort(shuzu,0,SIZE-1);
		
		System.out.println("排序后的数组为：");
		for(i=0;i<SIZE;i++) {
			System.out.print(shuzu[i]+" ");
		}
		System.out.println("");
	}

}

