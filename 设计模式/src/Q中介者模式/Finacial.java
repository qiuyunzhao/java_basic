package Q�н���ģʽ;

public class Finacial implements Department {

	private Mediator m; // �����н���(�ܾ���)������

	public Finacial(Mediator m) {
		this.m = m;
		m.register("finacial", this); // �������н���ע��
	}

	@Override
	public void outAction() {
		System.out.println("�㱨������Ԥ�㸴��Ҫ�󣬿ɽ��в���?");
	}

	@Override
	public void selfAction() {
		System.out.println("�����ʽ���㣡");
	}
}