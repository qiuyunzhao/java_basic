package Tree_树;

import java.util.Scanner;

public class P2_5 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CBTType root = null;   //指向二叉树根节点的引用
		int menusel;
		CBTType t = new CBTType();
		root = t.InitTree();    //设置根元素
		
//		static Scanner input = new Scanner(System.in);
		
		//添加结点
		do {
			System.out.println("请选择菜单添加二叉树的节点");
			System.out.println("0   退出 ；   1  添加二叉树节点");
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
		
		//遍历
		do {
			System.out.println("请选择菜单遍历二叉树，输入0表示退出：");
			System.out.println("1.先序遍历DLR\t 2.中序遍历LDR\t 3.后序遍历LRD\t 4.按层遍历");
			menusel = CBTType.input.nextInt();
			switch(menusel) {
				case 0:
					break;
				case 1:
					System.out.println("先序遍历的结果：");
					t.DLRTree(root);
					System.out.println("");
					break;
				case 2:
					System.out.println("中序遍历的结果：");
					t.LDRTree(root);
					System.out.println("");
					break;
				case 3:
					System.out.println("后序遍历的结果：");
					t.LRDTree(root);
					System.out.println("");
					break;	
				case 4:
					System.out.println("按层遍历的结果：");
					t.LevelTree(root);
					System.out.println("");
					break;
				default:
			}
		}while(menusel!=0);
		
		//深度
		System.out.println("二叉树深度为："+t.TreeDepth(root));
		t.ClearTree(root);
		root = null;
	}

}
