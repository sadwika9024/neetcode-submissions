class PrefixTree {

        class Node {
                Node[] children = new Node[26];
                        boolean isWord;
                            }

                                private Node root;

                                    public PrefixTree() {
                                            root = new Node();
                                                }

                                                    public void insert(String word) {
                                                            Node current = root;

                                                                    for (char c : word.toCharArray()) {
                                                                                int index = c - 'a';

                                                                                            if (current.children[index] == null) {
                                                                                                            current.children[index] = new Node();
                                                                                                                        }

                                                                                                                                    current = current.children[index];
                                                                                                                                            }

                                                                                                                                                    current.isWord = true;
                                                                                                                                                        }

                                                                                                                                                            public boolean search(String word) {
                                                                                                                                                                    Node current = root;

                                                                                                                                                                            for (char c : word.toCharArray()) {
                                                                                                                                                                                        int index = c - 'a';

                                                                                                                                                                                                    if (current.children[index] == null) {
                                                                                                                                                                                                                    return false;
                                                                                                                                                                                                                                }

                                                                                                                                                                                                                                            current = current.children[index];
                                                                                                                                                                                                                                                    }

                                                                                                                                                                                                                                                            return current.isWord;
                                                                                                                                                                                                                                                                }

                                                                                                                                                                                                                                                                    public boolean startsWith(String prefix) {
                                                                                                                                                                                                                                                                            Node current = root;

                                                                                                                                                                                                                                                                                    for (char c : prefix.toCharArray()) {
                                                                                                                                                                                                                                                                                                int index = c - 'a';

                                                                                                                                                                                                                                                                                                            if (current.children[index] == null) {
                                                                                                                                                                                                                                                                                                                            return false;
                                                                                                                                                                                                                                                                                                                                        }

                                                                                                                                                                                                                                                                                                                                                    current = current.children[index];
                                                                                                                                                                                                                                                                                                                                                            }

                                                                                                                                                                                                                                                                                                                                                                    return true;
                                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                                        }