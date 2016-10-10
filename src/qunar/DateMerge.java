package qunar;

import java.util.Scanner;

public class DateMerge {

	public static final int N = 3;
	public static int M = 0;

	public static void main(String[] args) {
		int m = 0;
		int n = 0;
		int[][] dateRangePrices = new int[100][N];
		Scanner scan = new Scanner(System.in);
		while(true) {
			int input = scan.nextInt();
			if (input == -1) {
				scan.close();
				break;
			}
			dateRangePrices[m][n] = input;
			n++;
			if (n == N) {
				n = 0;
				M = ++m;
			}
		}
		int[][] result = merge(dateRangePrices);
		StringBuilder builder = new StringBuilder();
		builder.append("[" + result[0][0] + ", " + result[0][1] + ", " + result[0][2] + "]");
		for(int i = 1; i < M; i++) {
			builder.append(", [" + result[i][0]);
			for(int j = 1; j < N; j++) {
				builder.append(", " + result[i][j]);
			}
			builder.append("]");
		}
		System.out.println(builder.toString());
	}

	/**
	 * 酒店房间的价格录入是通过时间段来录入的，比如10月1日至10月7日800元，10月8日至10月20日500元。
	 * 请实现以下函数int[][] merge(int[][] dateRangePrices)。
	 * 输入是某个酒店多个日期段的价格，每个日期段（终止日期大于等于起始日期）和对应的价格使用长度为3的数组来表示，
	 * 比如[0, 19, 300], [10, 40, 250]分别表示从某天开始第1天到第20天价格都是300，第11天到第41天价格都是250，
	 * 这些日期端有可能重复，重复的日期的价格以后面的为准，请以以下规则合并并输出合并结果：
	 * 1. 相邻两天的价格如果相同，那么这两个日期段应该合并
	 * 2. 合并的结果应该以起始日期从小到大排序
	 * 3. 输入：[0, 100, 300], [40, 50, 350]
	 * 4. 输出： [0, 39, 300], [40, 50, 350], [51, 100, 300]
	 * @param 样例输入： 	1 1 100
	 *            		2 3 100
	 *            		4 5 110
	 * @return 样例输出： [1, 3, 100],[4, 5, 110]
	 * @author cylong
	 * @version 2016年10月10日 上午10:16:18
	 */
	public static int[][] merge(int[][] dateRangePrices) {
		sort(dateRangePrices);
		for(int i = 1; i < M; i++) {
			if (dateRangePrices[i][2] == dateRangePrices[i - 1][2]
				&& dateRangePrices[i][0] == dateRangePrices[i - 1][0] + 1) {
				dateRangePrices[i - 1][1] = dateRangePrices[i][1];
				for(int j = i; j < M - 1; j++) {
					dateRangePrices[j][0] = dateRangePrices[j + 1][0];
					dateRangePrices[j][1] = dateRangePrices[j + 1][1];
					dateRangePrices[j][2] = dateRangePrices[j + 1][2];
				}
				M--;
			}

			if (dateRangePrices[i][0] == dateRangePrices[i - 1][0]) {
				if (dateRangePrices[i][1] < dateRangePrices[i - 1][1]) {
					int tmp = dateRangePrices[i - 1][1];
					dateRangePrices[i - 1][1] = dateRangePrices[i][1];
					dateRangePrices[i][0] = dateRangePrices[i][1] + 1;
					dateRangePrices[i][1] = tmp;
					int tmp1 = dateRangePrices[i - 1][2];
					dateRangePrices[i - 1][2] = dateRangePrices[i][2];
					dateRangePrices[i][2] = tmp1;
				} else if (dateRangePrices[i][1] >= dateRangePrices[i - 1][1]) {
					for(int j = i - 1; j < M - 1; j++) {
						dateRangePrices[j][0] = dateRangePrices[j + 1][0];
						dateRangePrices[j][1] = dateRangePrices[j + 1][1];
						dateRangePrices[j][2] = dateRangePrices[j + 1][2];
					}
					M--;
				}
			} else if (dateRangePrices[i][0] > dateRangePrices[i - 1][0]) {
				if (dateRangePrices[i][1] < dateRangePrices[i - 1][1]) {
					int tmp = dateRangePrices[i - 1][1];
					dateRangePrices[i - 1][1] = dateRangePrices[i][0] - 1;
					for(int j = M - 1; j >= i; j--) {
						dateRangePrices[j + 1][0] = dateRangePrices[j][0];
						dateRangePrices[j + 1][1] = dateRangePrices[j][1];
						dateRangePrices[j + 1][2] = dateRangePrices[j][2];
					}
					M++;
					dateRangePrices[i + 1][0] = dateRangePrices[i][1] + 1;
					dateRangePrices[i + 1][1] = tmp;
					dateRangePrices[i + 1][2] = dateRangePrices[i - 1][2];
				} else if (dateRangePrices[i][1] >= dateRangePrices[i - 1][1]) {
					dateRangePrices[i - 1][1] = dateRangePrices[i][0] - 1;
				}
			}
		}
		return dateRangePrices;
	}

	public static void sort(int[][] arr) {
		for(int i = 0; i < M - 1; i++) {
			int[] min = arr[i];
			int minIndex = i;

			for(int j = i + 1; j < M; j++) {
				if (min[0] > arr[j][0]) {
					min = arr[j];
					minIndex = j;
				}
			}
			int[] temp = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = temp;
		}
	}
}
