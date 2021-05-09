package SortingAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * @program: Algorithms
 * @description: Insertion-Sort
 * @author: Gray
 * @create: 2021-05-02 21:46
 **/

public class InsertionSort {
	public static void Insertion_Sort(int[] array) {
		// 1. The index j is set to 1, since we would start from the second card draw.
		for (int j = 1; j < array.length; j++) {
			// 2. temp is used to record the current card(new element).
			int temp = array[j];
			// 3. record the last index(element in the right most) of ordered elements
			int i = j - 1;
			// 4. we set i >= 0 here to represent that there has at least one element,
			// since index (i > 0) in pseudocode means if there exists at least one element.
			while (i >= 0 && array[i] > temp) {
				array[i + 1] = array[i];
				i--; // 5. represents i = i - 1
			}
			array[i + 1] = temp;
		}
	}
}
