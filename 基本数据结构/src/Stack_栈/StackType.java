package Stack_栈;

class StackType {
	static final int MAXLEN = 50;
	DATA3[] data = new DATA3[MAXLEN+1];    //为了方便从下表1开始记录数据点
	int top;          //栈顶
	
	//初始化
	StackType STInit() {
		StackType p;
		if((p = new StackType())!=null) {
			p.top = 0;
			return p;
		}
		return null;
	}
	
	//判断栈是否为空
	boolean STIsEmpty(StackType s) {
		boolean t;
		t = (s.top == 0);
		return t;
	}
	
	//判断栈是否已满
	boolean STIsFull(StackType s) {
		boolean t;
		t = (s.top == MAXLEN);
		return t;
	}
	
	//清空栈
	void SSTClear(StackType s) {
		s.top = 0;
	}
	
	//释放栈所占用空间
	void STFree(StackType s) {
		if(s!=null) {
			s=null;
		}
	}
	
	//入栈
	int PushST(StackType s,DATA3 data) {
		if((s.top+1)>MAXLEN) {
			System.out.println("栈溢出！");
			return 0;
		}
		s.data[++s.top] = data;
		return 1;
	}
	
	//出栈
	DATA3 PopST(StackType s) {
		if(s.top == 0) {
			System.out.println("栈为空！");
			System.exit(0);
		}
		return (s.data[s.top--]);
	}
	
	//读取栈顶数据
	DATA3 PeekST(StackType s) {
		if(s.top == 0) {
			System.out.println("栈为空！");
			System.exit(0);
		}
		return(s.data[s.top]);
	}
	
}
