public class Solution {
    boolean[][] visited;
    Trie trie;
    public List<String> findWords(char[][] board, String[] words) {
        trie = new Trie();
        for(String word: words) {
            trie.insert(word);
        }
        if(board == null || words == null)    return null;
        Set<String> resultWords = new HashSet<String>();
        visited = new boolean[board.length][board[0].length];
        for(int row = 0; row < board.length; row++) {
            for(int col = 0; col < board[0].length; col++) {
                if(trie.hasPrefix(""+board[row][col]))
                    searchWords(board, row, col, trie.root, "", resultWords);
            }
        }
        return new ArrayList<String>(resultWords);
    }
    public void searchWords(char[][] board, int row, int col, TrieNode node, String word, Set<String> resultWords) {
        if(row >= board.length || col >= board[0].length || row < 0 || col < 0 || visited[row][col])   return;
        if(node.hasSubNode(board[row][col]) == null)    return;
        visited[row][col] = true;
        node = node.hasSubNode(board[row][col]);
        if(node.isWord)
            resultWords.add(word+board[row][col]);
        searchWords(board, row, col+1, node, word+board[row][col], resultWords);
        searchWords(board, row, col-1, node, word+board[row][col], resultWords);
        searchWords(board, row-1, col, node, word+board[row][col], resultWords);
        searchWords(board, row+1, col, node, word+board[row][col], resultWords);
        visited[row][col] = false;
    }
}
class TrieNode {
    char content;
    List<TrieNode> child;
    boolean isWord;
    public TrieNode(char c) {
        content = c;
        isWord = false;
        child = new ArrayList<TrieNode>();
    }
    public TrieNode insertChild(char c) {
        TrieNode temp = new TrieNode(c);
        child.add(temp);
        return temp;
    }
    public TrieNode hasSubNode(char c) {
        for(TrieNode node: child) {
            if(node.content == c) {
                return node;
            }
        }
        return null;
    }
}
class Trie {
    TrieNode root;
    public Trie() {
        root = new TrieNode(' ');
    }
    public void insert(String word) {
        if(hasWord(word))   return;
        TrieNode current = root;
        for(char c: word.toCharArray()) {
            if(current.hasSubNode(c) != null) {
                 current = current.hasSubNode(c);
                 continue;
            }
            current = current.insertChild(c);
        }
        current.isWord = true;
    }
    public boolean hasWord(String word) {
        TrieNode current = root;
        for(char c: word.toCharArray()) {
            current = current.hasSubNode(c);
            if(current == null)
                return false;
        }
        return (current.isWord) ? true:false;
    }
    public boolean hasPrefix(String prefix) {
        TrieNode current = root;
        for(char c: prefix.toCharArray()) {
            current = current.hasSubNode(c);
            if(current == null)
                return false;
        }
        return true;
    }
}
