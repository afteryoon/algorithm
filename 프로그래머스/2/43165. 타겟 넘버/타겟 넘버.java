class Solution {
    public int solution(int[] numbers, int target) {
    
        return dfs(numbers,0,0,target);
    }
    
    public static int dfs(int[] nums,int i,int sum, int target) {
        int count = 0;
        if(i == nums.length) {
            if(target == sum) count++;
            return count;
        }
        int n = nums[i];
        count+= dfs(nums,i+1,sum+n,target);
        count+= dfs(nums,i+1,sum-n,target);
        
        return count;
    }
}