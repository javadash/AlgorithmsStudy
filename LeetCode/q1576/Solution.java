package q1576;

public class Solution {
    public String modifyString(String s) {
        char[] carr = s.toCharArray();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i <s.length();i++) {
            if(carr[i] == '?') {
                char prev = i > 0 ? s.charAt(i-1) : '-';
                char next = i < s.length() - 1 ?  s.charAt(i+1) : '-';
                char curr = 'a'; 
                while(curr == prev || curr == next) {
                    curr++;
                }
                sb.append(curr);
            } else {
                sb.append(s.charAt(i));
            }
            
        }
        return sb.toString();

    }
}
