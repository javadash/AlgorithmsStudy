package q1576;

import java.util.Stack;

public class SolutionB {
	public String modifyString(String s) {
		char[] strarr = s.toCharArray();
		Stack<Character> myStack = new Stack<>();
		for (int i = 0; i < strarr.length; i++) {
			if (strarr[i] == '?') {
				for (char c = 'a'; c <= 'z'; c++) {
					char next = i < strarr.length - 1 ? strarr[i] : '-';
					if (!myStack.isEmpty() && c == myStack.peek())
						continue;
					if (c == next)
						continue;
					strarr[i] = c;
					myStack.push(c);
					break;
				}
			} else {
				myStack.push(strarr[i]);
			}
		}
		return new String(strarr);
	}

}
