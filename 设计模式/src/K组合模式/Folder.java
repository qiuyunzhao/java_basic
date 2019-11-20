package K组合模式;

import java.util.ArrayList;
import java.util.List;

class Folder implements AbstractFile {
	
	private String name;
	
	private List<AbstractFile> list = new ArrayList<AbstractFile>(); // 定义容器，用来存放本容器构建下的子节点

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
		
		System.out.println("---文件夹：" + name + ",进行查杀");

		for (AbstractFile file : list) {  //递归调用子节点
			file.killVirus();
		}

	}

}