class Solution {

    public double myPow(double x, int n) {

        long power = n;
        double ans = 1.0;

        // Handle negative exponent
        if (power < 0) {
            power = -power;
        }

        while (power > 0) {

            // If power is odd
            if (power % 2 == 1) {
                ans *= x;
            }

            // Square x
            x *= x;

            // Divide power by 2
            power /= 2;
        }

        // For negative exponent: x^(-n) = 1 / x^n
        if (n < 0) {
            return 1.0 / ans;
        }

        return ans;
    }
}