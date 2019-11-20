package insertionSort_��������;

public class P4_3 {
	
	static final int SIZE = 10;
	
	static void insertionSort(int[] a) {
		int i,j,t,h;
		for(i=1;i<a.length;i++) {
			t = a[i];                         //���������
			j = i-1;
			while(j>=0 && t<a[j]) {           //���αȽϣ��ȴ��������������������
				a[j+1] = a[j];
				j--;
			}
			a[j+1] = t;                       //��Ҫ��������λ��
			
			System.out.print("��"+i+"����������");
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
		for(i=0;i<SIZE;i++){
			shuzu[i] = (int)(100+Math.random()*(100+1));   //��ʼ������
		}
		
		System.out.println("����ǰ�����飺");
		for(i=0;i<SIZE;i++) {
			System.out.print(shuzu[i]+" ");
		}
		System.out.println("");
		
		insertionSort(shuzu);
		
		System.out.println("���������飺");
		for(i=0;i<SIZE;i++) {
			System.out.print(shuzu[i]+" ");
		}
		System.out.println("");
	}

}
