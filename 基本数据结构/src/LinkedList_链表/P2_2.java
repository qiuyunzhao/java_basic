package LinkedList_链表;

import java.util.Scanner;

public class P2_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CLType node,head=null;
		CLType CL = new CLType();
		String key,findkey;
		Scanner input = new Scanner(System.in);
		
		System.out.println("链表测试。先输入链表中的数据，格式为：关键字 姓名 年龄");
		do {
			DATA2 nodeData = new DATA2();
			nodeData.key = input.next();
			if(nodeData.key.equals("0")) {
				break;
			}else {
				nodeData.name = input.next();
				nodeData.age = input.nextInt();
				head = CL.CLAddEnd(head, nodeData);
			}
		}while(true);
		CL.CLAllNode(head);
		
		System.out.print("\n演示插入节点，输入插入位置的关键字：");
		findkey=input.next();
		System.out.println("输入插入节点的数据（关键字  姓名  年龄）：");
		DATA2 nodeData = new DATA2();
		nodeData.key = input.next();
		nodeData.name = input.next();
		nodeData.age = input.nextInt();
		head = CL.CLInsertNode(head, findkey, nodeData);
		CL.CLAllNode(head);
		
		System.out.print("\n演示删除结点，输入要删除结点的关键字：");
		key = input.next();
		CL.CLDeleteNode(head, key);
		CL.CLAllNode(head);
		
		System.out.print("\n演示在列表中查找，输入查找关键字：");
		key = input.next();
		node = CL.CLFindNode(head, key);
		if(node!=null) {
			nodeData = node.nodeData;
			System.out.println("关键字"+key+"对应的结点为（"+nodeData.key+","+nodeData.name+","+nodeData.age+"）");
		}else {
			System.out.println("在链表中没有找到关键字为"+key+"的结点！");
		}
		
	}

}
