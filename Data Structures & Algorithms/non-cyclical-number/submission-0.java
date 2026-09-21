class Solution {
    public boolean isHappy(int n) {


        int slow = n;
        int fast = n ;
        do{
            slow = square(slow);
            fast = square(square(fast));
        }while(slow!=fast);

        return slow==1;    
    }

    public int square(int n){
        int ans=0;
        while(n>0){
        int x = n%10;
         ans+= x*x;
        n = n/10;
        }
    return ans;
    }


}