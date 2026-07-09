class Solution {
    public int lengthOfLongestSubstring(String s) {


        HashSet<Character> hs = new HashSet<>();
        int left=0;
        int right=0;
        int max = 0;
        while(right<=s.length()-1){

            if(!hs.contains(s.charAt(right))){
                hs.add(s.charAt(right));
                max = Math.max(max, right-left+1);
                right++;
            }
            else
            {
                hs.remove(s.charAt(left));
                left++;
            }

        }

        return max;

        
    }
}
