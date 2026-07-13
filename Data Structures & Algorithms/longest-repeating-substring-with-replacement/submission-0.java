class Solution {
    public int characterReplacement(String s, int k) {

    // any doubt check this video "https://www.youtube.com/watch?v=ExY8svHF_Eo"
        int maxWindowSize = 0;
        int windowSize = 0;
        int maxFrequency = 0 ;
        int left =0 ;
        int [] ans = new int [26];
        for(int right=0;right<s.length();right++)
        {
            
            ans[s.charAt(right)-'A']++;
            maxFrequency = Math.max(maxFrequency,ans[s.charAt(right)-'A']);
            windowSize = right+1-left;
           
                while(windowSize - maxFrequency > k )
                {
                    // these all are invalid cases , so no need to check maxlength
                    ans[s.charAt(left)-'A']--;
                    left++;
                    windowSize = right+1-left;
                }
                maxWindowSize = Math.max(maxWindowSize,windowSize);

        }
        return maxWindowSize;
    }
}
