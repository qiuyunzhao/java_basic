package SequentialList_顺序表;

class SLType{                              
	static final int MAXLEN=100;
	DATA[] ListData = new DATA[MAXLEN+1];  //保存顺序表的结构数组，下标从1开始
	int ListLen;                           //顺序表中已经存在的节点数量
	
	//初始化	
	void SLInit(SLType SL) {               //初始化顺序表
		SL.ListLen = 0;                    //初始化为空表
	}
	
	//返回元素各数	
	int SLLength(SLType SL) {
		return(SL.ListLen);                //返回元素数量
	}
	
	//任意位置插入	
	int SLInsert(SLType SL,int n,DATA data) {
		int i;
		if (SL.ListLen>=MAXLEN) {
			System.out.println("顺序表已经存满，不能插入节点！");
			return 0;
		}
		if(n<1 || n>SL.ListLen-1) {
			System.out.println("插入元素序号错误，不能插入节点！");
			return 0;
		}
		for(i=SL.ListLen;i>=n;i--) {        //将顺序表中的数据向后移动
			SL.ListData[i+1] = SL.ListData[i];
		}
		SL.ListData[n] = data;
		SL.ListLen++;
		return 1;
	}
	
	//尾部插入
	int SLAdd(SLType SL,DATA data) {
		if(SL.ListLen>=MAXLEN) {
			System.out.println("顺序表已经存满，不能插入节点！");
			return 0;
		}
		SL.ListData[++SL.ListLen] = data;
		return 1;
	}
	
	//任意位置删除
	int SLDelete(SLType SL,int n) {
		int i;
		if(n<1 || n>SL.ListLen) {
			System.out.println("删除节点序号错误，不能删除节点！");
			return 0;
		}
		for (i=n;i<SL.ListLen;i++) {
			SL.ListData[i] = SL.ListData[i+1];
		}
		SL.ListLen--;
		return 1;
	}
	
	//根据序号返回数组元素
	DATA SLFindByNum(SLType SL,int n) {
		if(n<1 || n>SL.ListLen+1) {
			System.out.println("节点序号错误，不能返回节点！");
			return null;
		}
		return SL.ListData[n];
	}
	
	//根据关键字查询节点
	int SLFindByCont(SLType SL,String key) {
		int i;
		for(i=1;i<=SL.ListLen;i++) {
			if(SL.ListData[i].key.compareTo(key) == 0) {
				return i;
			}
		}
		return 0;
	}
	
	//显示所有节点
	void SLAll(SLType SL) {
		int i;
		for(i=1;i<=SL.ListLen;i++) {
			System.out.println("("+SL.ListData[i].key+","+SL.ListData[i].name+","+SL.ListData[i].age+")");
		}
	}
	
}
