public class Logic2 {
    public boolean makeBricks(int small, int big, int goal) {
        if (goal > small + 5 * big) return false;
        return goal % 5 <= small;
    }


    public int loneSum(int a, int b, int c) {
        int total = 0;
        if (a != b && a != c) total += a;
        if (b != a && b != c) total += b;
        if (c != a && c != b) total += c;
        return total;
    }


    public int luckySum(int a, int b, int c) {
        int sum = 0;
        if (a == 13) return 0;
        sum += a;
        if (b == 13) return sum;
        sum += b;
        if (c == 13) return sum;
        return sum + c;
    }


    public int noTeenSum(int a, int b, int c) {
        return fixTeen(a) + fixTeen(b) + fixTeen(c);
    }
    public int fixTeen(int n) {
        if (n <= 12 || n >= 20 || n == 15 || n == 16) return n;
        return 0;
    }


    public int roundSum(int a, int b, int c) {
        return round10(a) + round10(b) + round10(c);
    }
    public int round10(int num) {
        int lastDigit = num % 10;
        if (lastDigit >= 5) return num + (10 - lastDigit);
        return num - lastDigit;
    }


    public boolean closeFar(int a, int b, int c) {
        if (Math.abs(b-a) <= 1 && Math.abs(c-a) >= 2 && Math.abs(c-b) >= 2) return true;
        return Math.abs(c-a) <= 1 && Math.abs(b-a) >= 2 && Math.abs(b-c) >= 2;
    }


    public int blackjack(int a, int b) {
        int diffA = 21 - a;
        int diffB = 21 - b;
        if (diffA < 0 && diffB < 0) return 0;
        if (diffA < 0) return b;
        if (diffB < 0) return a;
        if (diffA < diffB) return a;
        return b;
    }


    public boolean evenlySpaced(int a, int b, int c) {
        int small;
        int medium;
        int large;

        if (a <= b && a <= c) small = a;
        else if (b <= a && b <= c) small = b;
        else small = c;

        if ((a >= b && a <= c) || (a >= c && a <= b)) medium = a;
        else if ((b >= a && b <= c) || (b >= c && b <= a)) medium = b;
        else medium = c;

        if (a >= b && a >= c) large = a;
        else if (b >= a && b >= c) large = b;
        else large = c;

        return large - medium == medium - small;
    }


    public int makeChocolate(int small, int big, int goal) {
        if (goal > big * 5 + small) return -1;
        if (goal % 5 > small) return -1;

        // how many big bars can be used without exceeding the goal
        int quotient = goal / 5;
        // if quotient >= big, we must use all of the big bars. Therefore, return what is left over
        // after using up all the big bars
        if (quotient >= big) return goal - 5*big;
        // if we reach here, then we cannot use up all the big bars since we would then exceed the
        // goal. Therefore, return the remainder after using up however many bars we can.
        return goal % 5;

        // easier to understand but less efficient solution:
//        if (goal > big * 5 + small) return -1;
//        if (goal % 5 > small) return -1;
//
//        int total = 0;
//        int usedBigs = 0;
//        while (total != goal) {
//            if (total + 5 <= goal && usedBigs < big) {
//                total += 5;
//                usedBigs++;
//            }
//            else {
//                return goal - total;
//            }
//        }
//
//        return 0;

    }

}
