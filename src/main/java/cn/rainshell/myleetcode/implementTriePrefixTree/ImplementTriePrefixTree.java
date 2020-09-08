package cn.rainshell.myleetcode.implementTriePrefixTree;

/**
 * 208. 实现 Trie (前缀树)
 * @author jason
 * @date 2020/9/8
 */
public class ImplementTriePrefixTree {

    private class TrieNode {

        /**
         * 分之数组
         */
        private TrieNode[] links;
        /**
         * 分支的长度，26个字母
         */
        private int R=26;
        /**
         * 是否是叶子节点
         */
        private boolean isEnd;

        /**
         * 构造方法，初始化分支数组26
         */
        public TrieNode() {
            links = new TrieNode[R];
        }
        public boolean containKey(char c) {
            return this.links[c - 'a'] != null;
        }
        public void put(char c, TrieNode node) {
            this.links[c-'a'] = node;
        }
        public TrieNode get(char c) {
            return this.links[c-'a'];
        }
        public void setIsEnd() {
            this.isEnd = true;
        }
        public boolean isEnd() {
            return this.isEnd;
        }
    }

    /** Initialize your data structure here. */
    private TrieNode root;
    public ImplementTriePrefixTree() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode rec = root;
        for(char c : word.toCharArray()) {
            if(!rec.containKey(c)) {
                rec.put(c, new TrieNode());
            }
            rec = rec.get(c);
        }
        rec.setIsEnd();
    }

    private TrieNode searchPreFix(String word) {
        TrieNode rec = root;
        for(char c : word.toCharArray()) {
            if(!rec.containKey(c)) {
                return null;
            }
            rec = rec.get(c);
        }
        return rec;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = this.searchPreFix(word);
        return node != null && node.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = this.searchPreFix(prefix);
        return node != null;
    }

    /**
     * Your Trie object will be instantiated and called as such:
     * Trie obj = new Trie();
     * obj.insert(word);
     * boolean param_2 = obj.search(word);
     * boolean param_3 = obj.startsWith(prefix);
     */
}
