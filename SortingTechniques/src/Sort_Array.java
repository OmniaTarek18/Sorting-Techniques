import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sort_Array {
	
    List<Integer> array;

    //constructor to initialize the array from a file
    public Sort_Array(File file) {
        try {
            Scanner sc = new Scanner(file);
            String str = sc.nextLine();
            String[] arrStrings = str.split(",");
            if (arrStrings.length == 1 && arrStrings[0].isEmpty())
                array = new ArrayList<Integer>(){};
            else {
                array = new ArrayList<Integer>();
                for(int i = 0; i < arrStrings.length; i++){
                    array.add(Integer.parseInt(arrStrings[i]));
                }
            }
            sc.close();
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }

    public Sort_Array() throws Exception {
        System.out.println("This");
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


     // Non-Comparison Sort (Counting Sort) O(n) 
     public List<Integer> nonComparisonSort(boolean intermediate) {
        List<Integer> sortedArray = new ArrayList<>(array);
    	sortedArray = countingSort(sortedArray, intermediate);
    	return sortedArray;
    }

    public ArrayList<Integer> countingSort(List<Integer> list,boolean printSteps){
        ArrayList<Integer> res = new ArrayList<>();
        int [] countingArr = new int[maxNum(list) + 1];

        for(int num : list) countingArr[num] ++;

        // Compute prefix sum of counting array
        prefixSum(countingArr);

        // Initialize res with zeros
        for(int i = 0; i <list.size(); i++) res.add(null);

        for(int i = list.size() - 1; i >= 0; i--){
            int index = countingArr[list.get(i)];
            res.set(index - 1, list.get(i)); // Decrement index by 1 to get the position of the element
            countingArr[list.get(i)] =  index - 1; // Decrement index by 1 and save it in countingArr
            if(printSteps) System.out.println(res);
        }
        return res;
    }

    private int maxNum(List<Integer> list) {
        int max = Integer.MIN_VALUE;
        for(int num : list){
            max = Math.max(max, num);
        }
        return max;
    }

    private void prefixSum(int [] arr){
        for(int i = 1; i < arr.length; i++){
            arr[i]  += arr[i -1];
        }
    }

}