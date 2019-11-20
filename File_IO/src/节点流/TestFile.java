package 节点流;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * java.io.File类：代表文件和目录。 在开发中，读取文件、生成文件、删除文件、修改文件的属性时经常会用到本类
 */
public class TestFile {

	public static void main(String[] args) {
		boolean flag = false;

		System.out.println(System.getProperty("user.dir"));

		File f = new File("a.txt"); // 相对路径：默认放到user.dir目录下面
		try {
			flag = f.createNewFile();// 创建文件
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (flag) {
			System.out.println("创建成功");
			flag = false;
		}

		System.out.println("File是否存在：" + f.exists());
		System.out.println("File是否是目录：" + f.isDirectory());
		System.out.println("File是否是文件：" + f.isFile());
		System.out.println("File最后修改时间：" + new Date(f.lastModified()));
		System.out.println("File的大小：" + f.length());
		System.out.println("File的文件名：" + f.getName());
		System.out.println("File的目录路径：" + f.getPath()); // 构建时是相对路径，返回相对路径，是绝对路径返回绝对路径
		System.out.println("File的绝对路径：" + f.getAbsolutePath());
		System.out.println("File的上一级路径：" + f.getParent()); // 构建时是相对路径，返回空，是绝对路径返回上一级目录
		flag = f.delete();
		if (flag) {
			System.out.println("删除成功");
			flag = false;
		}

		System.out.println("*************目录操作***************");
		File dir = new File("D:/eclipse-workspace/File_IO/创建目录/目录1");
		flag = dir.mkdir(); // mkdir()创建路径时上级路径不存在创建失败
		if (flag) {
			System.out.println("mkdir()创建成功");
			flag = false;
		} else {
			System.out.println("mkdir()创建失败");
		}
		flag = dir.mkdirs(); // 创建目录,上级目录不存在会自动创建
		if (flag) {
			System.out.println("mkdirs()创建成功");
			flag = false;
		} else {
			System.out.println("mkdirs()创建失败");
		}
		dir = new File("D:/eclipse-workspace/File_IO/创建目录");
		String[] subNames = dir.list(); // 获得下级名称
		System.out.print("下级名称:");
		for (String s : subNames) {
			System.out.print(s + "\t");
		}
		System.out.println();
		
		File[] subFiles = dir.listFiles(); // 获得下级对象
		System.out.print("下级文件对象:");
		for (File file : subFiles) {
			System.out.print(file.getAbsolutePath() + "\t");
		}
		System.out.println();

		System.out.println("*************创建文件*************");
		String filePath = "d:/sxt/b.txt";
		createFile(filePath);
		System.out.println("*************删除文件*************");
		deleteFile(filePath);
		deleteDirectory("d:/sxt");
		System.out.println("*************创建目录*************");
		String directoryName = "d:/中国/山东/淄博";
		createDirectory(directoryName);
		System.out.println("*************删除目录及子目录*******");
		deleteDirectory("d:/中国");
	}

	/**
	 * 创建单个文件，如果目录不存在先创建目录
	 */
	public static boolean createFile(String fileName) {
		File file = new File(fileName);
		// 如果存在
		if (file == null || file.exists()) {
			System.out.println("文件" + fileName + "已存在，创建失败");
			return false;
		} else {
			// 创建目录和文件
			try {
				// 如果目录不存在，先创建目录
				File dir = file.getParentFile();
				if (!dir.exists()) {
					dir.mkdirs(); // 创建目录
					System.out.println("创建目录" + dir);
				}
				// 创建文件
				boolean flagn = file.createNewFile();
				if (flagn) {
					System.out.println("创建文件" + fileName + "成功");
					return true;
				} else {
					System.out.println("创建文件" + fileName + "失败");
					return false;
				}
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("创建文件" + fileName + "失败");
				return false;
			}
		}
	}

	/**
	 * 删除单个文件
	 */
	public static boolean deleteFile(String fileName) {
		File file = new File(fileName);
		if (file.isFile() && file.exists()) {
			Boolean succeedDelete = file.delete();
			if (succeedDelete) {
				System.out.println("删除单个文件" + fileName + "成功！");
				return true;
			} else {
				System.out.println("删除单个文件" + fileName + "失败！");
				return true;
			}
		} else {
			System.out.println("删除单个文件" + fileName + "失败！");
			return false;
		}
	}

	/**
	 * 创建目录结构
	 */
	public static boolean createDirectory(String directoryName) {
		File file = new File(directoryName);
		// 如果目录不存在，先创建目录
		if (!file.exists()) {
			file.mkdirs(); // 创建目录,上级目录不存在会自动创建
			System.out.println("创建目录" + file + "成功");
			return true;
		} else {
			System.out.println("目录" + file + "已经存在");
			return false;
		}
	}

	/**
	 * 删除目录并删除目录中所有内容
	 */
	public static boolean deleteDirectory(String dir) {
		// 如果dir不以文件分隔符结尾，自动添加文件分隔符
		if (!dir.endsWith(File.separator)) {
			dir = dir + File.separator;
		}
		File dirFile = new File(dir);
		// 如果dir对应的文件不存在，或者不是一个目录，则退出
		if (!dirFile.exists() || !dirFile.isDirectory()) {
			System.out.println("删除目录失败" + dir + "目录不存在！");
			return false;
		}
		boolean flag = true;
		// 删除文件夹下的所有文件(包括子目录)
		File[] files = dirFile.listFiles(); 
		for (int i = 0; i < files.length; i++) {
			// 删除子文件
			if (files[i].isFile()) {
				flag = deleteFile(files[i].getAbsolutePath());
				if (!flag) {
					break;
				}
			}
			// 删除子目录
			else {
				flag = deleteDirectory(files[i].getAbsolutePath());
				if (!flag) {
					break;
				}
			}
		}

		if (!flag) {
			System.out.println("删除目录失败");
			return false;
		}

		// 删除当前目录
		if (dirFile.delete()) {
			System.out.println("删除目录" + dir + "成功！");
			return true;
		} else {
			System.out.println("删除目录" + dir + "失败！");
			return false;
		}
	}

}
