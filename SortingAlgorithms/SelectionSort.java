package SortingAlgorithms;

/**
 * @program: Algorithms
 * @description: selectionSort, 教程不教选择排序，这里有放可以看一下代码
 * @author: Gray
 * @create: 2021-05-12 19:38
 **/

public class SelectionSort {
	public void Selection_Sort(int[] array) {
		int n = array.length;
		for (int i = 0; i < n - 1; i++) {
			int min = i;
			for (int j = i + 1; j < n; j++) {
				if (array[j] < array[min]) {
					min = j;
				}
			}
			Utils.swap(array, i, min);
		}
	}
}
