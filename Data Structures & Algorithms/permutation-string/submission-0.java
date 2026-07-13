class Solution {
    public boolean compare(int [] s1_arr,int [] s2_arr){
        for(int i=0;i<s1_arr.length;i++)
        {
            if(s1_arr[i]!=s2_arr[i])
                return false;
        }
        return true;
    }
    public boolean checkInclusion(String s1, String s2) {

        int window = s1.length();
        int [] s1_arr = new int[26];
        int [] s2_arr = new int[26];
        int left = 0;
        for(int i= 0;i<s1.length();i++)
        {
            s1_arr[s1.charAt(i)-'a']++;
        }

        for(int right = 0;right<s2.length();right++){

            s2_arr[s2.charAt(right)-'a']++;
            
            if(right-left+1>window){
                s2_arr[s2.charAt(left)-'a']--;
                left++;
               
            }
            if(right-left+1==window){
                boolean ans = compare(s1_arr,s2_arr);
                 if(ans)
                    return true;
            }

        }

        
    return false;
        
    }
}
