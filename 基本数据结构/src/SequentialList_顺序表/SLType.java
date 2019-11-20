package SequentialList_˳���;

class SLType{                              
	static final int MAXLEN=100;
	DATA[] ListData = new DATA[MAXLEN+1];  //����˳���Ľṹ���飬�±��1��ʼ
	int ListLen;                           //˳������Ѿ����ڵĽڵ�����
	
	//��ʼ��	
	void SLInit(SLType SL) {               //��ʼ��˳���
		SL.ListLen = 0;                    //��ʼ��Ϊ�ձ�
	}
	
	//����Ԫ�ظ���	
	int SLLength(SLType SL) {
		return(SL.ListLen);                //����Ԫ������
	}
	
	//����λ�ò���	
	int SLInsert(SLType SL,int n,DATA data) {
		int i;
		if (SL.ListLen>=MAXLEN) {
			System.out.println("˳����Ѿ����������ܲ���ڵ㣡");
			return 0;
		}
		if(n<1 || n>SL.ListLen-1) {
			System.out.println("����Ԫ����Ŵ��󣬲��ܲ���ڵ㣡");
			return 0;
		}
		for(i=SL.ListLen;i>=n;i--) {        //��˳����е���������ƶ�
			SL.ListData[i+1] = SL.ListData[i];
		}
		SL.ListData[n] = data;
		SL.ListLen++;
		return 1;
	}
	
	//β������
	int SLAdd(SLType SL,DATA data) {
		if(SL.ListLen>=MAXLEN) {
			System.out.println("˳����Ѿ����������ܲ���ڵ㣡");
			return 0;
		}
		SL.ListData[++SL.ListLen] = data;
		return 1;
	}
	
	//����λ��ɾ��
	int SLDelete(SLType SL,int n) {
		int i;
		if(n<1 || n>SL.ListLen) {
			System.out.println("ɾ���ڵ���Ŵ��󣬲���ɾ���ڵ㣡");
			return 0;
		}
		for (i=n;i<SL.ListLen;i++) {
			SL.ListData[i] = SL.ListData[i+1];
		}
		SL.ListLen--;
		return 1;
	}
	
	//������ŷ�������Ԫ��
	DATA SLFindByNum(SLType SL,int n) {
		if(n<1 || n>SL.ListLen+1) {
			System.out.println("�ڵ���Ŵ��󣬲��ܷ��ؽڵ㣡");
			return null;
		}
		return SL.ListData[n];
	}
	
	//���ݹؼ��ֲ�ѯ�ڵ�
	int SLFindByCont(SLType SL,String key) {
		int i;
		for(i=1;i<=SL.ListLen;i++) {
			if(SL.ListData[i].key.compareTo(key) == 0) {
				return i;
			}
		}
		return 0;
	}
	
	//��ʾ���нڵ�
	void SLAll(SLType SL) {
		int i;
		for(i=1;i<=SL.ListLen;i++) {
			System.out.println("("+SL.ListData[i].key+","+SL.ListData[i].name+","+SL.ListData[i].age+")");
		}
	}
	
}
