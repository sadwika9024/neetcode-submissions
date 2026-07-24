class MinStack {
    Stack<int[]> st ;

    public MinStack() {

        st = new Stack<>();
        
    }
    
    public void push(int val) {
        if(st.isEmpty())
            st.push(new int[]{val,val});

         else {
            // Compare new value with the current minimum at the top of the stack
            int currentMin = Math.min(val, st.peek()[1]);
            st.push(new int[]{val, currentMin});
        }
        
    }
    
    public void pop() {
        if(!st.isEmpty())
            st.pop();
    }
    
    public int top() {

         return st.peek()[0];
    }
    
    public int getMin() {
         return st.peek()[1];
    }
}
