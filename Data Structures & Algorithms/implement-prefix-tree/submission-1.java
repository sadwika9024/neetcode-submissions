class PrefixTree {
    class Node{
        Node[] children = new Node[26];
        boolean isEnd = false;
    }

     Node root;

    public PrefixTree() {

        root = new Node();
         
    }

    public void insert(String word) {
        Node current = root;

        for(int i=0;i<word.length();i++){
            int index = word.charAt(i)-'a';
           if (current.children[index] == null) {
                current.children[index] = new Node();
            }
            current = current.children[index];

        }
        current.isEnd = true;

    }

    public boolean search(String word) {
        Node current = root;
        for(int i=0;i<word.length();i++){
             int index = word.charAt(i)-'a';
           if (current.children[index] == null) {
            return false;
           }
           current = current.children[index];
        }
        if(current.isEnd)
            return true;

        return false;

    }

    public boolean startsWith(String prefix) {

         Node current = root;
        for(int i=0;i<prefix.length();i++){
             int index = prefix.charAt(i)-'a';
           if (current.children[index] == null) {
            return false;
           }
           current = current.children[index];
        }
        return true;
    }
}
