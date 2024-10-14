class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        boolean fa = a % 2 ==0;
        boolean fb = b % 2 ==0;
        if(!fa && !fb)
            answer=a*a+b*b;
        else if(fa && fb)
            answer = a-b <0 ? Math.abs(a-b) : a-b ;
        else
            answer = 2*(a+b);
        return answer;
    }
}