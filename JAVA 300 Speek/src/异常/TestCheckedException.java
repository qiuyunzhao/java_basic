package 异常;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TestCheckedException {

	public static void main(String[] args) {

		String str = "d:/a.txt";
		try {
			throwsException(str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tryCatchException(str);
	}

	/**
	 * try  catch 方式处理异常
	 * @param filePath
	 */
	public static void tryCatchException(String filePath) {
		FileReader reader = null;
		try {
			reader = new FileReader(filePath);
			char c = (char) reader.read();
			char c2 = (char) reader.read();
			System.out.println("" + c + c2);
		} catch (FileNotFoundException e) { 	//子类异常捕获在父类异常前边
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * throws 方式处理异常
	 * @param filePath
	 * @throws IOException 
	 */
	public static void throwsException(String filePath) throws IOException {
		FileReader in = new FileReader(filePath);
        int tem = 0;
        try {
            tem = in.read();
            while (tem != -1) {
                System.out.print((char) tem);
                tem = in.read();
            }
        } finally {
            in.close();
        }
	}
	
}
