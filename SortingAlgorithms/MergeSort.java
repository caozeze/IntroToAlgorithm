package SortingAlgorithms;

import java.util.Arrays;

/**
 * @program: Algorithms
 * @description: Merge-Sort
 * @author: Gray
 * @create: 2021-05-04 21:30
 **/

public class MergeSort {
	public static void CallMergeSort1(int[] array) {
		Merge_Sort1(array, 0, array.length - 1);
		// return Merge_Sort2(array);
	}

	public static void CallMergeSort2(int[] array) {
		// Merge_Sort1(array, 0, array.length - 1);
		Merge_Sort2(array, 0, array.length - 1);
	}

	public static int[] CallMergeSort3(int[] array) {
		return Merge_Sort3(array);
	}


	// relation: left <= mid < right
	public static void Merge_Sort1(int[] array, int left, int right) {
		// 1. we only do it when the right index beyonds left index, since when left == right,
		//    there will be only one element exist.
		if (left < right) {
			// 2. we separate from the middle
			int mid = (left + right) / 2;
			Merge_Sort1(array, left, mid);
			Merge_Sort1(array, mid + 1, right);
			// 3. after separate them respectively, we would merge them after comparison
			Merge1(array, left, mid, right);
		}
	}

	public static void Merge1(int[] array, int left, int mid, int right) {
		// 1. Reason of plus 1 in leftLen: length of array should be plus 1 if we used result of difference of indexes
		//E.g.If we have 52 cards, index in the start is 0, index of the last is 51, the difference of indexes is 51,
		//    but the length of total cards is 52.
		//    For rightLen, minus (mid+1) since (mid+1) is the start index of rightArray. Same reason for plus 1
		int leftLen = (mid - left) + 1;
		int rightLen = (right - (mid + 1)) + 1;
		// 2. we need an extra place to place "guard", the infinite value
		int[] LeftArr = new int[leftLen + 1];
		int[] RightArr = new int[rightLen + 1];
		// 3. we transfer the first half and the second half into new arrays(for later comparison)
		for (int i = 0; i < leftLen; i++) {
			LeftArr[i] = array[left + i];
		}
		for (int i = 0; i < rightLen; i++) {
			RightArr[i] = array[mid + i + 1];
		}
		// 4. "guard" should be in the last digit
		LeftArr[leftLen] = Integer.MAX_VALUE;
		RightArr[rightLen] = Integer.MAX_VALUE;
		// 5. set the initial index for both new arrays
		int i = 0, j = 0;
		// 6. we know that the last index of the array is "right", but the length of the array should be "right + 1"
		//    therefore, we would loop "right + 1" times starting from the index of "left"
		for (int k = left; k < right + 1; k++) {
			if (LeftArr[i] <= RightArr[j]) {
				array[k] = LeftArr[i];
				i++;
			} else {
				array[k] = RightArr[j];
				j++;
			}
		}
	}

	public static void Merge_Sort2(int[] array, int left, int right) {
		// 1. we only do it when the right index beyonds left index, since when left == right,
		//    there will be only one element exist.
		if (left < right) {
			// 2. we separate from the middle
			int mid = (left + right) / 2;
			Merge_Sort2(array, left, mid);
			Merge_Sort2(array, mid + 1, right);
			Merge2(array, left, mid, right);
		}
	}

	public static void Merge2(int[] array, int left, int mid, int right) {
		// 1. the length of the array should be right - left + 1,
		//    since the "right" is array.length - 1 when we call the method.
		int[] temp = new int[right - left + 1];
		// 2. left index, right index, and new array index.
		int i = left;
		int j = mid + 1;
		int k = 0;
		// 3. Comparison until any one of the array is finished
		while (i < mid && j < right) {
			if (array[i] < array[j]) {
				temp[k++] = array[i++];
			} else {
				temp[k++] = array[j++];
			}
		}
		// 4. if there are still remaining elements in one of the array, we would append the rest into our temp array
		while (i < mid + 1) {
			temp[k++] = array[i++];
		}
		while (j < right + 1) {
			temp[k++] = array[j++];
		}
		// 5. replace the original array by our temp array, "left" is used in case of the starting index is not 0.
		for (int index = 0; index < temp.length; index++) {
			array[index + left] = temp[index];
		}
	}

	public static int[] Merge_Sort3(int[] array) {
		int length = array.length;
		if (length <= 1) {
			return array;
		} else {
			int mid = (length) / 2;
			int[] leftArr = Merge_Sort3(Arrays.copyOfRange(array, 0, mid));
			int[] rightArr = Merge_Sort3(Arrays.copyOfRange(array, mid, length));
			return Merge3(leftArr, rightArr);
		}
	}

	public static int[] Merge3(int[] leftArr, int[] rightArr) {
		int leftLen = leftArr.length;
		int rightLen = rightArr.length;
		int[] newArray = new int[leftLen + rightLen];
		int i = 0, j = 0, k = 0;
		while (i < leftLen && j < rightLen) {
			if (leftArr[i] <= rightArr[j]) {
				newArray[k++] = leftArr[i++];
			} else {
				newArray[k++] = rightArr[j++];
			}
		}
		while (i < leftLen) {
			newArray[k++] = leftArr[i++];
		}
		while (j < rightLen) {
			newArray[k++] = rightArr[j++];
		}
		return newArray;
	}

	public static boolean test() {
		int[] testA = {1, 3, 4, 6};
		int[] testB = {5, 2, 4, 7};
		for (int i : testA) {
			for (int j : testB) {
				if (i == j) {
					return true;
				}
			}
		}
		return false;
	}

}
