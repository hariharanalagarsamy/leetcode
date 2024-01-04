/**
* https://leetcode.com/problems/merge-intervals
Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and 
return an array of the non-overlapping intervals that cover all the intervals in the input.
Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
*/
class Solution {
    public int[][] merge(int[][] intervals) {

        List<int[]> answer = new ArrayList<>();
        int length = intervals.length;
        if(length == 1) {
            return intervals;
        }
      //sort based on the start-i
        Arrays.sort(intervals,(a , b) -> {
            return a[0] - b[0];
        });
        int min = intervals[0][0];
        int max = intervals[0][1];
        for(int i=1;i<length;i++){
            if(intervals[i][0] <= max){
                max = Math.max(intervals[i][1],max);
            }
            else{
                answer.add(new int[] {min,max});
                min = intervals[i][0];
                max = intervals[i][1];
            }
        }
        answer.add(new int[] {min,max});
        int [][] result = new int[answer.size()][2];
        for(int i=0;i<answer.size();i++){
            result[i] = answer.get(i);
        }

        return result;
        
    }
}
