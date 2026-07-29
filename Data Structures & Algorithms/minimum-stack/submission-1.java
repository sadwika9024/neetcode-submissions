class MinStack {

    Stack<Integer> st;
    Stack<Integer> minSt;

    public MinStack() {
        st = new Stack<>();
        minSt = new Stack<>();
    }
    
    public void push(int val) {
        st.push(val);
        
        if(!minSt.isEmpty() && minSt.peek() < val){
            minSt.push(minSt.peek());
        }
        else{
            minSt.push(val);
        }
        
    }
    
    public void pop() {
        st.pop();
        minSt.pop();
        
    }
    
    public int top() {
       
        return st.peek();

    }
    
    public int getMin() {
        return minSt.peek();

    }
}
