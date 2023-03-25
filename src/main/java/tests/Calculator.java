package tests;

public class Calculator {
    public int factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        } else if (n == 0 || n == 1) {
            return 1;
        } else {
            int result = n;
            for (int i = n - 1; i >= 2; i--) {
                result *= i;
            }
            return result;
        }
    }
}
