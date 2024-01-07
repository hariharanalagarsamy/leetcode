/**
*reverse-words-in-a-string
Given an input string s, reverse the order of the words.

A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.

Return a string of the words in reverse order concatenated by a single space.

Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.

 

Example 1:

Input: s = "the sky is blue"
Output: "blue is sky the"
Example 2:

Input: s = "  hello world  "
Output: "world hello"
Explanation: Your reversed string should not contain leading or trailing spaces.

**/

class ReverseString {
    public String reverseWords(String s) {
        Stack<String> stack = new Stack<String>();
        s = s.trim();
     /**   char[] arr = s.toCharArray();
        StringBuilder sb1 = new StringBuilder();
        for(int i=0;i<arr.length;i++){
            if(arr[i] != ' '){
                sb1.append(arr[i]);
            }
            else if(!sb1.isEmpty()){
                stack.push(sb1.toString());
                stack.push(" ");
                sb1 = new StringBuilder();
            }
        }
        stack.push(sb1.toString());
        */
        String[] arr = s.split(" ");
        stack.push(arr[0]);
        for(int i=1;i<arr.length;i++){
           if(!( arr[i].equals(" ") || arr[i].isEmpty())){
               stack.push(" ");
               stack.push(arr[i]);
           }
        }
         
    
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.toString().trim();
    }
}
