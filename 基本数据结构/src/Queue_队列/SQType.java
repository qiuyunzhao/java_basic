package Queue_队列;

class SQType {
	static final int QUEUELEN = 15;
	DATA4[] data = new DATA4[QUEUELEN]; //队列数组
	int head;        //队头
	int tail;        //队尾
	
	//初始化
	SQType SQTypeInit() {
		SQType q;
		if((q = new SQType())!=null) {
			q.head = 0;
			q.tail = 0;
			return q;
		}else {
			return null;
		}
	}
	
	//判断是否为空
	int SQTypeIsEmpty(SQType q) {
		int temp = 0;
		if(q.head == q.tail) {
			temp = 1;
		}
		return temp;
	}
	
	//判断队列是否满
	int SQTypeIsFull(SQType q) {
		int temp = 0;
		if(q.tail == QUEUELEN) {
			temp = 1;
		}
		return temp;
	}
	
	//清空队列
	void SQTypeClear(SQType q) {
		q.head = 0;
		q.tail = 0;
	}
	
	//释放队列
	void SQTypeFree(SQType q) {
		if(q != null) {
			q = null;
		}
	}
	
	//入队
	int InSQType(SQType q,DATA4 data) {
		if(q.tail == QUEUELEN) {
			System.out.println("队列已满，操作失败！");
			return 0;
		}else {
			q.data[q.tail++] = data;
			return 1;
		}
	}
	
	//出队
	DATA4 OutSQType(SQType q) {
		if(q.head == q.tail) {
			System.out.println("队列为空，操作失败！");
			System.exit(0);    //如果不加这一句，队列为空情况下出队列产生异常：java.lang.NullPointerException
		}else {
			return q.data[q.head++];
		}
		return null;
	}
	
	//读节点数据
	DATA4 PeekSQType(SQType q) {
		if(SQTypeIsEmpty(q) == 1) {
			System.out.println("队列为空！");
			return null;
		}else {
			return q.data[q.head];
		}
	}
	
	//计算队列长度
	int SQTypeLen(SQType q) {
		int temp;
		temp = q.tail - q.head;
		return temp;
	}
	
}
