package Chap01_Arrays_and_Strings.chap1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FastScanner {
	StringTokenizer st;
	BufferedReader br;
	
	FastScanner (InputStream inputStream) {
		try {
			br = new BufferedReader(new InputStreamReader(inputStream));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	int nextInt() {
		return Integer.parseInt(next());
	}
	
	String next() {
		while (st == null || !st.hasMoreTokens()) {
			try {
				st = new StringTokenizer(br.readLine());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return st.nextToken();
	}
}