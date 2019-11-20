package HeapSort_������;

public class P4_6 {
	
	static final int SIZE = 10;
	
	static void heapSort(int a[],int n) {
		int i,j,h,k;
		int t;
		//a[0]-a[n-1]���ɶѽṹ
		for(i=n/2-1;i>=0;i--) {    //���ڵ����
			while(2*i+1<n) {       
				j = 2*i+1;
				if((j+1)<n) {
					if(a[j]<a[j+1]) {
						j++;
					}
				}
				if(a[i]<a[j]) {
					t=a[i];
					a[i]=a[j];
					a[j]=t;
					i=j;
				}
				else {
					break;
				}
			}
		}
		//����ѽṹ
		System.out.print("ԭ���ݹ��ɵĶѣ�");
		for(h=0;h<n;h++) {
			System.out.print(" "+a[h]);
		}
		System.out.println("");
		
		for(i=n-1;i>0;i--) {
			t = a[0];
			a[0] = a[i];
			a[i] = t;
			k = 0;
			while(2*k+1<i) {
				j=2*k+1;
				if((j+1)<i) {
					if(a[j]<a[j+1]) {
						j++;
					}
				}
				if(a[k]<a[j]) {
					t = a[k];
					a[k] = a[j];
					a[j] = t;
					k = j;
				}
				else {
					break;
				}
			}
			
			System.out.print("��"+(n-i)+"����������");
			for(h=0;h<n;h++) {
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
		
		System.out.println("����ǰ������Ϊ��");
		for(i=0;i<SIZE;i++) {
			System.out.print(shuzu[i]+" ");
		}
		System.out.println("");
		
		heapSort(shuzu,SIZE);
		
		System.out.println("����������Ϊ��");
		for(i=0;i<SIZE;i++) {
			System.out.print(shuzu[i]+" ");
		}
		System.out.println("");
		
	}

}
