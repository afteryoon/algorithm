class Solution {
    public int solution(int a, int b) {
        int ab2 = 2 * a * b;
        int ab = Integer.parseInt(""+a+b);
    
        return ab2 > ab ? ab2 : ab;
    }
}