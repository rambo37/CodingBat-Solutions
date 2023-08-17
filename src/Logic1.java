public class Logic1 {
    public boolean cigarParty(int cigars, boolean isWeekend) {
        if (isWeekend) return cigars >= 40;
        return cigars >= 40 && cigars <= 60;
    }


    public int dateFashion(int you, int date) {
        if (you <= 2 || date <= 2) return 0;
        if (you >= 8 || date >= 8) return 2;
        return 1;
    }


    public boolean squirrelPlay(int temp, boolean isSummer) {
        if (isSummer) return temp >= 60 && temp <= 100;
        return temp >= 60 && temp <= 90;
    }


    public int caughtSpeeding(int speed, boolean isBirthday) {
        int birthdayOffset = (isBirthday) ? 5 : 0;
        if (speed <= 60 + birthdayOffset) return 0;
        if (speed >= 61 + birthdayOffset && speed <= 80 + birthdayOffset) return 1;
        return 2;
    }


    public int sortaSum(int a, int b) {
        int sum = a + b;
        if (sum >= 10 && sum <= 19) return 20;
        return sum;
    }


    public String alarmClock(int day, boolean vacation) {
        if (vacation && isWeekday(day)) return "10:00";
        if (vacation && !isWeekday(day)) return "off";
        if (isWeekday(day)) return "7:00";
        return "10:00";
    }
    public boolean isWeekday(int day) {
        return day != 0 && day != 6;
    }


    public boolean love6(int a, int b) {
        if (a == 6 || b == 6 || a + b == 6) return true;
        return Math.abs(a-b) == 6;
    }


    public boolean in1To10(int n, boolean outsideMode) {
        if (outsideMode && (n <= 1 || n >= 10)) return true;
        return !outsideMode && n >= 1 && n <= 10;
    }

    public boolean specialEleven(int n) {
        return n % 11 == 0 || n % 11 == 1;
    }


    public boolean more20(int n) {
        return n % 20 == 1 || n % 20 == 2;
    }


    public boolean old35(int n) {
        return (n % 3 == 0) ^ (n % 5 == 0);
    }


    public boolean less20(int n) {
        return n % 20 == 19 || n % 20 == 18;
    }


    public boolean nearTen(int num) {
        return num % 10 == 1 || num % 10 == 2 || num % 10 == 9 || num % 10 == 8 ||
                num % 10 == 0;
    }


    public int teenSum(int a, int b) {
        if (a >= 13 && a <= 19) return 19;
        if (b >= 13 && b <= 19) return 19;
        return a + b;
    }


    public boolean answerCell(boolean isMorning, boolean isMom, boolean isAsleep) {
        if (isAsleep) return false;
        if (isMorning) return isMom;
        return true;
    }


    public int teaParty(int tea, int candy) {
        if (tea < 5 || candy < 5) return 0;
        if (tea >= 2 * candy || candy >= 2 * tea) return 2;
        return 1;
    }


    public String fizzString(String str) {
        if (str.startsWith("f") && str.endsWith("b")) return "FizzBuzz";
        if (str.startsWith("f")) return "Fizz";
        if (str.endsWith("b")) return "Buzz";
        return str;
    }


    public String fizzString2(int n) {
        if (n % 3 == 0 && n % 5 == 0) return "FizzBuzz!";
        if (n % 3 == 0) return "Fizz!";
        if (n % 5 == 0) return "Buzz!";
        return String.valueOf(n) + "!";
    }


    public boolean twoAsOne(int a, int b, int c) {
        if (a + b == c) return true;
        if (a + c == b) return true;
        return b + c == a;
    }


    public boolean inOrder(int a, int b, int c, boolean bOk) {
        return c > b && (bOk || b > a);
    }


    public boolean inOrderEqual(int a, int b, int c, boolean equalOk) {
        return (equalOk) ? a <= b && b <= c : a < b && b < c;
    }


    public boolean lastDigit(int a, int b, int c) {
        if (a % 10 == b % 10) return true;
        if (a % 10 == c % 10) return true;
        return b % 10 == c % 10;
    }


    public boolean lessBy10(int a, int b, int c) {
        if (a + 10 <= b || a + 10 <= c) return true;
        if (b + 10 <= a || b + 10 <= c) return true;
        return c + 10 <= a || c + 10 <= b;
    }


    public int withoutDoubles(int die1, int die2, boolean noDoubles) {
        if (noDoubles) {
            if (die1 + die2 == 12) return 7;
            if (die1 == die2) return die1 + die2 + 1;
        }
        return die1 + die2;
    }


    public int maxMod5(int a, int b) {
        if (a == b) return 0;
        if (a % 5 == b % 5) return Math.min(a, b);
        return Math.max(a,b);
    }


    public int redTicket(int a, int b, int c) {
        if (a == 2 && b == 2 && c == 2) return 10;
        if (a == b && b == c) return 5;
        if (b != a && c != a) return 1;
        return 0;
    }


    public int greenTicket(int a, int b, int c) {
        if (a != b && a !=c && b != c) return 0;
        if (a == b && b == c) return 20;
        return 10;
    }


    public int blueTicket(int a, int b, int c) {
        if (a + b == 10 || a + c == 10 || b + c == 10) return 10;
        if (a + b == 10 + a + c || a + b == 10 + b + c) return 5;
        return 0;
    }


    public boolean shareDigit(int a, int b) {
        return a % 10 == b % 10 || a % 10 == b / 10 || a / 10 == b % 10 || a / 10 == b / 10;
    }


    public int sumLimit(int a, int b) {
        int lengthA = String.valueOf(a).length();
        int lengthSum = String.valueOf(a+b).length();
        if (lengthA == lengthSum) return a + b;
        return a;
    }
}
