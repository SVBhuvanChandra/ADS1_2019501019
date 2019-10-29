import java.util.*;
public class SortedArray {
    public static void main(String[] args) {
        int [] x = {1,3,5,7,9};
        int [] y = {2,4,6,8,10,12,14};
        int [] z = new int[x.length + y.length];
        int j = 0;
        int k = 0;
        int k1;
        int j1;
        int flag = 0;
        int size = 0;
        for (int i = 0; i < z.length; i++) {
            if (x[j] <= y[k]) {
                z[size++] = x[j];
                j++;
                if (j == x.length) {
                    flag = 1;
                    break;
                }
            } else {
                z[size++] = y[k];
                k++;
                if (k == y.length) {
                    flag = 2;
                    break;
                }
            }
        }
        if (flag == 1) {
            j1 = j;
            for (int p1 = k; p1 < z.length-j1; p1++) {
                z[j+k] = y[p1];
                j++;
            }
        } else if (flag == 2) {
            k1 = k;
            for (int p = j; p < z.length-k1; p++) {
                z[k+j] = x[p];
                k++; 
            }
        }
        System.out.println(Arrays.toString(z));
    }
}
