package Stack_ջ;

import java.util.Scanner;

public class P2_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackType st = new StackType(); //���ڳ�ʼ��ջ
		DATA3 data1 = new DATA3();      //���ڳ�ջ��������
		
		StackType stack = st.STInit();  //��ʼ��		
		Scanner input = new Scanner(System.in);
		
		System.out.println("��ջ������");
		System.out.println("�������� ���������ջ������");
		do {
			DATA3 data = new DATA3();
			data.name = input.next();
			if(data.name.equals("0")) {
				break;
			}else {
				data.age = input.nextInt();
				st.PushST(stack, data);
			}
		}while(true);
		
		String temp = "1";
		System.out.println("��ջ�������������0�����г�ջ������");
		temp = input.next();
		while(!temp.equals("0")) {
			data1 = st.PopST(stack);
			System.out.println("��ջ�������ǣ�"+data1.name+","+data1.age+")");
			temp = input.next();
		}
		System.out.println("���Խ�����");
		st.STFree(stack);
		
	}

}
