package q1427;

public class Perform_String_Shifts {
	public String stringShift(String s, int[][] shift) {
		int num_base = s.length();
		if (num_base == 1) {
			return s;
		}
		
		char[] in = new char[num_base];
		char[] out = new char[num_base];
		
		char[] arr = s.toCharArray();
		for (int i = 0; i < num_base; i++) {
			int position = findPositionAfterShift(i, num_base , shift[i]);
			out[position] = in[i];
		}
		String str = new String(out);
		return s;
    }

	private int findPositionAfterShift(int i, int base, int[] js) {
		int index = i;
		if (js[0] == 0) {
			i = ((i - js[1] ) % base ) + base;
		} else if (js[0] == 1) {
			i = (i + js[1] ) % base;
		}
		return index;
	}

}
