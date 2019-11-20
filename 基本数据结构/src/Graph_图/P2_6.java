package Graph_图;

import java.util.Scanner;

public class P2_6 {
	
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method 
		GraphMatrix GM = new GraphMatrix();
		System.out.print("输出图的类型：0.无向图    1.有向图");
		GM.GType = input.nextInt();
		System.out.print("输入图的顶点数量：");
		GM.VertexNum = input.nextInt();
		System.out.print("输入图的边数量：");
		GM.EdgeNum = input.nextInt();
		GraphMatrix t = new GraphMatrix();
		t.ClearGraph(GM);
		t.CreateGraph(GM);
		System.out.println("该图的邻接矩阵数据如下：");
		t.OutGraph(GM);
		t.DeepTraGraph(GM);
	}

}
