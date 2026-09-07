class Solution {
    public void backtrack(int n,List<Character> current,List<String> ans,int openCount,int closeCount){

        if(n*2 == current.size())
        {
            StringBuilder sb = new StringBuilder();
            for (char c : current) {
                sb.append(c);
            }
            ans.add(sb.toString());
            return ;
        }
        for(char s : "()".toCharArray()){

            if(openCount < n && s=='(')
            {   
                current.add(s);
                backtrack(n,current,ans,openCount+1,closeCount);
            current.remove(current.size() - 1);        

            }
           else if(closeCount < openCount && s == ')'){
                current.add(s);
                backtrack(n,current,ans,openCount,closeCount+1);
            current.remove(current.size() - 1);        


            }

     
        }

    }
    public List<String> generateParenthesis(int n) {
        
        List<Character> current = new ArrayList<>();
        List<String> ans = new ArrayList<>();
        backtrack(n,current,ans,0,0);
        return ans;
    }
}
