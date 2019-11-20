package Graph_ͼ;

class GraphMatrix {
	static final int MaxNum = 20;
	static final int MaxValue = 65535;  //�ޱߵ�������ֵ
	int GType;                          //ͼ�����ͣ�0������ͼ��1������ͼ��
	int VertexNum;                      //���������
	int EdgeNum;                        //�ߵ�����
	char[] Vertex = new char[MaxNum];   //���涨����Ϣ����Ż���ĸ)
	int[][] EdgeWeight = new int[MaxNum][MaxNum]; //����ߵ�Ȩ
	int[] isTrav = new int[MaxNum];     //������־����
	
	
	//�����ڽӾ���ͼ
	void CreateGraph(GraphMatrix GM) {
		int i,j,k;		
		int weight;            //Ȩ
		char EstartV,EendV;    //�ߵĶ���
		//���붥��
		System.out.println("����ͼ�и�������Ϣ");
		for(i=0;i<GM.VertexNum;i++) {
			System.out.printf("\n��%d������", i+1);
			GM.Vertex[i] = (P2_6.input.next().toCharArray())[0];  //���浽����������Ԫ����
		}
		//����ߵ���Ϣ
		System.out.println("���빹�ɸ��ߵĶ��㼰Ȩֵ  ��1  ��2  Ȩֵ ��");
		for(k=0;k<GM.EdgeNum;k++) {
			System.out.printf("��%d���ߣ�", k+1);
			
			EstartV = P2_6.input.next().charAt(0);
			EendV = P2_6.input.next().charAt(0);
			weight = P2_6.input.nextInt();
			
			for(i=0;EstartV!=GM.Vertex[i];i++);  //�����ж����в��ҿ�ʼ��
			for(j=0;EendV!=GM.Vertex[j];j++);    //�����ж����в����ս��
			GM.EdgeWeight[i][j] = weight;        //��Ӧλ�ñ���Ȩֵ����ʾ��һ����
			
			if(GM.GType==0) {
				GM.EdgeWeight[j][i] = weight;    //����ͼ�ڽӾ���
			}
		}
	}
	
	//����ڽӾ���
	void ClearGraph(GraphMatrix GM) {
		int i,j;
		for(i=0;i<GM.VertexNum;i++) {
			for(j=0;j<GM.VertexNum;j++) {
				GM.EdgeWeight[i][j] = GraphMatrix.MaxValue;
			}
		}
	}
	
	//���ͼ�����ڽӾ���
	void OutGraph(GraphMatrix GM) {
		int i,j;
		//�ڵ�һ�����������Ϣ
		for(j=0;j<GM.VertexNum;j++) {
			System.out.printf("\t%c", GM.Vertex[j]);
		}
		System.out.println("");
		
		for(i=0;i<GM.VertexNum;i++) {
			System.out.printf("%c", GM.Vertex[i]);//�ڵ�һ�����������Ϣ
			for(j=0;j<GM.VertexNum;j++) {
				if(GM.EdgeWeight[i][j]==GraphMatrix.MaxValue){
					System.out.print("\tZ");       //Z��ʾ��Ȩֵ
				}else {
					System.out.printf("\t%d", GM.EdgeWeight[i][j]);
				}
			}
			System.out.println("");
		}
	}
	
	//�ӵ�n�����㿪ʼ����ȱ���ͼ
	void DeepTraOne(GraphMatrix GM,int n) {
		int i;
		GM.isTrav[n]=1;    //��Ǹö����Ѿ������
		System.out.printf("->%c", GM.Vertex[n]);  //����ڵ�����
		//��Ӵ���ڵ�Ĳ���
		for(i=0;i<GM.VertexNum;i++) {
			if(GM.EdgeWeight[n][i]!=GraphMatrix.MaxValue && GM.isTrav[i]==0) {
				DeepTraOne(GM,i);
			}
		}
	}
	
	//������ȱ���
	void DeepTraGraph(GraphMatrix GM) {
		int i;
		for(i=0;i<GM.VertexNum;i++) {
			GM.isTrav[i]=0;            //��ո����������־
		}
		System.out.println("������ȱ�����㣺");
		for(i=0;i<GM.VertexNum;i++) {
			if(GM.isTrav[i]==0) {      //�õ�δ����
				DeepTraOne(GM,i);      //�Ӹõ㿪ʼ����ȫͼ       
			}
		}
		System.out.println("");
	}
	
}
