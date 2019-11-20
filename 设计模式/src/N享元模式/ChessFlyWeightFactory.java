package N享元模式;

import java.util.HashMap;
import java.util.Map;

/**
 * 享元工厂类（存储可以共享的享元对象）
 */
public class ChessFlyWeightFactory {
	// 享元池
	private static Map<String, ChessFlyWeight> map = new HashMap<String, ChessFlyWeight>();

	public static ChessFlyWeight getChess(String color) {

		if (map.get(color) != null) {
			return map.get(color);
		} else {
			ChessFlyWeight cfw = new ConcreteChess(color);
			map.put(color, cfw);
			return cfw;
		}
		
	}
}