package SortingAlgorithms;

import java.util.Arrays;

/**
 * @program: Algorithms
 * @description: heapsort, 本文放在这里只是为了暂时展示，教学部分后续会更改注释
 * @author: Gray
 * @create: 2021-05-16 22:14
 **/

public class HeapSort {

	public static int LeftNode(int index) {
		return 2 * index + 1;
	}

	public static int RightNode(int index) {
		return 2 * index + 2;
	}

	public static void Max_Heapify(int[] array, int index, int heapSize) {
		int leftIndex = LeftNode(index);
		int rightIndex = RightNode(index);
		int largestIndex = leftIndex;
		if (leftIndex > heapSize)
			return; // 左子节点索引超出计算范围，直接返回。
		if (rightIndex <= heapSize && array[rightIndex] > array[leftIndex]) // 先判断左右子节点，哪个较大。
			largestIndex = rightIndex;
		if (array[largestIndex] > array[index]) {
			Utils.swap(array, largestIndex, index); // 如果父节点被子节点调换，
			Max_Heapify(array, largestIndex, heapSize); // 则需要继续判断换下后的父节点是否符合堆的特性。
		}
	}

	public static void BuildMaxHeap(int[] array) {
		int length = array.length - 1;//index的最后一位
		for (int i = (length - 1) / 2; i >= 0; i--) {
			Max_Heapify(array, i, length);
		}
	}

	public static void Heap_Sort(int[] array) {
		BuildMaxHeap(array);
		int heapSize = array.length - 1;
		//exchange with the last array
		for (int i = heapSize; i > 0; i--) {
			Utils.swap(array, i, 0);
			Max_Heapify(array, 0, i - 1);
		}
	}


}
