class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
       StringBuilder currResult = new StringBuilder();
        helper(currResult,result,0,0,n);
        return result;
    }

    public void helper(StringBuilder currResult,List<String> result,int openCount,int closeCount, int n){
        if(openCount == closeCount && openCount == n ){
            result.add(currResult.toString());
            return;
        }
        if(openCount < n){
            currResult.append("(");
            helper(currResult,result,openCount + 1,closeCount,n);
            currResult.delete(currResult.length() - 1,currResult.length());
        }
        if(closeCount < openCount) {
            currResult.append(")");
            helper(currResult,result,openCount,closeCount+1,n);
            currResult.delete(currResult.length() - 1,currResult.length());
        }
        

    }
}
