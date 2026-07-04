class Solution {
    public boolean isAlpha(char c){
        if('a'<=c && c<='z'|| 'A'<=c && c<='Z' || '0'<=c && c<='9')
            return true;

        return false;
    }
    public boolean isPalindrome(String s) {
        int i=0;
        int j= s.length()-1;
        s = s.toUpperCase();
        while(i<j){

            while(i<j && !isAlpha(s.charAt(i))){
                i++;
            }
            while(i<j && !isAlpha(s.charAt(j))){
                j--;
            }
            if(s.charAt(i)!=s.charAt(j))
                return false;
            
            i++;
            j--;

        }


       return true;
        
    }
}
