class Solution {
    public boolean isAnagram(String s, String t) {

        int [] count = new int[26];
        if(s.length() != t.length())
            return false;

        else{

            for(int i=0;i<t.length();i++){

                count[s.charAt(i)-'a']++;
                count[t.charAt(i)-'a']--;

            }

            for(int c: count){
                if(c!=0)
                    return false;
            }

            return true;

        }

        //return false;
    }
}
