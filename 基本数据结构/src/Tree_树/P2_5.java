package Tree_��;

import java.util.Scanner;

public class P2_5 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CBTType root = null;   //ָ����������ڵ������
		int menusel;
		CBTType t = new CBTType();
		root = t.InitTree();    //���ø�Ԫ��
		
//		static Scanner input = new Scanner(System.in);
		
		//��ӽ��
		do {
			System.out.println("��ѡ��˵���Ӷ������Ľڵ�");
			System.out.println("0   �˳� ��   1  ��Ӷ������ڵ�");
			menusel = CBTType.input.nextInt();
			switch(menusel) {
				case 1:
					t.AddTreeNode(root);
					break;
				case 0:
					break;
				default:
			}
		}while(menusel!=0);
		
		//����
		do {
			System.out.println("��ѡ��˵�����������������0��ʾ�˳���");
			System.out.println("1.�������DLR\t 2.�������LDR\t 3.�������LRD\t 4.�������");
			menusel = CBTType.input.nextInt();
			switch(menusel) {
				case 0:
					break;
				case 1:
					System.out.println("��������Ľ����");
					t.DLRTree(root);
					System.out.println("");
					break;
				case 2:
					System.out.println("��������Ľ����");
					t.LDRTree(root);
					System.out.println("");
					break;
				case 3:
					System.out.println("��������Ľ����");
					t.LRDTree(root);
					System.out.println("");
					break;	
				case 4:
					System.out.println("��������Ľ����");
					t.LevelTree(root);
					System.out.println("");
					break;
				default:
			}
		}while(menusel!=0);
		
		//���
		System.out.println("���������Ϊ��"+t.TreeDepth(root));
		t.ClearTree(root);
		root = null;
	}

}
