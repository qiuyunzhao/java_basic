package K组合模式;

/**
 * 2）叶子（leaf）构件角色：无子节点
 */
public class ImageFile implements AbstractFile {

	private String name;

	public ImageFile(String name) {
		super();
		this.name = name;
	}

	@Override
	public void killVirus() {
		System.out.println("-----图像文件：" + name + ",进行查杀！");
	}

}