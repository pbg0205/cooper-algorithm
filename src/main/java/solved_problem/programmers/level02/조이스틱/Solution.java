package solved_problem.programmers.level02.조이스틱;

class Solution {
    private static int[] minArr;

    public int solution(String name) {
        int answer = 0;
        minArr = new int[name.length()];

        int index = 0;
        for (char alphabet : name.toCharArray()) {
            minArr[index++] = alphabet - 'A' < 'Z' -  alphabet + 1 ?
                    alphabet - 'A' : 'Z' - alphabet + 1;
        }

        int nowIndex = 0;

        while(true) {
            if(minArr[nowIndex] != 0) {
                answer += minArr[nowIndex];
                minArr[nowIndex] = 0;
            }

            int prev = 1;
            int next = 1;
            int prevIndex;
            int nextIndex;

            if(!isPlaying()) {
                break;
            }

            while(true) {
                prevIndex = nowIndex - prev >= 0 ?
                        nowIndex - prev : (minArr.length + (nowIndex - prev) % minArr.length);
                if(minArr[prevIndex] != 0) {
                    break;
                }
                prev += 1;
            }

            while(true) {
                nextIndex = nowIndex + next < minArr.length ?
                        nowIndex + next : (nowIndex + next) % minArr.length;
                if(minArr[nextIndex] != 0) {
                    break;
                }
                next += 1;
            }
            nowIndex = prev < next ? prevIndex : nextIndex;
            answer += prev < next ? prev : next;
        }

        return answer;
    }

    private boolean isPlaying() {
        for (int number : minArr) {
            if(number != 0) {
                return true;
            }
        }
        return false;
    }
}