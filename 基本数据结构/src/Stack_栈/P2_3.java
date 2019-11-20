package Stack_栈;

import java.util.Scanner;

public class P2_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackType st = new StackType(); //用于初始化栈
		DATA3 data1 = new DATA3();      //用于出栈保存数据
		
		StackType stack = st.STInit();  //初始化		
		Scanner input = new Scanner(System.in);
		
		System.out.println("入栈操作：");
		System.out.println("输入年龄 年龄进行入栈操作：");
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
		System.out.println("出栈操作：按任意非0键进行出栈操作：");
		temp = input.next();
		while(!temp.equals("0")) {
			data1 = st.PopST(stack);
			System.out.println("出栈的数据是（"+data1.name+","+data1.age+")");
			temp = input.next();
		}
		System.out.println("测试结束！");
		st.STFree(stack);
		
	}

}
