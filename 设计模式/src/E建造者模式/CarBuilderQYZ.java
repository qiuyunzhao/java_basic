package E������ģʽ;

public class CarBuilderQYZ implements CarBuilder {

	@Override
	public Engine builderEngine() {
		System.out.println("����QYZ�Ʒ�������");
		return new Engine("QYZ�Ʒ�������");	  //���ܻ��Ϲ���ģʽ��������
	}

	@Override
	public Seat builderSeat() {
		System.out.println("����QYZ�����Σ�");
		return new Seat("QYZ�����Σ�");
	}

	@Override
	public Tyre builderTyre() {
		System.out.println("����QYZ����̥��");
		return new Tyre("QYZ����̥��");
	}

}