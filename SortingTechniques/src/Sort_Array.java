import java.util.ArrayList;
import java.util.List;

public class Sort_Array {
	
    List<Integer> array;

    //constructor to initialize the array from a file
    public Sort_Array() {
        
    }

    // Simple Sort (Insertion sort) O(n2)
    public List<Integer> simpleSort(boolean intermediate) {
    	List<Integer> sortedArray = new ArrayList<>(array);
    	insertionSort(sortedArray, intermediate);
    	return sortedArray;
    }

    public static void insertionSort(List<Integer> list, boolean intermediate) {
        if (intermediate) {
            System.out.println(list); // Print the list before sorting
        }
        for (int i = 1; i < list.size(); i++) {
            int temp = list.get(i);
            int j = i - 1;
            while (j >= 0 && list.get(j) > temp) {
                list.set(j + 1, list.get(j));
                j--;
            }
            list.set(j + 1, temp);
            if (intermediate) {
                System.out.println(list);
            }
        }
		
	}

    // Efficient Sort (Merge Sort) O(n lg n)
    public List<Integer> efficientSort(boolean intermediate) {
        List<Integer> sortedArray = new ArrayList<>(array);
        mergeSort(sortedArray, intermediate);
        return sortedArray;
    }

    public static void mergeSort(List<Integer> list, boolean intermediate) {
    	
        if (intermediate) {
            System.out.println(list); // Print the list before sorting
        }
        int length = list.size();
        // base case
        if (length <= 1)
            return;

        int middle = length / 2;

        List<Integer> leftList = new ArrayList<>(list.subList(0, middle));
        List<Integer> rightList = new ArrayList<>(list.subList(middle, length));

        mergeSort(leftList, intermediate);
        mergeSort(rightList, intermediate);

        merge(leftList, rightList, list, intermediate);
    }

    public static void merge(List<Integer> leftList, List<Integer> rightList, List<Integer> list, boolean intermediate) {
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

        if (intermediate) {
            System.out.println(list);
        }
    }


    // Non-Comparison Sort O(n) 
    public void nonComparisonSort(boolean intermediate) {

    }

}