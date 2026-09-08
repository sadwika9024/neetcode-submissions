class Solution {


    public boolean backtrack(int i,int j,int wordIndex,String word,boolean[][] visited,char[][] board){

        if(wordIndex == word.length())
            return true;

        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length)
            return false;
        
        if (visited[i][j])
            return false;
        if(board[i][j]!=word.charAt(wordIndex)){
            return false;    
        }

        visited[i][j] = true;
       

            if(backtrack(i+1,j,wordIndex+1,word,visited,board))
                return true;
            if(backtrack(i-1,j,wordIndex+1,word,visited,board))
                return true;
            if(backtrack(i,j+1,wordIndex+1,word,visited,board))
                return true;
            if(backtrack(i,j-1,wordIndex+1,word,visited,board))
                return true;

        visited[i][j] = false;

        return false;

    }


    public boolean exist(char[][] board, String word) {

        boolean [][] visited = new boolean[board.length][board[0].length];
        int index = 0;

        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {

                if (board[i][j] == word.charAt(index)) {
                    if (backtrack(i, j, index,word,visited,board)) {
                        return true;
                    }
                }
            }
        }       

        return false;
    }
}
