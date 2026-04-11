class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxBanana = piles[0];

        for (int i = 1; i<piles.length; i++) {
            maxBanana = Math.max(maxBanana, piles[i]);
        }

        int minBanana = 1;
        int answer = maxBanana;

        while (minBanana <= maxBanana) {
            int midB = (minBanana + maxBanana) / 2;
            if (isPossibleInMidHours(midB, piles, h)) {
                answer = Math.min(answer, midB);
                maxBanana = midB-1;
            }
            else {
                minBanana = midB+1;
            }
        }
        return answer;
    }

    private boolean isPossibleInMidHours(int mid, int[] piles, int h) {
        int numberOfH = 0;
        for(int i = 0; i<piles.length; i++) {
            numberOfH += Math.ceil((double)piles[i]/mid);
            if (numberOfH > h) return false;
        }
        return true;
    }
}
