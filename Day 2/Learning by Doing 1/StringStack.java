import java.io.*;
import java.util.*;
public class StringStack {
    public static void main(String[] args) {
        String s = "it was - the best - of times - - - it was - the - -";
        Stack <String> a = new Stack<>();
        String[] sa = s.split(" ");
        for (int i = 0; i < sa.length; i++) {
            if (sa[i].equals("-")) {
                a.pop();
            } else {
                a.push(sa[i]);
            }
        }
        System.out.println("\nThe output in java stack is : " + a);

    }
}