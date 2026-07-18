class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxSpeeed  =0;
        int minSpeed = 1;
        for(int i=0;i<piles.length;i++)
            maxSpeeed = Math.max(maxSpeeed,piles[i]);


        // int speed = 0;
        while(minSpeed<maxSpeeed){
                
                int mid = minSpeed + (maxSpeeed-minSpeed)/2;
                int hours = 0;
                for(int i=0;i<piles.length;i++){
                    hours += (piles[i]+mid-1)/mid;
                }
                if(hours <= h)
                    maxSpeeed = mid;
                else
                    minSpeed = mid+1;
                
            

        }

        return minSpeed;
        
    }
}
