package cylong.java.util.sort;

/**
 * 插入排序法
 * @author cylong
 * @version 2015年1月8日 上午4:27:42
 */
public class InsertSort {

	public static void sort(int arr[]) {
		for(int i = 1; i < arr.length; i++) {
			int insertValue = arr[i];
			int index = i - 1;
			for(; index >= 0 && insertValue < arr[index]; index--) {
				arr[index + 1] = arr[index];
			}
			arr[index + 1] = insertValue;
		}
	}
}
