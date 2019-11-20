package BubbleSort_冒泡排序;

public class P4_1 {
	
	static final int SIZE=10;
	
	//冒泡排序法    大数放到数组后边
	public static void bubbleSort(int[] a) {
		int tempt;
		for(int i=1;i<a.length;i++) {          //n个数需要n-1次排序
			for(int j=0;j<a.length-i;j++) {    //i次循环后最后i个数据已经排好
				if(a[j]>a[j+1]) {
					tempt = a[j];
					a[j] = a[j+1];
					a[j+1] = tempt;
				}
			}
			System.out.println("第"+i+"步排序结果：");
			for(int k=0;k<a.length;k++) {
				System.out.print(" "+a[k]);
			}
			System.out.println("");
		}
	}

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] shuzu = new int[SIZE];
		int i;
		
		for(i=0;i<SIZE;i++) {
			shuzu[i] = (int)(100+Math.random()*(100+1));
		}
		
		System.out.print("排序前的数组为：");
		for(i=0;i<SIZE;i++) {
			System.out.print(shuzu[i]+" ");
		}
		System.out.println("");
		
		bubbleSort(shuzu);
		System.out.print("排序后的数组为：");
		for(i=0;i<SIZE;i++) {
			System.out.print(shuzu[i]+" ");
		}
		System.out.println("");
	}

}
