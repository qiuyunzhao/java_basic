package N��Ԫģʽ;

public class Client {
	public static void main(String[] args) {
		
		ChessFlyWeight chess1 = ChessFlyWeightFactory.getChess("��ɫ");
		ChessFlyWeight chess2 = ChessFlyWeightFactory.getChess("��ɫ");
		ChessFlyWeight chess3 = ChessFlyWeightFactory.getChess("��ɫ");
		System.out.println(chess1);
		System.out.println(chess2);
		System.out.println(chess3); //�Ѿ����ڵĽ��᷵��ͬһ������

		System.out.println("�����ⲿ״̬�Ĵ���===========");
		chess1.display(new Coordinate(10, 10));
		chess2.display(new Coordinate(20, 20));
		chess1.display(new Coordinate(10, 11));
		chess2.display(new Coordinate(20, 21));
	}
}
