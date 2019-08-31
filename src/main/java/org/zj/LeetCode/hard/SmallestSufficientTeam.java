package org.zj.LeetCode.hard;

import org.zj.dataStructure.Pair;

import java.util.*;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2019-07-20 12:48
 **/

public class SmallestSufficientTeam {
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        Map<String, Integer> skills = new HashMap<>();
        int n = req_skills.length;
        for (int i = 0; i < req_skills.length; i++) {
            skills.put(req_skills[i], i);
        }
        
        int[] dp = new int[1 << n];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        Pair<Integer, Integer>[] record = new Pair[1 << n];
        for (int i = 0; i < people.size(); i++) {
            int have = 0;
            for (String skill : people.get(i)) {
                have |= (1 << (skills.get(skill)));
            }
            for (int j = 0; j < dp.length; j++) {
                if (dp[j] == -1) {
                    continue;
                }
                int total = j | have;
                if (dp[total] == -1 || dp[total] > dp[j] + 1) {
                    dp[total] = dp[j] + 1;
                    record[total].setKey(j);
                    record[total].setValue(i);
                }


            }
            
        }
        LinkedList<Integer> ans = new LinkedList<>();

        int need = (1 << n) - 1;
        while (need != 0) {
            ans.addLast(record[need].getValue());
            need = record[need].getKey();
        }
        int resultLen = ans.size();
        int[] result = new int[resultLen];
        for (int i = 0; i < resultLen; i++) {
            result[i] = ans.get(i);
        }
        return result;
        

    }
    public static void main(String... args){
        SmallestSufficientTeam obj = new SmallestSufficientTeam();
        String[] req_skills = {"java", "nodejs", "reactjs"};
        List<List<String>> people = new ArrayList<>();
        List<String> people0 = new LinkedList<>();
        people0.add("java");
        List<String> people1 = new LinkedList<>();
        people1.add("nodejs");
        List<String> people2 = new LinkedList<>();
        people2.add("nodejs");
        people2.add("reactjs");

        people.add(people0);
        people.add(people1);
        people.add(people2);
        int[] res = obj.smallestSufficientTeam(req_skills, people);
        for (int re : res) {
            System.out.println(re);
        }

    }
}

