class WordDictionary {

    class Node{
        Node[] children = new Node[26];
        boolean isEnd = false;
    }

    Node root;

    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        Node current = root;

        for(int i=0;i<word.length();i++){
            int index = word.charAt(i)-'a';
            if(current.children[index]==null)  
                current.children[index] = new Node();
            current = current.children[index];
        }
        current.isEnd = true;
    }

    public boolean search(String word) {

        return searchHelper(root, word, 0);
        

    }

    public boolean searchHelper(Node current, String word, int index){

        if(index == word.length())
            return current.isEnd;

        if(word.charAt(index)!='.'){
            int childindex = word.charAt(index)-'a';
            if(current.children[childindex]==null)  
                return false;
            return searchHelper(current.children[childindex],word,index + 1);
        }
            else{
                for(int j=0;j<26;j++){
                    if(current.children[j]!=null)  {
                        if(searchHelper(current.children[j],word,index + 1))
                            return true;
                        
                    }
                }
                        return false;

            }

        
    }
}
