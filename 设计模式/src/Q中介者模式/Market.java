package Q�н���ģʽ;

public class Market implements Department {

	private Mediator m; // �����н���(�ܾ���)������

	public Market(Mediator m) {
		this.m = m;
		m.register("market", this); //�������н���ע��
	}

	@Override
	public void outAction() {
		System.out.println("�г�---->����");
		System.out.println("�㱨��������Ŀ�нӵĽ��ȣ���Ҫ�ʽ�֧�֣�");
		m.command("finacial");
	}

	@Override
	public void selfAction() {
		System.out.println("��ȥ����Ŀ��");
	}
	
}