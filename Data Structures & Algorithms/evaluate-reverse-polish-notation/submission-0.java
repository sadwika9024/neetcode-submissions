class Solution {
    public int evalRPN(String[] tokens) {

        Stack<Integer> st = new Stack<>();
        int ans = 0;

        for(int i=0;i<tokens.length;i++){
            if(!tokens[i].equals("+") && !tokens[i].equals("-") && !tokens[i].equals("*") &&
            !tokens[i].equals("/"))
                st.push(Integer.parseInt(tokens[i]));
            else{
                int value1 = st.pop();
                int value2 = st.pop();
                String symbol = tokens[i];
                if(symbol.equals("+") )
                    st.push(value1+value2);
                if(symbol.equals("-") )
                    st.push(value2-value1);
                if(symbol.equals("*") )
                    st.push(value2*value1);
                if(symbol.equals("/") )
                    st.push(value2/value1); 
            }

        }
        return st.pop();
        
    }
}
