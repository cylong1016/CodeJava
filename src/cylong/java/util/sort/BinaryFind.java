package cylong.java.util.sort;

/**
 * 二分查找
 * @author cylong
 * @version 2015年1月8日 上午4:26:19
 */
public class BinaryFind {

	public static int middleIndex;
	public static int middleValue;
	private static boolean b;

	public static void binaryFind(int value, int arr[]) {
		binaryFind(0, arr.length - 1, value, arr);
	}

	private static void binaryFind(int leftIndex, int rightIndex, int value, int arr[]) {
		setB(true);
		if (rightIndex >= leftIndex) {
			middleIndex = (rightIndex + leftIndex) / 2;
			middleValue = arr[middleIndex];

			if (middleValue > value) {
				middleIndex -= 1;
				binaryFind(leftIndex, middleIndex, value, arr);
			} else if (middleValue < value) {
				middleIndex += 1;
				binaryFind(middleIndex, rightIndex, value, arr);
			} else if (middleValue == value) {
				System.out.print("");
				setB(false);
			}
		}
	}

	public static void extracted() {
		System.out.print("查找的数不存在！");
	}

	public static boolean isB() {
		return b;
	}

	public static void setB(boolean b) {
		BinaryFind.b = b;
	}
}
