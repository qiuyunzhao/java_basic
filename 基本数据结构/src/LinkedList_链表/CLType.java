package LinkedList_����;

class CLType {
	DATA2 nodeData = new DATA2();
	CLType nextNode;
	
	//׷�ӽ��
	CLType CLAddEnd(CLType head,DATA2 nodeData) {    //head:����ͷ���ã�nodeData:�ڵ�����
		CLType node,htemp;
		if((node=new CLType())==null) {
		System.out.println("�����ڴ�ʧ�ܣ�");
		return null;
		} else {
			node.nodeData = nodeData;
			node.nextNode = null;
			if(head==null) {
				head = node;
				return head;                   //�ڴ�����ʧ��
			}
			htemp = head;                      //������ͷ��ʼѰ������β
			while(htemp.nextNode != null) {
				htemp = htemp.nextNode;
			}
			htemp.nextNode = node;
			return head;
		}
	}
	
	//������ͷ������
	CLType CLAddFirst(CLType head,DATA2 nodeData) {
		CLType node;
		if((node = new CLType()) == null) {
			System.out.println("�����ڴ�ʧ�ܣ�");
			return null;
		}else {
			node.nodeData = nodeData;
			node.nextNode = head;
			head = node;
			return head;
		}
	}
	
	//���ݹؼ��ֲ��ҽ��
	CLType CLFindNode(CLType head,String key) {
		CLType htemp;
		htemp = head;         //��������ͷ����
		while(htemp!=null) {
			if(htemp.nodeData.key.compareTo(key)==0) {
				return htemp;
			}
			htemp = htemp.nextNode;
		}
		return null;
	}
	
	//ָ��key���󣬲���ڵ�
	CLType CLInsertNode(CLType head,String findkey,DATA2 nodeData) {
		CLType node,nodetemp;
		if((node=new CLType())==null) {
			System.out.println("�����ڴ�ʧ�ܣ�");
			return null;
		}
		node.nodeData = nodeData;
		nodetemp = CLFindNode(head,findkey);
		if(nodetemp!=null) {
			node.nextNode = nodetemp.nextNode;
			nodetemp.nextNode = node;
		}else {
			System.out.println("û���ҵ���ȷ�Ĳ���λ�ã�");
			//free(node);
		}
		return head;
	}
	
	//ɾ���ؼ������ڽ��
	int CLDeleteNode(CLType head,String key){
		CLType node,htemp;
		htemp = head;
		node = head;
		while(htemp!=null) {
			if(htemp.nodeData.key.compareTo(key)==0) {         //�ҵ��ؼ���
				node.nextNode = htemp.nextNode;
				//free(htemp);
				return 1;
			}else {
				node = htemp;
				htemp = htemp.nextNode;
			}
		}
		return 0;
	}
	
	//����������
	int CLLength(CLType head) {
		CLType htemp;
		int Len = 0;
		htemp = head;
		while(htemp!=null) {
			Len++;
			htemp = htemp.nextNode;
		}
		return Len;
	}
	
	//��������
	void CLAllNode(CLType head) {
		CLType htemp;
		DATA2 nodeData;
		htemp = head;
		System.out.println("��ǰ������"+CLLength(head)+"����㡣���������������£�");
		while(htemp!=null) {
			nodeData = htemp.nodeData;
			System.out.println("��� ��"+nodeData.key+","+nodeData.name+","+nodeData.age+"��");
			htemp = htemp.nextNode;
		}
	}
	
}
