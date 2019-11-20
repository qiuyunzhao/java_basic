package Tree_树;

import java.util.Scanner;

class CBTType {
	String data;   //数据元素
	CBTType left;  //左子树结点引用
	CBTType right; //右子树结点引用

	static final int MAXLEN = 20;
	static Scanner input = new Scanner(System.in);
	
	//初始化二叉树的根
	CBTType InitTree() {
		CBTType node;
		if((node = new CBTType())!=null){
			System.out.println("请输入一个根节点数据：");
			node.data = input.next();
			node.left = null;
			node.right = null;
			if(node != null) {
				return node;
			}else {
				return null;
			}
		}
		return null;
	}
	
	//添加结点 （一般传入的treeNode为根节点）
	void AddTreeNode(CBTType treeNode) {
		CBTType pnode,parent;
		String data;
		int menusel;   //插入左结点或右结点输入暂存
		
		if((pnode=new CBTType())!=null) {
			System.out.println("输入二叉树节点数据：");
			pnode.data = input.next();
			pnode.left = null;
			pnode.right = null;
			
			System.out.println("输入该节点的父结点数据：");
			data = input.next();
			parent = TreeFindNode(treeNode,data);  //查找指定数据的父节点
			if(parent==null) {
				System.out.println("没有找到父结点！");
				pnode=null;  //释放创建的结点
				return;
			}
			System.out.println("1 :添加该结点到左子树      2：添加该结点到右子树");
			do {
				menusel = input.nextInt();  //输入选项
				if(menusel==1 || menusel==2) {
					if(parent==null) {
						System.out.println("不存在父结点，请先设置父结点");
					}else {
						switch(menusel) {
						case 1:           //添加到左结点
							if(parent.left!=null) {
								System.out.println("左结点不为空！");
							}else {
								parent.left = pnode;
							}
						break;
						case 2:          //添加到右结点
							if(parent.right!=null) {
								System.out.println("右结点不为空！");
							}else {
								parent.right = pnode;
							}
						break;
						default:
							System.out.println("无效参数！");
						}
					}
				}
			}while(menusel!=1 && menusel!=2);
		}
	}
	
	//查找结点 （一般传入的treeNode为根节点）
	CBTType TreeFindNode(CBTType treeNode,String data) {
		CBTType ptr;
		if(treeNode == null) {
			return null;
		}else {
			if(treeNode.data.equals(data)) {
				return treeNode;
			}else {
				if((ptr=TreeFindNode(treeNode.left,data))!=null) {    //向左子树递归查找
					return ptr;
				}else if((ptr=TreeFindNode(treeNode.right,data))!=null) {
					return ptr;
				}else {
					return null;
				}
			}
		}
	}
	
	//获取左子树
	CBTType TreeLeftNode(CBTType treeNode) {
		if(treeNode!=null) {
			return treeNode.left;
		}else {
			return null;
		}
	}
	
	//获取右子树
	CBTType TreeRightNode(CBTType treeNode) {
		if(treeNode!=null) {
			return treeNode.right;
		}else {
			return null;
		}
	}
	
	//判断空树 （一般传入的treeNode为根节点）
	int TreeIsEmpty(CBTType treeNode) {
		if(treeNode!=null) {
			return 0;
		}else {
			return 1;
		}
	}
	
	//计算二叉树深度 （一般传入的treeNode为根节点）
	int TreeDepth(CBTType treeNode) {
		int depleft,depright;
		if(treeNode==null) {
			return 0;
		}else {
			depleft = TreeDepth(treeNode.left);    //左子树深度（递归调用）
			depright = TreeDepth(treeNode.right);  //右子树深度（递归调用）
			if(depleft>depright) {
				return depleft + 1;
			}else {
				return depright + 1;
			}
		}
	}
	
	//清空二叉树（一般传入的treeNode为根节点）
	void ClearTree(CBTType treeNode) {
		if(treeNode!=null) {
			ClearTree(treeNode.left);     //清空左子树（递归调用）
			ClearTree(treeNode.right);    //清空右子树（递归调用）
			treeNode = null;
		}
	}
	
	//显示节点数据
	void TreeNodeData(CBTType p) {
		System.out.print(p.data+"\t");
	}
	
	//按层遍历-使用循环队列处理（一般传入的treeNode为根节点）
	void LevelTree(CBTType treeNode) {
		CBTType p;
		CBTType[] q = new CBTType[MAXLEN];      //定义一个顺序栈
		int head = 0;
		int tail = 0;
		
		if(treeNode!=null) {
			tail = (tail+1) % MAXLEN;  //计算循环队列对尾序号
			q[tail] = treeNode;        //二叉树根进入队列
		}
		
		while(head!=tail) {            //说明可能会有左右结点
			head = (head+1) % MAXLEN;  //计算循环队列的队首元素
			p=q[head];                 //获取队首元素
			TreeNodeData(p);           //显示队首元素
			
			if(p.left!=null) {         //若存在左子树执行入队
				tail = (tail+1) % MAXLEN;
				q[tail] = p.left;
			}
			
			if(p.right!=null) {         //若存在右子树执行入队
				tail = (tail+1) % MAXLEN;
				q[tail] = p.right;
			}
		}
	}
	
	//先序遍历——递归（一般传入的treeNode为根节点）
	void DLRTree(CBTType treeNode) {
		if(treeNode != null) {
			TreeNodeData(treeNode);
			DLRTree(treeNode.left);
			DLRTree(treeNode.right);
		}
	}
	
	//中序遍历——递归（一般传入的treeNode为根节点）
	void LDRTree(CBTType treeNode) {
		if(treeNode != null) {
			LDRTree(treeNode.left);
			TreeNodeData(treeNode);
			LDRTree(treeNode.right);
		}		
	}
	
	//后序遍历——递归（一般传入的treeNode为根节点）
	void LRDTree(CBTType treeNode) {
		if(treeNode != null) {
			LRDTree(treeNode.left);
			LRDTree(treeNode.right);
			TreeNodeData(treeNode);
		}		
	}	
	
	
	
}
