class TrieNode {
    // Initialize your data structure here.
    char content;
    boolean isEnd;
    LinkedList<TrieNode> child;
    public TrieNode(char c) {
        child = new LinkedList<TrieNode>();
        content = c;   
        isEnd = false;
    }
    public TrieNode hasSubTrieNode(char c) {
        if(child == null)
            return null;
        for(TrieNode trieNode : child) {
            if(trieNode.content == c)
                return trieNode;
        }
        return null;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode(' ');
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        if(search(word) == true)
            return;
        TrieNode current = root;
        for(char c : word.toCharArray()) {
            if(current.hasSubTrieNode(c) != null) {
                current = current.hasSubTrieNode(c);
            }else {
                TrieNode node = new TrieNode(c);
                current.child.add(node);
                current = node;
            }
        }
        current.isEnd = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode current = root;
        for(char c : word.toCharArray()) {
            if(current.hasSubTrieNode(c) == null) {
                return false;
            }
            current = current.hasSubTrieNode(c);
        }
        if(current.isEnd)
            return true;
        return false;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for(char c : prefix.toCharArray()) {
            if(current.hasSubTrieNode(c) == null) {
                return false;
            }
            current = current.hasSubTrieNode(c);
        }
        return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
