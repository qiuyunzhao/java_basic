package MergeSort_合并排序;

public class P4_7 {
	
	static final int SIZE = 15;
	
	static void mergeOne(int a[],int b[],int n,int len) {  // a[]待排序数组，b[]合并后数组，n元素个数，len子序列长度
		int e;
		int k;
		int i;
		int j;
		int s = 0;
		
		while(s+len<n) {
			e = s+2*len-1;
			if(e>=n) {
				e=n-1;
			}
			//相邻有序段合并
			k = s;
			i = s;
			j = s+len;
			
			while(i<s+len && j<=e) {      //如果两个有序表都未结束，循环比较
				if(a[i]<=a[j]) {
					b[k++] = a[i++];      //较小的元素复制到数组b中
				}else {
					b[k++] = a[j++];
				}
			}
			while(i<s+len){
				b[k++] = a[i++];          //未合并部分复制到数组b中
			}
			while(j<=e) {
				b[k++] = a[j++];
			}
			
			s = e+1;		             //下一对有序段中左段的开始下标	
		}
		if(s<n) {
			for(;s<n;s++) {
				b[s]= a[s];
			}
		}	
	}
	
	static void mergeSort(int a[],int n) {
		int h;
		int count = 0;       //排序步骤
		int len = 1;         //有序序列的长度
		int f=0;                 //标志
		
		int[] p = new int[n];
		
		while(len<n) {
			if(f==1) {                //交替在a和p之间合并
				mergeOne(p,a,n,len);  //p合并到a
			}else {
				mergeOne(a,p,n,len);  //a合并到p
			}
			len = len*2;
			f = 1-f;
			
			count++;
			System.out.print("第"+count+"步排序结果：");
			for(h=0;h<SIZE;h++) {
				System.out.print(" "+a[h]);
			}
			System.out.println("");
		}
		
		if(f==1) {     //如果进行了排序
			for(h=0;h<n;h++) {
				a[h]=p[h];
			}
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
		
		mergeSort(shuzu,SIZE);
		
		System.out.println("排序后的数组为：");
		for(i=0;i<SIZE;i++) {
			System.out.print(shuzu[i]+" ");
		}
		System.out.println("");
	}

}
