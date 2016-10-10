package qunar;

import java.util.HashMap;

public class FindChar {

	public static void main(String[] args) {
		String input = "Have you ever gone shopping and";
		String result = findChar(input);
		System.out.println(result);
	}

	/**
	 * 给定一个英文字符串,请写一段代码找出这个字符串中首先出现三次的那个英文字符。
	 * @param 样例输入 : Have you ever gone shopping and
	 * @return 样例输出: e
	 * @author cylong
	 * @version 2016年10月10日 上午10:27:33
	 */
	private static String findChar(String input) {
		HashMap<Character, Integer> count = new HashMap<Character, Integer>();
		for(int i = 0; i < input.length(); i++) {
			char tmp = input.charAt(i);
			if ((tmp >= 'a' && tmp <= 'z') || (tmp >= 'A' && tmp <= 'Z')) {
				Integer num = count.get(tmp);
				if (num == null) {
					count.put(tmp, 1);
				} else {
					num++;
					count.put(tmp, num);
					if (num == 3) {
						return String.valueOf(tmp);
					}
				}
			}
		}
		return null;
	}

}
