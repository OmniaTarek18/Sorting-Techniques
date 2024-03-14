import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nPlease enter the file path: ");
        String filePath = sc.nextLine();

        File file = new File(filePath);
        if (file.exists()) {
            int choice;
            do {
                System.out.println("Choose one of the following methods of sorting:\n1: Insertion sort ( O(n^2) )\n2: Merge sort ( O(n log n) )\n3: Counting sort ( O(n) )\n4: Exit");
                choice = sc.nextInt();
                sc.nextLine();
                Sort_Array sort = new Sort_Array(file);
                switch (choice) {
                    case 1:
                        System.out.println("Do you want intermediate arrays? (y / n)");
                        String ans = sc.nextLine();
                        if (ans.equalsIgnoreCase("y")){
                            sort.simpleSort(true);
                        }
                        else if (ans.equalsIgnoreCase("n")) {
                            System.out.println(sort.simpleSort(false));                        }
                        break;
                    case 2:
                        System.out.println("Do you want intermediate arrays? (y / n)");
                        ans = sc.nextLine();
                        if (ans.equalsIgnoreCase("y")){
                            sort.efficientSort(true);
                        }
                        else if (ans.equalsIgnoreCase("n")) {
                            System.out.println(sort.efficientSort(false) );                        }
                        break;
                    case 3:
                        System.out.println("Do you want intermediate arrays? (y / n)");
                        ans = sc.nextLine();
                        if (ans.equalsIgnoreCase("y")){
                            sort.nonComparisonSort(true);
                        }
                        else if (ans.equalsIgnoreCase("n")) {
                            System.out.println(sort.nonComparisonSort(false));
                        }
                        break;
                    default:
                        break;
                }
            }
            while(choice != 4);
        } else {
            System.out.println("File does not exist or invalid path.");
            sc.close();
            return;
        }
        sc.close();
    }
}
