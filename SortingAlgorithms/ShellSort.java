package SortingAlgorithms;

/**
 * @program: Algorithms
 * @description: shellSort
 * @author: Gray
 * @create: 2021-05-08 21:46
 **/

public class ShellSort {
	public static void Shell_Sort(int[] array) {
		// 1. we set length of array into a variable(avoid to call attributes or methods repeatedly)
		//    the temp is used to swap later.
		int length = array.length;
		int temp;
		// 2. Gap is used help the transition, since each time we fold the gap by 2,
		//    we set the condition here with gap > 0(when the gap == 1, 1/2 by java = 0, loop will be paused)
		for (int gap = length / 2; gap > 0; gap /= 2) {
			// 3. the rest lines are as same as to insertion sort,
			//    but the only different is that we used "gap" to replace the "1".(for quick move.)
			for (int j = gap; j < length; j++) {
				temp = array[j];
				int i = j - gap;
				while (i >= 0 && array[i] > temp) {
					array[i + gap] = array[i];
					i -= gap;
				}
				array[i + gap] = temp;
			}
		}
	}
}
