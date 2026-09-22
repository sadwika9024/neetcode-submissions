class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n+1];
        for(int i=0;i<=n;i++)
        {
            ans[i] = count1(i);
        }

        return ans;
    }

    public int count1(int n){
        int count=0;
        while(n>0){
            if(n%2==1)
                count+=1;
            n = n/2;
        }
    return count;

    }
}
