import java.io.*;

class Solution {
    public String solution(String code) {
        StringBuilder ret = new StringBuilder();
        boolean mode = false; // false for mode 0, true for mode 1

        for (int i = 0; i < code.length(); i++) {
            char ch = code.charAt(i);
            if (ch == '1') {
                mode = !mode;
            } else if ((i % 2 == 0) != mode) {
                ret.append(ch);
            }
        }

        return ret.length() == 0 ? "EMPTY" : ret.toString();
    }
}