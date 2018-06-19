/*Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
Note:

Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
Example 1:

Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Output: 5

Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.
Example 2:

Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

Output: 0

Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
*/

import java.util.*;

class Solution {
    Map<String, Set<String>> neighbors = new HashMap<>();
    Map<String, Integer> distance = new HashMap<>();
    Set<String> mark = new HashSet<>();


    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        buildNeighbors(beginWord, wordList);

        // BFS
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        mark.add(beginWord);

        int dist = 0;
        while(!queue.isEmpty()) {
            dist += 1;

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();

                // found the end word
                if (word.equals(endWord)) {
                    return dist;
                }

                // set distance
                distance.put(word, dist);

                // visit neighbors
                for (String neighbor: neighbors.get(word)) {
                    if (mark.contains(neighbor)) {
                        continue;
                    }

                    queue.offer(neighbor);
                    mark.add(neighbor);
                }
            }
        }

        return 0;
    }

    private void buildNeighbors(String begin, List<String> wordList) {
        List<String> list = new ArrayList<>(wordList);
        list.add(begin);
        for (String word: list) {
            neighbors.put(word, new HashSet<>());
        }

        // O(n*L*26)
        for (String word: list) {
            char[] chars = word.toCharArray();
            // change the i-th character
            for (int i = 0; i < chars.length; i++) {
                char originalCh = chars[i];
                for (char newCh = 'a'; newCh <= 'z'; newCh++) {
                    if (originalCh == newCh) continue;
                    chars[i] = newCh;
                    String newWord = new String(chars);

                    if (neighbors.containsKey(newWord)) {
                        // System.out.println(word + " " + newWord);
                        addNeighbor(word, newWord);
                        addNeighbor(newWord, word);
                    }
                }
                chars[i] = originalCh;
            }
        }

        // WARNING: O(n^2) time limit exceeded
        // for (String a: list) {
        //     for (String b: list) {
        //         if (a.equals(b)) continue;
        //         if (isNeighbor(a, b)) {
        //             addNeighbor(a, b);
        //             addNeighbor(b, a);
        //         }
        //     }
        // }
    }

    private void addNeighbor(String word, String neighbor) {
        Set<String> set = neighbors.get(word);
        set.add(neighbor);
    }

    private boolean isNeighbor(String a, String b) {
        if (a.length() != b.length()) return false;
        if (a.equals(b)) return false;

        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                count += 1;
                if (count >= 2) {
                    return false;
                }
            }
        }
        if (count == 1) return true;
        return false;
    }
}


class Main {
    public static void main(String[] args) {
        String begin = "hit", end = "cog";
        List<String> wordList = new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log","cog"));
        
        Solution s = new Solution();
        
        int len = s.ladderLength(begin, end, wordList);

        System.out.println(len);
    }
}