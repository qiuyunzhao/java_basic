package Queue_����;

import java.util.Scanner;

public class P2_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SQType st = new SQType();
		DATA4 data1;         //��ų�ջ����
		
		Scanner input = new Scanner(System.in);
		
		SQType stack = st.SQTypeInit();
		System.out.println("����в�����");
		System.out.println("������ ���� ���� ��������в�����");
		do {
			DATA4 data = new DATA4();
			data.name = input.next();
			data.age = input.nextInt();
			if(data.name.equals("0")) {
				break;
			}else {
				st.InSQType(stack, data);
			}
		}while(true);
		
		String temp = "1";
		System.out.println("�����в������������0�����г�ջ������");
		temp = input.next();
		while(!temp.equals("0")) {
			data1 = st.OutSQType(stack);
			System.out.println("�����е������� ��"+data1.name+","+data1.age+"��");
			temp = input.next();
		}
		System.out.println("���Խ�����");
		st.SQTypeFree(stack);
	}

}
