package org.zj.LeetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2018-12-18 18:46
 **/

public class SimplifyPath {
    public String simplifyPath(String path) {
        if (path.length() == 0) {
            return path;
        }
        LinkedList<String> queue = new LinkedList<>();
        int start = 0;
        int end = 0;
        int length = path.length();
        String dirName;
        while (start<length) {
            while (start < length && path.charAt(start) == '/') {
                start++;
            }
            if (start >= length) {
                break;
            }

            end = start;
            while (end < length && path.charAt(end) != '/') {
                end++;
            }

            dirName = path.substring(start, end);
            start = end;

            if (dirName.equals(".")) {
                continue;
            } else if (dirName.equals("..")) {
                if (!queue.isEmpty()) {
                    queue.removeLast();
                }
            } else {
                queue.add(dirName);
            }
        }
        StringBuilder sb = new StringBuilder();
        if (queue.isEmpty()) {
            return "/";
        }
        while (!queue.isEmpty()) {
            sb.append("/");
            sb.append(queue.poll());
        }
        return sb.toString();

    }

    public static void main(String... args) {
        String path = "/../";
        String res = new SimplifyPath().simplifyPath(path);
        System.out.println(res);
    }
}
