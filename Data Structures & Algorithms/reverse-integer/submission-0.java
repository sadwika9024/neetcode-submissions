class Solution {
    public int reverse(int x) {

        long y=0;
        while(x!=0)
        {
            int rem=x%10;
            y=y*10+rem;
            x=x/10;  
        }
        return (y > Integer.MAX_VALUE || y < Integer.MIN_VALUE)? 0 : (int)y; 
    }
        
    
}
