package K���ģʽ;

/**
 * 2��Ҷ�ӣ�leaf��������ɫ�����ӽڵ�
 */
public class ImageFile implements AbstractFile {

	private String name;

	public ImageFile(String name) {
		super();
		this.name = name;
	}

	@Override
	public void killVirus() {
		System.out.println("-----ͼ���ļ���" + name + ",���в�ɱ��");
	}

}