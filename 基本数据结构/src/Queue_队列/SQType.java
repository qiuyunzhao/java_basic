package Queue_����;

class SQType {
	static final int QUEUELEN = 15;
	DATA4[] data = new DATA4[QUEUELEN]; //��������
	int head;        //��ͷ
	int tail;        //��β
	
	//��ʼ��
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
	
	//�ж��Ƿ�Ϊ��
	int SQTypeIsEmpty(SQType q) {
		int temp = 0;
		if(q.head == q.tail) {
			temp = 1;
		}
		return temp;
	}
	
	//�ж϶����Ƿ���
	int SQTypeIsFull(SQType q) {
		int temp = 0;
		if(q.tail == QUEUELEN) {
			temp = 1;
		}
		return temp;
	}
	
	//��ն���
	void SQTypeClear(SQType q) {
		q.head = 0;
		q.tail = 0;
	}
	
	//�ͷŶ���
	void SQTypeFree(SQType q) {
		if(q != null) {
			q = null;
		}
	}
	
	//���
	int InSQType(SQType q,DATA4 data) {
		if(q.tail == QUEUELEN) {
			System.out.println("��������������ʧ�ܣ�");
			return 0;
		}else {
			q.data[q.tail++] = data;
			return 1;
		}
	}
	
	//����
	DATA4 OutSQType(SQType q) {
		if(q.head == q.tail) {
			System.out.println("����Ϊ�գ�����ʧ�ܣ�");
			System.exit(0);    //���������һ�䣬����Ϊ������³����в����쳣��java.lang.NullPointerException
		}else {
			return q.data[q.head++];
		}
		return null;
	}
	
	//���ڵ�����
	DATA4 PeekSQType(SQType q) {
		if(SQTypeIsEmpty(q) == 1) {
			System.out.println("����Ϊ�գ�");
			return null;
		}else {
			return q.data[q.head];
		}
	}
	
	//������г���
	int SQTypeLen(SQType q) {
		int temp;
		temp = q.tail - q.head;
		return temp;
	}
	
}
