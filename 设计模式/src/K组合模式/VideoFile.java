package K���ģʽ;

/**
 * 2��Ҷ�ӣ�leaf��������ɫ�����ӽڵ�
 */
public class VideoFile implements AbstractFile {
	
	private String name;

	public VideoFile(String name) {
		super();
		this.name = name;
	}

	@Override
	public void killVirus() {
		System.out.println("-----��Ƶ�ļ���" + name + ",���в�ɱ��");
	}
	
}