package leecode;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RankTeamsByVotes
{
    class Solution {

        public String rankTeams(String[] votes) {
            Map<Character, Integer[]> teams = new HashMap();
            for (String vote : votes) {
                for(int i = 0 ; i< vote.length(); i++) {
                    char team = vote.charAt(i);
                    Integer[] curr = teams.get(team);
                    if(curr == null) {
                        curr = new Integer[vote.length() + 1];
                        Arrays.fill(curr, 0);
                    }
                    curr[i]++;
                    teams.put(team,curr);
                }
            }
            List<Map.Entry<Character, Integer[]>> list = new ArrayList<>(teams.entrySet());
            Collections.sort(list, (Map.Entry<Character, Integer[]> t1, Map.Entry<Character, Integer[]> t2) -> {
                    for(int i=0 ; i<t1.getValue().length; i++){
                        if(t1.getValue()[i] != t2.getValue()[i]) {
                            return t2.getValue()[i] - t1.getValue()[i];
                        }
                    }
                    return t1.getKey().compareTo(t2.getKey());
            });
            StringBuilder sb = new StringBuilder();
            for (int i=0; i < list.size(); i++) {
                sb.append(list.get(i).getKey());
            }
            return sb.toString();
        }
    }

    @Test
    void rankTeams(){
        Solution solution = new Solution();
        String[] votes = new String[]{"ABC","ACB","ABC","ACB","ACB"};
        String actual = solution.rankTeams(votes);
        assertEquals("ACB", actual);
        votes = new String[]{"BCA","CAB","CBA","ABC","ACB","BAC"};
        actual = solution.rankTeams(votes);
        assertEquals("ABC", actual);
    }
}
