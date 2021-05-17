package SortingAlgorithms;

/**
 * @program: Algorithms
 * @description: bubble sort
 * @author: Gray
 * @create: 2021-05-08 16:46
 **/

public class BubbleSort {
	public static void Bubble_Sort(int[] array) {
		// 1. Set the length of array into a variable(avoid to call attribute or method repeatedly),
		//    set a temp for later swap
		int length = array.length;
		int temp;
		// 2. for array with length 4, we only need 3 loops,
		//    therefore for array with length n, we only need n-1 loops
		for (int i = 0; i < length - 1; i++) {
			// 3. after we determine the maximum element in the current loop,
			//    it is not necessary to include it in the next loop
			for (int j = 0; j < length - i - 1; j++) {
				if (array[j] > array[j + 1]) {
					Utils.swap(array,j,j + 1);
					// temp = array[j];
					// array[j] = array[j + 1];
					// array[j + 1] = temp;
				}
			}
		}
	}

	public static void BubbleSort_Optimized(int[] array) {
		// 1. Set the length of array into a variable(avoid to call attribute or method repeatedly),
		//    set a temp for later swap
		int length = array.length;
		int temp;
		// 2. for array with length 4, we only need 3 loops,
		//    therefore for array with length n, we only need n-1 loops
		for (int i = 0; i < length - 1; i++) {
			// 3. set a flag to observe the happening of swap, if no swap happened, we would end our program
			boolean Flag = false;
			// 4. after we determine the maximum element in the current loop,
			//    it is not necessary to include it in the next loop
			for (int j = 0; j < length - i - 1; j++) {
				if (array[j] > array[j + 1]) {
					Utils.swap(array,j,j + 1);
					// temp = array[j];
					// array[j] = array[j + 1];
					// array[j + 1] = temp;
					Flag = true;
				}
			}
			if (!Flag) {
				break;
			}
		}
	}
}
