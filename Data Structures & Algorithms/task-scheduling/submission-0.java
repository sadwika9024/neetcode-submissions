class Solution {
    public int leastInterval(char[] tasks, int n) {

        int countArray[] = new int[26];

        for(int i=0;i<tasks.length;i++)
        {
          countArray[tasks[i]-'A']++;
        }
        int max = 0;
        for(int i=0;i<26;i++)
        {
            max = Math.max(max,countArray[i]);
        }
        // Count how many tasks have the maximum frequency
        int maxFreqTasks = 0;

        for (int i = 0; i < 26; i++) {
            if (countArray[i] == max) {
                maxFreqTasks++;
            }
        }
        
        return Math.max((max-1)*(n+1)+maxFreqTasks,tasks.length);
        

    }
}
