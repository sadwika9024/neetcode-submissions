class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        Stack<Pair<Integer,Integer>> ms = new Stack<>();
        int[] ans = new int[temperatures.length];
        for(int i=temperatures.length-1;i>=0;i--){

            int element = temperatures[i];

            while(!ms.isEmpty() && ms.peek().getKey()<=element){
                ms.pop();
            }
            if(ms.isEmpty()){
                ans[i] = 0;
            }
            else{
                ans[i] = ms.peek().getValue() - i;
            }



            ms.push(new Pair<>(temperatures[i],i));

        }
        return ans;

        
    }
}
