class Solution {
    public boolean compare(HashMap<Character,Integer> hm_t,HashMap<Character,Integer> hm_s){
        int i=0;
       for (Map.Entry<Character, Integer> entry : hm_t.entrySet()) {
            
            char ch = entry.getKey();
            int requiredValue = entry.getValue();
            if(!hm_s.containsKey(ch) || hm_s.get(ch)<requiredValue)
                return false;

        }
        return true;

    }

    public String minWindow(String s, String t) {
        //if the other character orrurs tiwe also no issue but each of 
        //this character should be present 

        //approach we will find the 2 pointers where our complete string came and we will try to reduce the length

        HashMap<Character,Integer> hm_t = new HashMap<>();
        HashMap<Character,Integer> hm_s = new HashMap<>();


        if(s.length()<t.length())
            return "";
        for(int i=0;i<t.length();i++)
        {
            hm_t.put(t.charAt(i),hm_t.getOrDefault(t.charAt(i),0)+1);
        }
        int left =0;
        int ans = Integer.MAX_VALUE;
        int start = 0;
        for(int right=0;right<s.length();right++){

            hm_s.put(s.charAt(right),hm_s.getOrDefault(s.charAt(right),0)+1);
            while(compare(hm_t,hm_s)){

                if(ans>right-left+1){
                    ans = right-left+1;
                    start = left;
                }
                //moving window forward 
                char leftChar = s.charAt(left);
                hm_s.put(leftChar,hm_s.get(leftChar)-1);
                if(hm_s.get(leftChar)==0){
                    hm_s.remove(leftChar);
                }
               
                left++;
            }        

        }
        return ans==Integer.MAX_VALUE ? "":s.substring(start,start+ans);

    }
}
