package egg;

/**
 * 一筐鸡蛋：
 * 1个1个拿，正好拿完。
 * 2个2个拿，还剩1个。
 * 3个3个拿，正好拿完。
 * 4个4个拿，还剩1个。
 * 5个5个拿，还差1个。【注意这个，别弄错了】
 * 6个6个拿，还剩3个。
 * 7个7个拿，正好拿完。
 * 8个8个拿，还剩1个。
 * 9个9个拿，正好拿完。
 * 问筐里最少有多少鸡蛋？
 * @author cylong
 * @version 2017年2月11日 下午8:35:55
 */
public class Egg {

	public static void main(String[] args) {
		for(int i = 9; i < 10000; i += 10) {
			if (i % 6 == 3) {
				if (i % 63 == 0) {
					if (i % 8 == 1) {
						System.out.println(i);
					}
				}
			}
		}
	}
}
