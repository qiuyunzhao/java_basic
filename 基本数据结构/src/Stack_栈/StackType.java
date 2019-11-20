package Stack_ջ;

class StackType {
	static final int MAXLEN = 50;
	DATA3[] data = new DATA3[MAXLEN+1];    //Ϊ�˷�����±�1��ʼ��¼���ݵ�
	int top;          //ջ��
	
	//��ʼ��
	StackType STInit() {
		StackType p;
		if((p = new StackType())!=null) {
			p.top = 0;
			return p;
		}
		return null;
	}
	
	//�ж�ջ�Ƿ�Ϊ��
	boolean STIsEmpty(StackType s) {
		boolean t;
		t = (s.top == 0);
		return t;
	}
	
	//�ж�ջ�Ƿ�����
	boolean STIsFull(StackType s) {
		boolean t;
		t = (s.top == MAXLEN);
		return t;
	}
	
	//���ջ
	void SSTClear(StackType s) {
		s.top = 0;
	}
	
	//�ͷ�ջ��ռ�ÿռ�
	void STFree(StackType s) {
		if(s!=null) {
			s=null;
		}
	}
	
	//��ջ
	int PushST(StackType s,DATA3 data) {
		if((s.top+1)>MAXLEN) {
			System.out.println("ջ�����");
			return 0;
		}
		s.data[++s.top] = data;
		return 1;
	}
	
	//��ջ
	DATA3 PopST(StackType s) {
		if(s.top == 0) {
			System.out.println("ջΪ�գ�");
			System.exit(0);
		}
		return (s.data[s.top--]);
	}
	
	//��ȡջ������
	DATA3 PeekST(StackType s) {
		if(s.top == 0) {
			System.out.println("ջΪ�գ�");
			System.exit(0);
		}
		return(s.data[s.top]);
	}
	
}
