class Solution {

    public String encode(List<String> strs) {
        String encode = "";
        for(int i=0;i<strs.size();i++){
            encode += strs.get(i).length() + "#" + strs.get(i);
            
        }
        System.out.println(encode);

        return encode;
    }

    public List<String> decode(String str) {
        
        String encodeString = str;

        List<String> decodeString = new ArrayList<>();
        int length = 0;
        int i=0;
        while(i<str.length()){
            
            int j = i;
            while(str.charAt(j)!='#'){
                j++;
            }
             length = Integer.parseInt(encodeString.substring(i,j));
             System.out.println(length);
               j++; //pointer at firstcharater 
            String decode = encodeString.substring(j,j+length);
                
                decodeString.add(decode);
                decode = "";
               

                i = j+length;
                //resetting the length 
                length = 0;

            
        }
        return decodeString;
    } 
}
