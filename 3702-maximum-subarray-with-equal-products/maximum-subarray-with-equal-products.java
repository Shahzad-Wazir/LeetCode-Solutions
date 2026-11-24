class Solution {
    public int maxLength(int[] nums) {
        int n = nums.length;
        int maxLen = 2; // Any subarray of length 2 satisfies a * b == gcd(a, b) * lcm(a, b)
        int maxPossible = 25200; // lcm(1..10) * max(nums[i]) = 2520 * 10

        for (int i = 0; i < n; i++) {
            int prod = nums[i];
            int g = nums[i];
            int l = nums[i];

            for (int j = i + 1; j < n; j++) {
                prod *= nums[j];
                if (prod > maxPossible) {
                    break;
                }
                g = gcd(g, nums[j]);
                l = lcm(l, nums[j]);

                if (prod == g * l) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }

        return maxLen;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private int lcm(int a, int b) {
        return (a / gcd(a, b)) * b;
    }
}