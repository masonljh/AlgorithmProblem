package programmers.id12981;

import java.util.HashSet;

public class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[]{0, 0};
        String lastCh = null;
        HashSet<String> wordSet = new HashSet<>();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (wordSet.contains(word) || (lastCh != null && !word.startsWith(lastCh))) {
                answer[0] = (i % n) + 1;
                answer[1] = (int) (Math.ceil(i / n) + 1);
                return answer;
            }

            wordSet.add(word);
            lastCh = word.substring(word.length() - 1);
        }
        return answer;
    }
}