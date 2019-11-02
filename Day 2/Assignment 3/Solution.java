import java.util.*;

/**
 * Solution class is the implementation.
 * @author Bhuvan
 */
class Solution {
	public static String isMatching(String str) {
		// fill you code Here
		// Stack<Character> stack = new Stack<>();
		LinkedListStack stack = new LinkedListStack();
		int n = str.length();
		int countPush = 0;
		int countPop = 0;
		if (str.charAt(0) == ')' || str.charAt(0) == ']' || str.charAt(0) == '}') {
			return "NO";
		}
		for(int i = 0; i < n; i++) {
			if(str.charAt(i)=='(' || str.charAt(i)=='['  || str.charAt(i)=='{') {
				stack.push(str.charAt(i));
				countPush += 1;
			}
			else if (str.charAt(i) == ')') {
				if (stack.head.item == '(') {
					stack.pop();
					countPop += 1;
				}
				else return "NO";
			}
			else if (str.charAt(i) == ']') {
				if (stack.head.item == '[') {
					stack.pop();
					countPop += 1;
				}
				else return "NO";
			}
			else if (str.charAt(i) == '}') {
				if (stack.head.item == '{') {
					stack.pop();
					countPop += 1;
				}
				else return "NO";
			}
		}
		if (countPush == countPop) {
			return "YES";
		}
		return "NO";
	}
}