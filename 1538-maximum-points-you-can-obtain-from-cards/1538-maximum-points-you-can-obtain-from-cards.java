class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int totalSum = 0;

        for (int point : cardPoints) {
            totalSum += point;
        }

        int windowSize = n - k;
        int currSum = 0;

        for (int i = 0; i < windowSize; i++) {
            currSum += cardPoints[i];
        }

        int minSubarray = currSum;

        for (int i = windowSize; i < n; i++) {
            currSum += cardPoints[i] - cardPoints[i - windowSize];
            minSubarray = Math.min(minSubarray, currSum);
        }

        return totalSum - minSubarray;
    }
}
