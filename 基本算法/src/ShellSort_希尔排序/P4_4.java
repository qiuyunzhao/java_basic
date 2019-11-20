package ShellSort_希尔排序;

public class P4_4 {

	static final int SIZE=10;
	
	static void shellSort(int[] a) {
		int i,j,h;
		int r,temp;    //r:每组元素个数
		int x = 0;     //记录第几次排序
		
		for(r=a.length/2;r>=1;r/=2) {       //划分组进行排序
			//插入法思想
			for(i=r;i<a.length;i++) {
				temp = a[i];
				j = i-r;
				while(j>=0 && temp<a[j]) {
					a[j+r] = a[j];
					j-=r;
				}
				a[j+r] = temp;
			}
			
			x++;
			System.out.print("第"+x+"步排序结果：");
			for(h=0;h<a.length;h++) {
				System.out.print(" "+a[h]);
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
		
		System.out.println("排序前的数组为：");
		for(i=0;i<SIZE;i++) {
			System.out.print(shuzu[i]+" ");
		}
		System.out.println("");
		
		shellSort(shuzu);
		
		System.out.println("排序后的数组为：");
		for(i=0;i<SIZE;i++) {
			System.out.print(shuzu[i]+" ");
		}
		System.out.println("");
	}

}
