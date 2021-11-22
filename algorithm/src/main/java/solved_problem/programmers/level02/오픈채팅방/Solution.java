package solved_problem.programmers.level02.오픈채팅방;

import java.util.*;

class Solution {
    private static final String ENTER_MESSAGE_FORMAT = "%s님이 들어왔습니다.";
    private static final String LEAVE_MESSAGE_FORMAT = "%s님이 나갔습니다.";

    public String[] solution(String[] record) {
        Map<String, String> userMap = new HashMap<>();
        List<String> resultList = new ArrayList<>();

        for (String s : record) {
            String[] logSplit = s.split(" ");
            String command = logSplit[0];
            String userId = logSplit[1];

            if (command.equals("Enter") || command.equals("Change")) {
                String nickname = logSplit[2];
                userMap.put(userId, nickname);
            }
        }

        for (String s : record) {
            String[] logSplit = s.split(" ");
            String command = logSplit[0];
            String userId = logSplit[1];
            String nickName = userMap.get(userId);

            if (command.equals("Enter")) {
                resultList.add(String.format(ENTER_MESSAGE_FORMAT, nickName));
            }

            if (command.equals("Leave")) {
                resultList.add(String.format(LEAVE_MESSAGE_FORMAT, nickName));
            }
        }

        String[] result = new String[resultList.size()];
        return resultList.toArray(result);
    }
}