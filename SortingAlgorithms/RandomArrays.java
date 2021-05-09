package SortingAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * @program: Algorithms
 * @description: random arrays, used to test algorithms
 * @author: Gray
 * @create: 2021-05-02 21:47
 **/

public class RandomArrays {
	public static void main(String[] args) {
		Random random = new Random();
		int[] test = new int[20];

		for (int i = 0; i < 20; i++) {
			test[i] = random.nextInt(300);
		}

		System.out.println(Arrays.toString(test));
		ShellSort.Shell_Sort(test);
		System.out.println(Arrays.toString(test));
		// test = new int[]{1, 3, 2, 4, 5, 2};
		// BubbleSort.Bubble_Sort(test);

		// int[] ints = Arrays.copyOf(test, test.length);
		// CompareMergeQuick(test);
		// MergeSortTest(ints);
	}

	public static void CompareMergeQuick(int[] test){
		int[] ints = Arrays.copyOf(test, test.length);
		long startTime = System.nanoTime();   //获取开始时间
		MergeSort.CallMergeSort2(test);
		System.out.println(Arrays.toString(test));
		long endTime = System.nanoTime(); //获取结束时间
		System.out.println("归并优化运行时间： " + (endTime - startTime) + "ns");

		startTime = System.nanoTime();   //获取开始时间
		QuickSort.CallQuickSort(ints);
		System.out.println(Arrays.toString(ints));
		endTime = System.nanoTime(); //获取结束时间
		System.out.println("快排运行时间： " + (endTime - startTime) + "ns");
	}



	public static void MergeSortTest(int[] test) {
		long startTime = System.nanoTime();   //获取开始时间
		int[] ints = MergeSort.CallMergeSort3(test);
		System.out.println(Arrays.toString(ints));
		long endTime = System.nanoTime(); //获取结束时间
		System.out.println("简化版本运行时间： " + (endTime - startTime) + "ns");

		startTime = System.nanoTime();   //获取开始时间
		MergeSort.CallMergeSort1(test);
		System.out.println(Arrays.toString(test));
		endTime = System.nanoTime(); //获取结束时间
		System.out.println("算法导论运行时间： " + (endTime - startTime) + "ns");

		startTime = System.nanoTime();   //获取开始时间
		MergeSort.CallMergeSort2(test);
		System.out.println(Arrays.toString(test));
		endTime = System.nanoTime(); //获取结束时间
		System.out.println("优化运行时间： " + (endTime - startTime) + "ns");
	}

}
