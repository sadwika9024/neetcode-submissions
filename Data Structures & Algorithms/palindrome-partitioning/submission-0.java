class Solution {

    public List<List<String>> partition(String s) {

        List<List<String>> ans = new ArrayList<>();
        List<String> current = new ArrayList<>();

        backtrack(s, 0, current, ans);

        return ans;
    }

    public void backtrack(
        String s,
        int start,
        List<String> current,
        List<List<String>> ans
    ) {

        // Entire string has been partitioned
        if (start == s.length()) {
            ans.add(new ArrayList<>(current));
            return;
        }

        // Try every possible substring starting at 'start'
        for (int end = start; end < s.length(); end++) {

            String part = s.substring(start, end + 1);

            if (isPalindrome(part)) {

                // Choose
                current.add(part);

                // Explore remaining string
                backtrack(s, end + 1, current, ans);

                // Undo
                current.remove(current.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String s) {

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {

            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}