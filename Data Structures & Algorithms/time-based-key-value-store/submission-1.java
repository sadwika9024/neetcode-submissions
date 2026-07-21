public class Pair {
    int timestamp;
    String value;
    public Pair( int timestamp,String value){

        this.timestamp = timestamp;
        this.value = value;
    }
}
class TimeMap {

    HashMap<String,List<Pair>> hm = new HashMap<>();

    public TimeMap() {
        
    }
    
    public void set(String key, String value, int timestamp) {

        List<Pair> list = hm.computeIfAbsent(key,k-> new ArrayList<>());
        list.add(new Pair(timestamp,value));
        
    }
    
    public String get(String key, int timestamp) {

        if(!hm.containsKey(key)){
           return "";
        }
        List<Pair> ls = hm.get(key);
        int left = 0;
        String ans = "";
        int right = ls.size()-1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(ls.get(mid).timestamp == timestamp)
                return ls.get(mid).value;
            else if(ls.get(mid).timestamp<timestamp){
                ans = ls.get(mid).value;
                left = mid+1;
                
            }
            else
                right = mid-1;

        }

        return ans;

        
    }
}
