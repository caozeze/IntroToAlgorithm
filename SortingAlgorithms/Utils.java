package SortingAlgorithms;

/**
 * @program: Algorithms
 * @description: utils
 * @author: Gray
 * @create: 2021-05-17 12:57
 **/

public class Utils {
	public static void swap(int[] array, int index1, int index2) {
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}
}
