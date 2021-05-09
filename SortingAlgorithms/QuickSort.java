package SortingAlgorithms;

/**
 * @program: Algorithms
 * @description: quicksort
 * @author: Gray
 * @create: 2021-05-08 12:00
 **/

public class QuickSort {
	public static void CallQuickSort(int[] array) {
		Quick_Sort(array, 0, array.length - 1);
	}

	public static void Quick_Sort(int[] array, int left, int right) {
		// 1. Similar to MergeSort, we only do divide if the left index is smaller than right index
		if (left < right) {
			// 2. we first need to select a pivot, and by the method Partition,
			//    the original array would be separated into two arrays by pivot
			//    (one for elements smaller than pivot, one for elements greater than pivot)
			int q = Partition(array, left, right);
			// 3. we can do recursion until there is nothing to determine.
			Quick_Sort(array, left, q - 1);
			Quick_Sort(array, q + 1, right);
		}
	}

	public static int Partition(int[] array, int left, int right) {
		// 1. q represents the right most element in the array, i is located in the left of index "left"
		int q = array[right];
		int i = left - 1;
		// 2. temp used to swap the value of elements
		int temp;
		// 3. we do loops, but the loop number is right - left,
		//    which is different with MergeSort since q is used to compare the value of element. (we don't include q)
		for (int j = left; j < right; j++) {
			// 4. if array[j] is smaller or equals to q, we add 1 to i, and swap element in index i and j
			if (array[j] <= q) {
				i++;
				temp = array[i];
				array[i] = array[j];
				array[j] = temp;
			}
		}
		// 5. swap the element in i+1 and q, (i+1) is used since element index smaller or equals to i is smaller to q
		temp = array[i + 1];
		array[i + 1] = array[right];
		array[right] = temp;
		return i + 1;
	}
}
