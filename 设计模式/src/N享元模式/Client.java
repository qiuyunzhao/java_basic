package N享元模式;

public class Client {
	public static void main(String[] args) {
		
		ChessFlyWeight chess1 = ChessFlyWeightFactory.getChess("黑色");
		ChessFlyWeight chess2 = ChessFlyWeightFactory.getChess("白色");
		ChessFlyWeight chess3 = ChessFlyWeightFactory.getChess("黑色");
		System.out.println(chess1);
		System.out.println(chess2);
		System.out.println(chess3); //已经存在的将会返回同一个对象

		System.out.println("增加外部状态的处理===========");
		chess1.display(new Coordinate(10, 10));
		chess2.display(new Coordinate(20, 20));
		chess1.display(new Coordinate(10, 11));
		chess2.display(new Coordinate(20, 21));
	}
}
