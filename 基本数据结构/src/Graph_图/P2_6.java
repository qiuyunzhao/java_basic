package Graph_ͼ;

import java.util.Scanner;

public class P2_6 {
	
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method 
		GraphMatrix GM = new GraphMatrix();
		System.out.print("���ͼ�����ͣ�0.����ͼ    1.����ͼ");
		GM.GType = input.nextInt();
		System.out.print("����ͼ�Ķ���������");
		GM.VertexNum = input.nextInt();
		System.out.print("����ͼ�ı�������");
		GM.EdgeNum = input.nextInt();
		GraphMatrix t = new GraphMatrix();
		t.ClearGraph(GM);
		t.CreateGraph(GM);
		System.out.println("��ͼ���ڽӾ����������£�");
		t.OutGraph(GM);
		t.DeepTraGraph(GM);
	}

}
