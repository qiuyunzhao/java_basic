package Tree_��;

import java.util.Scanner;

class CBTType {
	String data;   //����Ԫ��
	CBTType left;  //�������������
	CBTType right; //�������������

	static final int MAXLEN = 20;
	static Scanner input = new Scanner(System.in);
	
	//��ʼ���������ĸ�
	CBTType InitTree() {
		CBTType node;
		if((node = new CBTType())!=null){
			System.out.println("������һ�����ڵ����ݣ�");
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
	
	//��ӽ�� ��һ�㴫���treeNodeΪ���ڵ㣩
	void AddTreeNode(CBTType treeNode) {
		CBTType pnode,parent;
		String data;
		int menusel;   //����������ҽ�������ݴ�
		
		if((pnode=new CBTType())!=null) {
			System.out.println("����������ڵ����ݣ�");
			pnode.data = input.next();
			pnode.left = null;
			pnode.right = null;
			
			System.out.println("����ýڵ�ĸ�������ݣ�");
			data = input.next();
			parent = TreeFindNode(treeNode,data);  //����ָ�����ݵĸ��ڵ�
			if(parent==null) {
				System.out.println("û���ҵ�����㣡");
				pnode=null;  //�ͷŴ����Ľ��
				return;
			}
			System.out.println("1 :��Ӹý�㵽������      2����Ӹý�㵽������");
			do {
				menusel = input.nextInt();  //����ѡ��
				if(menusel==1 || menusel==2) {
					if(parent==null) {
						System.out.println("�����ڸ���㣬�������ø����");
					}else {
						switch(menusel) {
						case 1:           //��ӵ�����
							if(parent.left!=null) {
								System.out.println("���㲻Ϊ�գ�");
							}else {
								parent.left = pnode;
							}
						break;
						case 2:          //��ӵ��ҽ��
							if(parent.right!=null) {
								System.out.println("�ҽ�㲻Ϊ�գ�");
							}else {
								parent.right = pnode;
							}
						break;
						default:
							System.out.println("��Ч������");
						}
					}
				}
			}while(menusel!=1 && menusel!=2);
		}
	}
	
	//���ҽ�� ��һ�㴫���treeNodeΪ���ڵ㣩
	CBTType TreeFindNode(CBTType treeNode,String data) {
		CBTType ptr;
		if(treeNode == null) {
			return null;
		}else {
			if(treeNode.data.equals(data)) {
				return treeNode;
			}else {
				if((ptr=TreeFindNode(treeNode.left,data))!=null) {    //���������ݹ����
					return ptr;
				}else if((ptr=TreeFindNode(treeNode.right,data))!=null) {
					return ptr;
				}else {
					return null;
				}
			}
		}
	}
	
	//��ȡ������
	CBTType TreeLeftNode(CBTType treeNode) {
		if(treeNode!=null) {
			return treeNode.left;
		}else {
			return null;
		}
	}
	
	//��ȡ������
	CBTType TreeRightNode(CBTType treeNode) {
		if(treeNode!=null) {
			return treeNode.right;
		}else {
			return null;
		}
	}
	
	//�жϿ��� ��һ�㴫���treeNodeΪ���ڵ㣩
	int TreeIsEmpty(CBTType treeNode) {
		if(treeNode!=null) {
			return 0;
		}else {
			return 1;
		}
	}
	
	//������������ ��һ�㴫���treeNodeΪ���ڵ㣩
	int TreeDepth(CBTType treeNode) {
		int depleft,depright;
		if(treeNode==null) {
			return 0;
		}else {
			depleft = TreeDepth(treeNode.left);    //��������ȣ��ݹ���ã�
			depright = TreeDepth(treeNode.right);  //��������ȣ��ݹ���ã�
			if(depleft>depright) {
				return depleft + 1;
			}else {
				return depright + 1;
			}
		}
	}
	
	//��ն�������һ�㴫���treeNodeΪ���ڵ㣩
	void ClearTree(CBTType treeNode) {
		if(treeNode!=null) {
			ClearTree(treeNode.left);     //������������ݹ���ã�
			ClearTree(treeNode.right);    //������������ݹ���ã�
			treeNode = null;
		}
	}
	
	//��ʾ�ڵ�����
	void TreeNodeData(CBTType p) {
		System.out.print(p.data+"\t");
	}
	
	//�������-ʹ��ѭ�����д���һ�㴫���treeNodeΪ���ڵ㣩
	void LevelTree(CBTType treeNode) {
		CBTType p;
		CBTType[] q = new CBTType[MAXLEN];      //����һ��˳��ջ
		int head = 0;
		int tail = 0;
		
		if(treeNode!=null) {
			tail = (tail+1) % MAXLEN;  //����ѭ�����ж�β���
			q[tail] = treeNode;        //���������������
		}
		
		while(head!=tail) {            //˵�����ܻ������ҽ��
			head = (head+1) % MAXLEN;  //����ѭ�����еĶ���Ԫ��
			p=q[head];                 //��ȡ����Ԫ��
			TreeNodeData(p);           //��ʾ����Ԫ��
			
			if(p.left!=null) {         //������������ִ�����
				tail = (tail+1) % MAXLEN;
				q[tail] = p.left;
			}
			
			if(p.right!=null) {         //������������ִ�����
				tail = (tail+1) % MAXLEN;
				q[tail] = p.right;
			}
		}
	}
	
	//������������ݹ飨һ�㴫���treeNodeΪ���ڵ㣩
	void DLRTree(CBTType treeNode) {
		if(treeNode != null) {
			TreeNodeData(treeNode);
			DLRTree(treeNode.left);
			DLRTree(treeNode.right);
		}
	}
	
	//������������ݹ飨һ�㴫���treeNodeΪ���ڵ㣩
	void LDRTree(CBTType treeNode) {
		if(treeNode != null) {
			LDRTree(treeNode.left);
			TreeNodeData(treeNode);
			LDRTree(treeNode.right);
		}		
	}
	
	//������������ݹ飨һ�㴫���treeNodeΪ���ڵ㣩
	void LRDTree(CBTType treeNode) {
		if(treeNode != null) {
			LRDTree(treeNode.left);
			LRDTree(treeNode.right);
			TreeNodeData(treeNode);
		}		
	}	
	
	
	
}
