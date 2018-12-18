package org.zj.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2018-12-17 21:12
 **/

public class TextJustification {
    private String[] words;
    private int index;
    private int maxWidth;

    public List<String> fullJustify(String[] words, int maxWidth) {
        this.words = words;
        this.index = 0;
        this.maxWidth = maxWidth;

        int[] lens = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            lens[i] = words[i].length();
        }
        List<String> result = new ArrayList<>();
        int wordLenSum = 0;
        int wordCount = 0;
        for (int i = 0; i < words.length; i++) {
            if (wordLenSum + wordCount + lens[i] <= maxWidth) {
                wordCount++;
                wordLenSum += lens[i];
            } else {
                String tmp = handleString(wordCount, wordLenSum);
                result.add(tmp);
                wordCount = 1;
                wordLenSum = lens[i];
            }
        }
        if (wordCount > 0) {
            result.add(handleEnd(wordCount));
        }
        return result;


    }

    private String handleString(int count, int wordLenSum) {
        int spaceWidthSum = maxWidth - wordLenSum;
        int spaceWidth = 0;
        int longSpaceCount = 0;
        if (count>1) {
             spaceWidth = spaceWidthSum / (count - 1);
             longSpaceCount = spaceWidthSum % (count - 1);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(words[index + i]);
            if (i < count - 1) {
                //插入空格
                int tmpSpaceWidth = i < longSpaceCount ? spaceWidth + 1 : spaceWidth;
                for (int j = 0; j < tmpSpaceWidth; j++) {
                    sb.append(' ');
                }
            }
        }
        for (int i = sb.length(); i < maxWidth; i++) {
            sb.append(' ');
        }
        index += count;
        return sb.toString();
    }

    private String handleEnd(int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(words[index + i]);
            if (i < count - 1) {
                sb.append(' ');
            }
        }
        for (int i = sb.length(); i < maxWidth; i++) {
            sb.append(' ');
        }
        index += count;
        return sb.toString();
    }
public static void main(String... args){
    String[] words = {"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"};
    int maxWitdth = 20;
    List<String> res = new TextJustification().fullJustify(words, maxWitdth);
    for (String re : res) {
        System.out.println(re);

    }

}

}
