package cylong.sort;

/**
 * 顺序查找
 * @author cylong
 * @version 2015年1月8日 上午4:25:40
 */
public class OrderFind {

	public static void orderFind(int value, int arr[]) {
		boolean b = true;
		System.out.print("顺序法查找结果：");
		for(int i = 0; i < arr.length; i++) {
			if (arr[i] == value) {
				System.out.print("arr[" + i + "]=" + arr[i] + "、");
				b = false;
			}
		}
		if (b) {
			System.out.print("查找的数不存在！");
		}
	}
}
