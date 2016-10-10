package qunar;

public class FilenameExtension {

	public static void main(String[] args) {
		String input = "Abc.abc/file.txt";
		String result = getFilenameExtension(input);
		System.out.println(result);
	}

	/**
	 * 对于每个测试实例，要求输出对应的 filename extension
	 * @param 样例输入: Abc/file.txt
	 * @return 样例输出: txt
	 * @author cylong
	 * @version 2016年10月10日 上午10:05:18
	 */
	private static String getFilenameExtension(String input) {
		for(int i = input.length() - 1; i >= 0; i--) {
			char tmp = input.charAt(i);
			if (tmp == '.') {
				return input.substring(i + 1);
			} else if (tmp == '/') { // 没有后缀
				return null;
			}
		}
		return null;
	}

}
