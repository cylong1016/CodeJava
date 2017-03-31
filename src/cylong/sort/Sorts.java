package cylong.sort;
/**
*作者：陈云龙
*时间：2014/1/23
*功能：各种排序法和查找,并比较各种方法的运算时间
*排序：一：内部排序：  1.交换是排序法:(1).冒泡排序法(Bubble Sort)
*				      	  (2).快速排序法(Quick Sort)
*		       2.选择式排序法:(1).选择排序法(Selection Sort)
*				          (2).堆排序法(Heap Sort)
*		       3.插入式排序法:(1).插入排序法(Insertion Sort)
*		                  (2).谢尔排序法(Shell Sort)
*				          (3).二叉树排序法(Binary-tree Sort)
*      
*    二：外部排序法：1.合并排序法
*		        2.直接合并排序法
*查找：一：顺序查找
*    二：二分查找
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Calendar;

public class Sorts {

	public static void main(String[] args) throws Exception {
		//数组大小
		int len = 10000;
		//随机数范围
		int rang = len;
		System.out.println("将" + len + "个数据由小到大排列\n");

		//用冒泡排序法进行排序
		int arrBubble[] = new int[len];
		//用随机数给数组赋值
		for(int i = 0; i < arrBubble.length; i++) {
			arrBubble[i] = (int)(Math.random() * rang);
		}

		//在排序前打印时间
		Calendar calendar = Calendar.getInstance();
		System.out.println("冒泡排序法排序前的时间：" + calendar.getTime());
		long time1 = System.currentTimeMillis();
		BubbleSort.sort(arrBubble);
		long time2 = System.currentTimeMillis();
		calendar = Calendar.getInstance();
		System.out.println("冒泡排序法排序后的时间：" + calendar.getTime());
		System.out.println("冒泡排序法排序需要时间：" + (time2 - time1) + "毫秒=" + (double)(time2 - time1) / 1000 + "秒");

		//用选择排序法进行排序
		int arrSelect[] = new int[len];
		//用随机数给数组赋值
		for(int i = 0; i < arrSelect.length; i++) {
			arrSelect[i] = (int)(Math.random() * rang);
		}

		//在排序前打印时间
		calendar = Calendar.getInstance();
		System.out.println("\n选择排序法排序前的时间：" + calendar.getTime());
		long time3 = System.currentTimeMillis();
		SelectSort.sort(arrSelect);
		long time4 = System.currentTimeMillis();
		calendar = Calendar.getInstance();
		System.out.println("选择排序法排序后的时间：" + calendar.getTime());
		System.out.println("选择排序法排序需要时间：" + (time4 - time3) + "毫秒=" + (double)(time4 - time3) / 1000 + "秒");

		//用插入排序法进行排序
		int arrInsert[] = new int[len];
		//用随机数给数组赋值
		for(int i = 0; i < arrInsert.length; i++) {
			arrInsert[i] = (int)(Math.random() * rang);
		}

		//在排序前打印时间
		calendar = Calendar.getInstance();
		System.out.println("\n插入排序法排序前的时间：" + calendar.getTime());
		long time5 = System.currentTimeMillis();
		InsertSort.sort(arrInsert);
		long time6 = System.currentTimeMillis();
		calendar = Calendar.getInstance();
		System.out.println("插入排序法排序后的时间：" + calendar.getTime());
		System.out.println("插入排序法排序需要时间：" + (time6 - time5) + "毫秒=" + (double)(time6 - time5) / 1000 + "秒");

		//输出排序后序列
		/*
		 * System.out.println("\n排序后序列：");
		 * for(int i=0;i<arrInsert.length;i++){
		 * System.out.print(arrInsert[i]+"、");
		 * }
		 */

		//输入要查找的数
		System.out.print("\n\n请输入要查找的数N(数组中的随机数范围为 0<=N<" + rang + "):");
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s_n = br.readLine();
		int n = Integer.parseInt(s_n);

		//顺序法查找排序后的一个数
		//查找前打印时间
		calendar = Calendar.getInstance();
		System.out.println("\n顺序法查找前的时间：" + calendar.getTime());
		long time9 = System.currentTimeMillis();
		OrderFind.orderFind(n, arrInsert);
		long time10 = System.currentTimeMillis();
		calendar = Calendar.getInstance();
		System.out.println("\n顺序法查找后的时间：" + calendar.getTime());
		System.out.println("顺序法查找需要时间：" + (time10 - time9) + "毫秒=" + (double)(time10 - time9) / 1000 + "秒");

		//二分法查找排序后的一个数
		//查找前打印时间
		calendar = Calendar.getInstance();
		System.out.println("\n二分法查找前的时间：" + calendar.getTime());
		System.out.print("二分法查找结果：");
		long time7 = System.currentTimeMillis();
		BinaryFind.binaryFind(n, arrInsert);
		long time8 = System.currentTimeMillis();
		//判断数组中是否存在要找的数
		if (BinaryFind.isB()) {
			BinaryFind.extracted();
		} else {
			//输出全部找出的数（在数组中要寻找的数可能有多个）
			//首先找出重复的第一个数的下标
			int temp = BinaryFind.middleIndex;
			do {
				temp--;
				//判断是否超出数组界限
				if (temp < 0) {
					break;
				}
			} while(arrInsert[temp] == n);

			for(int temp1 = temp + 1; arrInsert[temp1] == n; temp1++) {
				System.out.print("arr[" + temp1 + "]=" + n + "、");
			}
		}
		calendar = Calendar.getInstance();
		System.out.println("\n二分法查找后的时间：" + calendar.getTime());
		System.out.println("二分法查找需要时间：" + (time8 - time7) + "毫秒=" + (double)(time8 - time7) / 1000 + "秒");
	}
}

