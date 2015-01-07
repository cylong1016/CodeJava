package cylong.java.util.sort;

/**
 * 快速排序法
 * @author cylong
 * @version 2015年1月8日 上午4:24:08
 */
public class QuickSort {

	public void sort(int[] arr, int low, int high) {

		int pos;
		if (low < high) {
			pos = FindPos(arr, low, high);
			sort(arr, low, pos - 1);
			sort(arr, pos + 1, high);
		}
	}

	private int FindPos(int[] a, int low, int high) {
		int val = a[low];
		while(low < high) {
			while(low < high && a[high] >= val)
				high--;
			a[low] = a[high];
			while(low < high && a[low] <= val)
				low++;
			a[high] = a[low];
		}
		a[low] = val;
		return low;
	}
}
