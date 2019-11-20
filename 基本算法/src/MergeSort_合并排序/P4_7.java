package MergeSort_�ϲ�����;

public class P4_7 {
	
	static final int SIZE = 15;
	
	static void mergeOne(int a[],int b[],int n,int len) {  // a[]���������飬b[]�ϲ������飬nԪ�ظ�����len�����г���
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
			//��������κϲ�
			k = s;
			i = s;
			j = s+len;
			
			while(i<s+len && j<=e) {      //������������δ������ѭ���Ƚ�
				if(a[i]<=a[j]) {
					b[k++] = a[i++];      //��С��Ԫ�ظ��Ƶ�����b��
				}else {
					b[k++] = a[j++];
				}
			}
			while(i<s+len){
				b[k++] = a[i++];          //δ�ϲ����ָ��Ƶ�����b��
			}
			while(j<=e) {
				b[k++] = a[j++];
			}
			
			s = e+1;		             //��һ�����������εĿ�ʼ�±�	
		}
		if(s<n) {
			for(;s<n;s++) {
				b[s]= a[s];
			}
		}	
	}
	
	static void mergeSort(int a[],int n) {
		int h;
		int count = 0;       //������
		int len = 1;         //�������еĳ���
		int f=0;                 //��־
		
		int[] p = new int[n];
		
		while(len<n) {
			if(f==1) {                //������a��p֮��ϲ�
				mergeOne(p,a,n,len);  //p�ϲ���a
			}else {
				mergeOne(a,p,n,len);  //a�ϲ���p
			}
			len = len*2;
			f = 1-f;
			
			count++;
			System.out.print("��"+count+"����������");
			for(h=0;h<SIZE;h++) {
				System.out.print(" "+a[h]);
			}
			System.out.println("");
		}
		
		if(f==1) {     //�������������
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
		
		System.out.println("����ǰ������Ϊ��");
		for(i=0;i<SIZE;i++) {
			System.out.print(shuzu[i]+" ");
		}
		System.out.println("");
		
		mergeSort(shuzu,SIZE);
		
		System.out.println("����������Ϊ��");
		for(i=0;i<SIZE;i++) {
			System.out.print(shuzu[i]+" ");
		}
		System.out.println("");
	}

}
