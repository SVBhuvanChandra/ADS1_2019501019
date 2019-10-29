import java.util.*;
public class Pairs {
    public static void main (String[] args) {
        System.out.println("Enter no. of elements\n");
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements");
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        s.close();
        int count = 0;
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i] == arr[i+1]) {
                count++;
            }
        }
        System.out.println("\nThe no. of pairs : " + count);
    }
}