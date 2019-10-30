import java.io.*;
import java.util.*;
class Solution{
	public static String isMatching(String str){
		// fill you code Here ..
		int flag1 = 2;
		int flag2 = 2;
		int flag3 = 2;
		char[] arr = str.toCharArray();
		Stack <Character> a = new Stack<>();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == '(' || arr[i] == '[' || arr[i] == '{') {
				a.push(arr[i]);
			} else {
				if (a.isEmpty()  == false && arr[i] == ')') {
					if (a.pop() == '(') {
						flag1 = 1;
					} else {
						flag1 = 0;
						break;
					}
				} else if (a.isEmpty()  == false && arr[i] == ']') {
					if (a.pop() == '[') {
						flag2 = 1;
					} else {
						flag2 = 0;
						break;
					}
				} else if (a.isEmpty()  == false && arr[i] == '}') {
					if (a.pop() == '{') {
						flag3 = 1;
					} else {
						flag3 = 0;
						break;
					}
				}
			}
		}
		if (flag1 != 0 && flag2 != 0 && flag3 != 0) {
			return "YES";
		} else {
			return "NO";
		}
	}
}
