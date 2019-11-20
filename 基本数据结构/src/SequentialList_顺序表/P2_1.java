//顺序表

package SequentialList_顺序表;

import java.util.Scanner;

public class P2_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i;
		SLType SL= new SLType();
		DATA pdata;
		String key;
		
		System.out.println("顺序表操作演示！");
		SL.SLInit(SL);
		System.out.println("初始化顺序表完成");
		
		Scanner input = new Scanner(System.in);
		
		do {
			System.out.print("请输入添加的节点（学号  姓名  年龄）：");
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
		System.out.println("顺序表中节点的顺序为：");
		SL.SLAll(SL);
		
		System.out.println("");
		System.out.print("要去取出的节点序号：");
		i = input.nextInt();
		pdata = SL.SLFindByNum(SL, i);
		if(pdata!=null) {
			System.out.println("第"+i+"个节点为：（"+pdata.key+","+pdata.name+","+pdata.age+"）");
		}
		
		
		System.out.print("\n要查找的节点的关键字：");
		key = input.next();
		i = SL.SLFindByCont(SL, key);
		pdata = SL.SLFindByNum(SL, i);
		if(pdata!=null) {
			System.out.println("第"+i+"个节点为：（"+pdata.key+","+pdata.name+","+pdata.age+"）");
		}
	}

}
