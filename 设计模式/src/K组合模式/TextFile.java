package K���ģʽ;

/**
 * 2��Ҷ�ӣ�leaf��������ɫ�����ӽڵ�
 */
public class TextFile implements AbstractFile {
	
	private String name;

	public TextFile(String name) {
		super();
		this.name = name;
	}

	@Override
	public void killVirus() {
		System.out.println("-----�ı��ļ���" + name + ",���в�ɱ��");
	}
}