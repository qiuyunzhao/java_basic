package H��̬����ģʽ;

/**
 * ��̬�����Զ��������
 * 
 * ��̬�����ɳ����Զ����ɴ�����
 * 
 * ��̬���� ���ģ�ʵ����ͬ�ӿڵ�������ɫ�ࣺ1.��ʵ��ɫ 2.�����ɫ
 *
 */
public class StaticProxyDemo01 {

	public static void main(String[] args) {
		Bridegroom bridegroom = new Bridegroom();
		Bride bride = new Bride();
		new WeddingCompany(bridegroom, bride).happyMarry();
	}
}

/**
 * ��ͬ�Ľӿ�
 */
interface Marry {
	void happyMarry();
}

/**
 * ��ʵ��ɫ
 */
class Bridegroom implements Marry {

	@Override
	public void happyMarry() {
		System.out.println("��������ǣ�����");
	}

}

/**
 * ��ʵ��ɫ
 */
class Bride implements Marry {

	@Override
	public void happyMarry() {
		System.out.println("��������ǣ�����");
	}

}

/**
 * �����ɫ
 */
class WeddingCompany implements Marry {
	// ���������ʵ��ɫ��
	private Bridegroom target1;
	private Bride target2;

	public WeddingCompany(Bridegroom target1, Bride target2) {
		this.target1 = target1;
		this.target2 = target2;
	}

	@Override
	public void happyMarry() {
		readyWork();
		this.target1.happyMarry();
		this.target2.happyMarry();
		afterWork();
	}
	
	//ʵ��Ӧ��ʱ���Լ�¼��־
	private void readyWork() {
		System.out.println("��ʰ�᳡");
	}

	private void afterWork() {
		System.out.println("���û᳡");
	}

}
