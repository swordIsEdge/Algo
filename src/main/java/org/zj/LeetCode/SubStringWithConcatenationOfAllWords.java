package org.zj.LeetCode;

import java.util.*;

public class SubStringWithConcatenationOfAllWords {
//    words 排序
//    遍历s，对s的每个char作为起始位置，二分搜索word，结果保存在与s同长的数组中
//    遍历该数组，比较word长度后是否有单词，并且不重不漏，使用set
    public List<Integer> findSubstring(String s, String[] words) {
        if (words == null || words.length == 0 || s == null || s.length() == 0) {
            return new ArrayList<>();
        }

        for (String word : words) {
            if (word == null) {
                return new ArrayList<>();
            }

        }
        //step 1
        Arrays.sort(words);

        //step2
        int sLength = s.length();
        String[] wordsLocation = new String[sLength];
        for (int i = 0; i < sLength; i++) {
            wordsLocation[i] = matchWord(s, i, words);
        }
        //step3
        int singleWordLength = words[0].length();
        int wordsSize = words.length; //总共有多少个字符串，用于和set的size比较，从而确定有没有包含所有字符串。
        HashMap<String, Integer> wordTimes = new HashMap<>();
        for (String word : words) {
            if (wordTimes.containsKey(word)) {
                wordTimes.put(word, wordTimes.get(word) + 1);
            } else {
                wordTimes.put(word, 1);
            }
        }
        HashMap<String, Integer> tmpMap = new HashMap<>();
        List<Integer> results = new ArrayList<>();
        int iterEnd = sLength - wordsSize * singleWordLength;
        for (int i = 0; i <= iterEnd; i++) {
            int j = i;
            int totalTimes = 0;
            while (j < wordsLocation.length && wordsLocation[j] != null && tmpMap.getOrDefault(wordsLocation[j], 0) < wordTimes.get(wordsLocation[j])) {
                tmpMap.put(wordsLocation[j], tmpMap.getOrDefault(wordsLocation[j], 0) + 1);
                totalTimes++;
                if (totalTimes == wordsSize) {
                    //包含了所有的小字符串，符合题意
                    results.add(i);
                    totalTimes = 0;
                    tmpMap.clear();
                    break;
                }
                j += singleWordLength;
            }
            tmpMap.clear();
        }
        return results;
    }
    private String matchWord(String s, int index, String[] words) {
        int wordLen = words[0].length();
        if (index + wordLen > s.length()) {
            return null;
        }
        String expect = s.substring(index, index + wordLen);
        //在words中二分搜索expect
        int start = 0, end = words.length-1, mid = end / 2;
        int compareResult;
        while (start <= end) {
            compareResult = expect.compareTo(words[mid]);
            if (compareResult<0) {//expect<words[mid]
                end = mid - 1;
            } else if (compareResult > 0) {
                start = mid + 1;
            } else {
                return words[mid];
            }
            mid = start + (end - start) / 2;
        }
        return null;
    }
    public static void main(String[] args){
        String[] words = {"foo", "bar"};
        String s = "barfoothefoobarman";
        List<Integer> res = new SubStringWithConcatenationOfAllWords().findSubstring(s, words);
        for (Integer re : res) {
            System.out.println(re);
        }

    }

}
