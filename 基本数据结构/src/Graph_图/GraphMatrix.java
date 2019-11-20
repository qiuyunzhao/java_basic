package Graph_图;

class GraphMatrix {
	static final int MaxNum = 20;
	static final int MaxValue = 65535;  //无边的项保存的数值
	int GType;                          //图的类型（0：无向图；1：有向图）
	int VertexNum;                      //顶点的数量
	int EdgeNum;                        //边的数量
	char[] Vertex = new char[MaxNum];   //保存定点信息（序号或字母)
	int[][] EdgeWeight = new int[MaxNum][MaxNum]; //保存边的权
	int[] isTrav = new int[MaxNum];     //遍历标志数组
	
	
	//创建邻接矩阵图
	void CreateGraph(GraphMatrix GM) {
		int i,j,k;		
		int weight;            //权
		char EstartV,EendV;    //边的顶点
		//输入顶点
		System.out.println("输入图中各顶点信息");
		for(i=0;i<GM.VertexNum;i++) {
			System.out.printf("\n第%d个顶点", i+1);
			GM.Vertex[i] = (P2_6.input.next().toCharArray())[0];  //保存到各顶点数组元素中
		}
		//输入边的信息
		System.out.println("输入构成各边的顶点及权值  点1  点2  权值 ：");
		for(k=0;k<GM.EdgeNum;k++) {
			System.out.printf("第%d条边：", k+1);
			
			EstartV = P2_6.input.next().charAt(0);
			EendV = P2_6.input.next().charAt(0);
			weight = P2_6.input.nextInt();
			
			for(i=0;EstartV!=GM.Vertex[i];i++);  //在已有顶点中查找开始点
			for(j=0;EendV!=GM.Vertex[j];j++);    //在已有顶点中查找终结点
			GM.EdgeWeight[i][j] = weight;        //对应位置保存权值，表示有一条边
			
			if(GM.GType==0) {
				GM.EdgeWeight[j][i] = weight;    //无向图邻接矩阵
			}
		}
	}
	
	//清空邻接矩阵
	void ClearGraph(GraphMatrix GM) {
		int i,j;
		for(i=0;i<GM.VertexNum;i++) {
			for(j=0;j<GM.VertexNum;j++) {
				GM.EdgeWeight[i][j] = GraphMatrix.MaxValue;
			}
		}
	}
	
	//输出图，即邻接矩阵
	void OutGraph(GraphMatrix GM) {
		int i,j;
		//在第一行输出顶点信息
		for(j=0;j<GM.VertexNum;j++) {
			System.out.printf("\t%c", GM.Vertex[j]);
		}
		System.out.println("");
		
		for(i=0;i<GM.VertexNum;i++) {
			System.out.printf("%c", GM.Vertex[i]);//在第一列输出顶点信息
			for(j=0;j<GM.VertexNum;j++) {
				if(GM.EdgeWeight[i][j]==GraphMatrix.MaxValue){
					System.out.print("\tZ");       //Z表示无权值
				}else {
					System.out.printf("\t%d", GM.EdgeWeight[i][j]);
				}
			}
			System.out.println("");
		}
	}
	
	//从第n个顶点开始，深度遍历图
	void DeepTraOne(GraphMatrix GM,int n) {
		int i;
		GM.isTrav[n]=1;    //标记该顶点已经处理过
		System.out.printf("->%c", GM.Vertex[n]);  //输出节点数据
		//添加处理节点的操作
		for(i=0;i<GM.VertexNum;i++) {
			if(GM.EdgeWeight[n][i]!=GraphMatrix.MaxValue && GM.isTrav[i]==0) {
				DeepTraOne(GM,i);
			}
		}
	}
	
	//深度优先遍历
	void DeepTraGraph(GraphMatrix GM) {
		int i;
		for(i=0;i<GM.VertexNum;i++) {
			GM.isTrav[i]=0;            //清空各顶点遍历标志
		}
		System.out.println("深度优先遍历结点：");
		for(i=0;i<GM.VertexNum;i++) {
			if(GM.isTrav[i]==0) {      //该点未遍历
				DeepTraOne(GM,i);      //从该点开始遍历全图       
			}
		}
		System.out.println("");
	}
	
}
