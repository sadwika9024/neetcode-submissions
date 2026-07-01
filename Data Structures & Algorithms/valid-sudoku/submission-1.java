class Solution {
    public boolean containsDulicate(char ch,HashSet<Character> hm){

        if(hm.contains(ch))
            return true;

        hm.add(ch);
        return false;
    }

    public boolean isValidSudoku(char[][] board) {

       
        for(int i=0;i<board.length;i++){

            HashSet<Character> hmRow = new HashSet<>();

            for(int j=0;j<board.length;j++){
                if(board[i][j]=='.')
                    continue;


               if(containsDulicate(board[i][j] , hmRow))
                return false;
               

            }
        }

        for(int i=0;i<board.length;i++){

            HashSet<Character> hmcol = new HashSet<>();

            for(int j=0;j<board.length;j++){
                if(board[j][i]=='.')
                    continue;


               if(containsDulicate(board[j][i] , hmcol))
                return false;
               

            }
        }



        for(int i=0;i<board.length;i+=3)
        {
            for(int j=0;j<board.length;j+=3){
                    HashSet<Character> hm3 = new HashSet<>();
                for(int startRow=i;startRow<i+3;startRow++){
                    for(int startCol = j ;startCol<j+3;startCol++){

                            if(board[startRow][startCol]=='.')
                            continue;


                            if(containsDulicate(board[startRow][startCol] , hm3))
                                return false;

                    }
                }

            }
        }
        return true;
    }
}
