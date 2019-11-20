package K���ģʽ;

import java.util.ArrayList;
import java.util.List;

class Folder implements AbstractFile {
	
	private String name;
	
	private List<AbstractFile> list = new ArrayList<AbstractFile>(); // ����������������ű����������µ��ӽڵ�

	public Folder(String name) {
		super();
		this.name = name;
	}

	public void add(AbstractFile file) {
		list.add(file);
	}

	public void remove(AbstractFile file) {
		list.remove(file);
	}

	public AbstractFile getChild(int index) {
		return list.get(index);
	}

	@Override
	public void killVirus() {
		
		System.out.println("---�ļ��У�" + name + ",���в�ɱ");

		for (AbstractFile file : list) {  //�ݹ�����ӽڵ�
			file.killVirus();
		}

	}

}