package LinkedList_����;

import java.util.Scanner;

public class P2_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CLType node,head=null;
		CLType CL = new CLType();
		String key,findkey;
		Scanner input = new Scanner(System.in);
		
		System.out.println("������ԡ������������е����ݣ���ʽΪ���ؼ��� ���� ����");
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
		
		System.out.print("\n��ʾ����ڵ㣬�������λ�õĹؼ��֣�");
		findkey=input.next();
		System.out.println("�������ڵ�����ݣ��ؼ���  ����  ���䣩��");
		DATA2 nodeData = new DATA2();
		nodeData.key = input.next();
		nodeData.name = input.next();
		nodeData.age = input.nextInt();
		head = CL.CLInsertNode(head, findkey, nodeData);
		CL.CLAllNode(head);
		
		System.out.print("\n��ʾɾ����㣬����Ҫɾ�����Ĺؼ��֣�");
		key = input.next();
		CL.CLDeleteNode(head, key);
		CL.CLAllNode(head);
		
		System.out.print("\n��ʾ���б��в��ң�������ҹؼ��֣�");
		key = input.next();
		node = CL.CLFindNode(head, key);
		if(node!=null) {
			nodeData = node.nodeData;
			System.out.println("�ؼ���"+key+"��Ӧ�Ľ��Ϊ��"+nodeData.key+","+nodeData.name+","+nodeData.age+"��");
		}else {
			System.out.println("��������û���ҵ��ؼ���Ϊ"+key+"�Ľ�㣡");
		}
		
	}

}
