//https://leetcode.com/problems/move-zeroes/solutions/172432/the-easiest-but-unusual-snowball-java-solution-beats-100-o-n-clear-explanation
//https://leetcode.com/problems/move-zeroes/description/?envType=study-plan-v2&envId=leetcode-75

class MoveZeros {
    public void moveZeroes(int[] nums) {
        //can be done with snowball rolling approach
        int n = nums.length;
        if(n == 1){
            return;
        }
        int snowball = 0; //counts the no of zero's grouped together
        for(int i=0;i<n;i++){
            if(nums[i] == 0){
                snowball++;
            }
            else if(snowball > 0) { //zero exists
                nums[i-snowball] = nums[i]; 
                nums[i] = 0;
            }
        }
      
    }
}
