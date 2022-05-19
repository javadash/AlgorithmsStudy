package com.algorithms;

import java.util.Deque;
import java.util.*;

public class Question20Parenthesis {
	public static boolean isValid(String s) {
		if (s.length() < 2 || s.length() % 2 == 1 )   {
			return false;
		}
		Map<Character, Character> brackets = new HashMap<Character, Character>(){{
			put('(', ')');
			put('{', '}');
			put('[', ']');
		}};
		Deque<Character> test = new ArrayDeque<Character>();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if(brackets.get(ch) != null) {
				test.push(ch);
			} else {
				Character top = test.peek();
				if(top != null && brackets.get(top) ==  ch) {
					test.pop();
				} else {
					return false;
				}
			}
		}
		if(test.size() == 0) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		String test1 = "){";
		boolean answer = false;
		boolean result = isValid(test1);
		if (result == answer) {
			System.out.println("Algorithm passed");
		} else {
			System.out.println("Algorithm failed");
		}
	}
	
}