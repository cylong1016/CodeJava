package cylong.sort;

/**
 * 冒泡排序法
 * @author cylong
 * @version 2015年1月8日 上午4:22:33
 */
public class BubbleSort {

	public static void sort(int arr[]) {
		// 外层循环，决定一共走几趟
		for(int i = 0; i < arr.length - 1; i++) {
			// 内层循环，判断大小并交换
			for(int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}
}
