class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s : strs){
            sb.append(s.length());
            sb.append("#");
            sb.append(s);
        }

        return sb.toString();
    }

    public List<String> decode(String encodeString) {
    
        List<String> decodeString = new ArrayList<>();
        int i=0;
        while(i<encodeString.length()){
            
            int j = i;
            while(encodeString.charAt(j)!='#'){
                j++;
            }
             int length = Integer.parseInt(encodeString.substring(i,j));
             //System.out.println(length);
               j++; //pointer at firstcharater 
                
                decodeString.add(encodeString.substring(j,j+length));

                i = j+length;
            
        }
        return decodeString;
    } 
}
