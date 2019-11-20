package Queue_队列;

import java.util.Scanner;

public class P2_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SQType st = new SQType();
		DATA4 data1;         //存放出栈数据
		
		Scanner input = new Scanner(System.in);
		
		SQType stack = st.SQTypeInit();
		System.out.println("入队列操作：");
		System.out.println("请输入 姓名 年龄 进行入队列操作：");
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
		System.out.println("出队列操作：按任意非0键进行出栈操作：");
		temp = input.next();
		while(!temp.equals("0")) {
			data1 = st.OutSQType(stack);
			System.out.println("出队列的数据是 （"+data1.name+","+data1.age+"）");
			temp = input.next();
		}
		System.out.println("测试结束！");
		st.SQTypeFree(stack);
	}

}
