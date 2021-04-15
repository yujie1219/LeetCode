package solution;

public class LeetCode343 {
    public int integerBreak(int n) {
        int foo = (int) Math.sqrt(n);

        int foo1 = n % foo;
        int foo2 = n / foo;

        int foo3 = Math.max(foo + foo1, foo * foo1);

        int result = 1;
        for (int i = 1; i < foo2; i++) {
            result *= foo;
        }

        return result * foo3;
    }
}
