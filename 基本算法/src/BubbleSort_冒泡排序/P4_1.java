package BubbleSort_ð������;

public class P4_1 {
	
	static final int SIZE=10;
	
	//ð������    �����ŵ�������
	public static void bubbleSort(int[] a) {
		int tempt;
		for(int i=1;i<a.length;i++) {          //n������Ҫn-1������
			for(int j=0;j<a.length-i;j++) {    //i��ѭ�������i�������Ѿ��ź�
				if(a[j]>a[j+1]) {
					tempt = a[j];
					a[j] = a[j+1];
					a[j+1] = tempt;
				}
			}
			System.out.println("��"+i+"����������");
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
		
		System.out.print("����ǰ������Ϊ��");
		for(i=0;i<SIZE;i++) {
			System.out.print(shuzu[i]+" ");
		}
		System.out.println("");
		
		bubbleSort(shuzu);
		System.out.print("����������Ϊ��");
		for(i=0;i<SIZE;i++) {
			System.out.print(shuzu[i]+" ");
		}
		System.out.println("");
	}

}
