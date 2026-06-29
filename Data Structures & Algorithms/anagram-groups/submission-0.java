class Solution {
    public String sort(String s){
        char [] arr = s.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        
        HashMap<String,List<String>> hm = new HashMap<>();
        List<List<String>> ans = new ArrayList<List<String>>();

        for(int i=0;i<strs.length;i++)
        {
            String hashKey = sort(strs[i]);
            if(!hm.containsKey(hashKey)){
                List<String> l = new ArrayList<>();
                l.add(strs[i]);
                hm.put(hashKey,l);
            }
            else
                hm.get(hashKey).add(strs[i]);
            
        }
        System.out.println(hm);
        ans.addAll(hm.values());
        return ans;
        
    }
}
