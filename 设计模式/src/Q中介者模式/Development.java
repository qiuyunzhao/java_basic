package Q�н���ģʽ;

public class Development implements Department {

	private Mediator m; // �����н���(�ܾ���)������

	public Development(Mediator m) {
		this.m = m;
		m.register("development", this); // �������н���ע��
	}

	@Override
	public void outAction() {
		System.out.println("�㱨������ûǮ�ˣ���Ҫ�ʽ�֧�֣�");
	}

	@Override
	public void selfAction() {
		System.out.println("ר�Ŀ��У�������Ŀ��");
	}
}