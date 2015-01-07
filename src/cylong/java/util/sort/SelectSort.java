package cylong.java.util.sort;

/**
 * 选择排序法
 * @author cylong
 * @version 2015年1月8日 上午4:28:33
 */
public class SelectSort {

	public static void sort(int arr[]) {
		for(int i = 0; i < arr.length - 1; i++) {
			int min = arr[i];
			int minIndex = i;

			for(int j = i + 1; j < arr.length; j++) {
				if (min > arr[j]) {
					min = arr[j];
					minIndex = j;
				}
			}
			//退出第二个for时候就找到最小值
			int temp = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = temp;
		}
	}
}
