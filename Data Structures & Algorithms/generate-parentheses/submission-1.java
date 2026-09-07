class Solution {
    public void backtrack(int n,StringBuilder current,List<String> ans,int openCount,int closeCount){

        if(n*2 == current.length())
        {
            ans.add(current.toString());
            return ;
        }

            if(openCount < n )
            {   
                current.append('(');
                backtrack(n,current,ans,openCount+1,closeCount);
            current.setLength(current.length() - 1);        

            }
            if(closeCount < openCount){
                current.append(')');
                backtrack(n,current,ans,openCount,closeCount+1);
            current.setLength(current.length() - 1);        


            }

     
        }

    
    public List<String> generateParenthesis(int n) {
        
        
        List<String> ans = new ArrayList<>();
        backtrack(n,new StringBuilder(),ans,0,0);
        return ans;
    }
}
