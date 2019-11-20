package E建造者模式;

/**
 * 用于创建汽车组件
 */
public interface CarBuilder {

	Engine builderEngine();

	Seat builderSeat();

	Tyre builderTyre();

}