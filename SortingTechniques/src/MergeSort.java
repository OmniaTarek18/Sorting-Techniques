import java.util.ArrayList;
import java.util.List;

public class MergeSort {
	public static void mergeSort(List<Integer> list) {

		int length = list.size();
		// base case
		if (length <= 1)
			return;

		int middle = length / 2;

		List<Integer> leftList = new ArrayList<>(list.subList(0, middle));
		List<Integer> rightList = new ArrayList<>(list.subList(middle, length));

		mergeSort(leftList);
		mergeSort(rightList);
		merge(leftList, rightList, list);

	}

	public static void merge(List<Integer> leftList, List<Integer> rightList, List<Integer> list) {
		int leftSize = leftList.size();
		int rightSize = rightList.size();
		int i = 0, l = 0, r = 0; 

		// check the conditions for merging
		while (l < leftSize && r < rightSize) {
			if (leftList.get(l) < rightList.get(r)) {
				list.set(i, leftList.get(l));
				i++;
				l++;
			} else {
				list.set(i, rightList.get(r));
				i++;
				r++;
			}
		}
		while (l < leftSize) {
			list.set(i, leftList.get(l));
			i++;
			l++;
		}
		while (r < rightSize) {
			list.set(i, rightList.get(r));
			i++;
			r++;
		}

	}

}