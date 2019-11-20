package LinkedList_链表;

class CLType {
	DATA2 nodeData = new DATA2();
	CLType nextNode;
	
	//追加结点
	CLType CLAddEnd(CLType head,DATA2 nodeData) {    //head:链表头引用，nodeData:节点数据
		CLType node,htemp;
		if((node=new CLType())==null) {
		System.out.println("申请内存失败！");
		return null;
		} else {
			node.nodeData = nodeData;
			node.nextNode = null;
			if(head==null) {
				head = node;
				return head;                   //内存申请失败
			}
			htemp = head;                      //从链表头开始寻找链表尾
			while(htemp.nextNode != null) {
				htemp = htemp.nextNode;
			}
			htemp.nextNode = node;
			return head;
		}
	}
	
	//从链表头插入结点
	CLType CLAddFirst(CLType head,DATA2 nodeData) {
		CLType node;
		if((node = new CLType()) == null) {
			System.out.println("申请内存失败！");
			return null;
		}else {
			node.nodeData = nodeData;
			node.nextNode = head;
			head = node;
			return head;
		}
	}
	
	//根据关键字查找结点
	CLType CLFindNode(CLType head,String key) {
		CLType htemp;
		htemp = head;         //保存链表头引用
		while(htemp!=null) {
			if(htemp.nodeData.key.compareTo(key)==0) {
				return htemp;
			}
			htemp = htemp.nextNode;
		}
		return null;
	}
	
	//指定key结点后，插入节点
	CLType CLInsertNode(CLType head,String findkey,DATA2 nodeData) {
		CLType node,nodetemp;
		if((node=new CLType())==null) {
			System.out.println("申请内存失败！");
			return null;
		}
		node.nodeData = nodeData;
		nodetemp = CLFindNode(head,findkey);
		if(nodetemp!=null) {
			node.nextNode = nodetemp.nextNode;
			nodetemp.nextNode = node;
		}else {
			System.out.println("没有找到正确的插入位置！");
			//free(node);
		}
		return head;
	}
	
	//删除关键字所在结点
	int CLDeleteNode(CLType head,String key){
		CLType node,htemp;
		htemp = head;
		node = head;
		while(htemp!=null) {
			if(htemp.nodeData.key.compareTo(key)==0) {         //找到关键字
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
	
	//计算链表长度
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
	
	//遍历链表
	void CLAllNode(CLType head) {
		CLType htemp;
		DATA2 nodeData;
		htemp = head;
		System.out.println("当前链表共有"+CLLength(head)+"个结点。链表所有数据如下：");
		while(htemp!=null) {
			nodeData = htemp.nodeData;
			System.out.println("结点 （"+nodeData.key+","+nodeData.name+","+nodeData.age+"）");
			htemp = htemp.nextNode;
		}
	}
	
}
