class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        for (int i = 0; i<temperatures.length; i++) {
            answer[i] = findGreaterTempThanTempI(temperatures, i);
        }

        return answer;
    }

    private int findGreaterTempThanTempI(int[] temps, int idx) {
        int cnt = 0;
        int size = temps.length;
        int k = idx + 1;
        while(k < size && temps[k] <= temps[idx]) {
            cnt++;
            k++;
        }
        if (k < size) return cnt + 1;
        return 0;
    }
}
