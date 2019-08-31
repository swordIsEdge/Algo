package org.zj.LeetCode.medium;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2019-07-07 18:27
 **/

public class ImplementTrie {
}



class Trie {
    TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        this.root = new TrieNode();

    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TrieNode tmp = root;
        for (char c : word.toCharArray()) {
            if (tmp.nextNodes[c - 'a'] == null) {
                tmp.nextNodes[c - 'a'] = new TrieNode();
            }
            tmp = tmp.nextNodes[c - 'a'];
        }
        tmp.has = true;

    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode tmp = root;
        for (char c : word.toCharArray()) {
            if (tmp.nextNodes[c - 'a'] == null) {
                return false;
            }
            tmp = tmp.nextNodes[c - 'a'];
        }
        return tmp.has;

    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode tmp = root;
        for (char c : prefix.toCharArray()) {
            if (tmp.nextNodes[c - 'a'] == null) {
                return false;
            }
            tmp = tmp.nextNodes[c - 'a'];
        }
        return true;
    }
    class TrieNode {
        boolean has;
        TrieNode[] nextNodes;

        public TrieNode() {
            this.has = false;
            nextNodes = new TrieNode[26];
        }
    }

}