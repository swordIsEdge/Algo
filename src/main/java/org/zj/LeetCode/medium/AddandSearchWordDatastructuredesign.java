package org.zj.LeetCode.medium;

import org.zj.dataStructure.TreeNode;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2019-07-07 18:45
 **/

public class AddandSearchWordDatastructuredesign {
}

class WordDictionary {
    TrieNode root;
    /**
     * Initialize your data structure here.
     */
    public WordDictionary() {
        this.root = new TrieNode();
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
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
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        return this.search(word, 0, this.root);
    }

    private boolean search(String word, int index, TrieNode root) {
        if (word == null || index == word.length()) {
            return true;
        }
        char c = word.charAt(index);
        if (index == word.length() - 1) {
            if (c == '.') {
                for (TrieNode nextNode : root.nextNodes) {
                    if (nextNode != null && nextNode.has) {
                        return true;
                    }
                }
                return false;
            } else {
                return root.nextNodes[c - 'a'] != null && root.nextNodes[c - 'a'].has;
            }
        }
        if (word.charAt(index) == '.') {

            for (TrieNode nextNode : root.nextNodes) {
                if (nextNode != null && this.search(word, index + 1, nextNode)) {
                    return true;
                }
            }
            return false;

        } else {
            if (root.nextNodes[c - 'a'] == null) {
                return false;
            }
            return this.search(word, index + 1, root.nextNodes[c - 'a']);
        }
    }

    class TrieNode {
        boolean has;
        TrieNode[] nextNodes;

        public TrieNode() {
            this.has = false;
            nextNodes = new TrieNode[26];
        }
    }
    public static void main(String... args){
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        wordDictionary.search("pad");
    }
}
