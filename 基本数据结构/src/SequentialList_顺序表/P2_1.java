//˳���

package SequentialList_˳���;

import java.util.Scanner;

public class P2_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i;
		SLType SL= new SLType();
		DATA pdata;
		String key;
		
		System.out.println("˳��������ʾ��");
		SL.SLInit(SL);
		System.out.println("��ʼ��˳������");
		
		Scanner input = new Scanner(System.in);
		
		do {
			System.out.print("��������ӵĽڵ㣨ѧ��  ����  ���䣩��");
			DATA data = new DATA();
			data.key = input.next();
			data.name = input.next();
			data.age = input.nextInt();
			if(data.age != 0) {
				if(SL.SLAdd(SL, data)==0) {
					break;
				}
			}else {
				break;
			}
		}while(true);
		
		System.out.println("");
		System.out.println("˳����нڵ��˳��Ϊ��");
		SL.SLAll(SL);
		
		System.out.println("");
		System.out.print("Ҫȥȡ���Ľڵ���ţ�");
		i = input.nextInt();
		pdata = SL.SLFindByNum(SL, i);
		if(pdata!=null) {
			System.out.println("��"+i+"���ڵ�Ϊ����"+pdata.key+","+pdata.name+","+pdata.age+"��");
		}
		
		
		System.out.print("\nҪ���ҵĽڵ�Ĺؼ��֣�");
		key = input.next();
		i = SL.SLFindByCont(SL, key);
		pdata = SL.SLFindByNum(SL, i);
		if(pdata!=null) {
			System.out.println("��"+i+"���ڵ�Ϊ����"+pdata.key+","+pdata.name+","+pdata.age+"��");
		}
	}

}
