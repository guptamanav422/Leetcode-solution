class Solution {
    public long minimumMoney(int[][] transactions) {
        
        long res = 0, temp = 0;
        for (int[] arr : transactions) {
            temp = Math.max(temp, Math.min(arr[0], arr[1]));
            res += Math.max(arr[0] - arr[1], 0);
        }
        return res + temp;
    }
}