public class Warmup1 {
    public boolean sleepIn(boolean weekday, boolean vacation) {
        return !weekday || vacation;
    }


    public boolean monkeyTrouble(boolean aSmile, boolean bSmile) {
        return aSmile == bSmile;
    }


    public int sumDouble(int a, int b) {
        int sum = a + b;

        if (a == b) {
            sum *= 2;
        }

        return sum;
    }


    public int diff21(int n) {
        if (n <= 21) {
            return Math.abs(21 - n);
        }
        return 2 * Math.abs(21 - n);
    }


    public boolean parrotTrouble(boolean talking, int hour) {
        return talking && (hour < 7 || hour > 20);
    }


    public boolean makes10(int a, int b) {
        return a == 10 || b == 10 || a + b == 10;
    }


    public boolean nearHundred(int n) {
        return (n >= 90  && n <= 110 || n >= 190 && n <= 210);
    }


    public boolean posNeg(int a, int b, boolean negative) {
        if (negative) {
            return (a < 0 && b < 0);
        }

        return (a < 0 && b > 0) || (b < 0 && a > 0);
    }


    public String notString(String str) {
        if (str.startsWith("not")) {
            return str;
        }

        return "not " + str;
    }


    public String missingChar(String str, int n) {
        return str.substring(0, n) + str.substring(n + 1);
    }


    public String frontBack(String str) {
        if (str.length() <= 1) {
            return str;
        }

        String first = str.substring(0, 1);
        String middle = str.substring(1, str.length() -1);
        String last = str.substring(str.length() - 1);
        return last + middle + first;
    }


    public String front3(String str) {
        String front = str;
        if (str.length() >= 3) {
            front = str.substring(0, 3);
        }
        return front + front + front;
    }


    public String backAround(String str) {
        String last = str.substring(str.length() - 1);
        return last + str + last;
    }


    public boolean or35(int n) {
        return n % 3 == 0 || n % 5 == 0;
    }


    public String front22(String str) {
        String front = str;
        if (str.length() >= 2) {
            front = str.substring(0, 2);
        }
        return front + str + front;
    }


    public boolean startHi(String str) {
        return str.startsWith("hi");
    }


    public boolean icyHot(int temp1, int temp2) {
        return (temp1 < 0 && temp2 > 100) || (temp2 < 0 && temp1 > 100);
    }


    public boolean in1020(int a, int b) {
        return (a >= 10 && a <= 20) || (b >= 10 && b <= 20);
    }


    public boolean hasTeen(int a, int b, int c) {
        return (a >= 13 && a <= 19) || (b >= 13 && b <= 19) || (c >= 13 && c <= 19);
    }


    public boolean loneTeen(int a, int b) {
        boolean isTeenA = (a >= 13 && a <= 19);
        boolean isTeenB = (b >= 13 && b <= 19);

        return (isTeenA && !isTeenB) || (!isTeenA && isTeenB);
    }


    public String delDel(String str) {
        if (str.length() > 3 && str.substring(1,4).equals("del")) {
            return str.substring(0,1) + str.substring(4);
        }
        return str;
    }


    public boolean mixStart(String str) {
        if (str.length() < 3) return false;
        return str.substring(1,3).equals("ix");
    }


    public String startOz(String str) {
        String result = "";
        if (str.length() > 0 && str.charAt(0) == 'o') result += "o";
        if (str.length() > 1 && str.charAt(1) == 'z') result += "z";
        return result;
    }


    public int intMax(int a, int b, int c) {
        if (a >= b && a >= c) {
            return a;
        }
        if (b >= a && b >= c) {
            return b;
        }
        return c;
    }


    public int close10(int a, int b) {
        int diffA = Math.abs(10-a);
        int diffB = Math.abs(10-b);
        if (diffA < diffB) {
            return a;
        }
        if (diffB < diffA) {
            return b;
        }
        return 0;
    }


    public boolean in3050(int a, int b) {
        if (inRange(30, 40, a) && inRange(30, 40, b)) {
            return true;
        }
        return inRange(40, 50, a) && inRange(40, 50, b);
    }
    public boolean inRange(int lower, int upper, int value) {
        return value >= lower && value <= upper;
    }


    public int max1020(int a, int b) {
        if ((a < 10 || a > 20) && (b < 10 || b > 20)) return 0;
        if (a < 10 || a > 20) return b;
        if (b < 10 || b > 20) return a;
        return Math.max(a, b);
    }


    public boolean stringE(String str) {
        int numEs = 0;
        char[] array = str.toCharArray();

        for (char ch: array) {
            if (ch == 'e') {
                numEs++;
            }
        }

        return numEs >= 1 && numEs <= 3;
    }


    public boolean lastDigit(int a, int b) {
        return a % 10 == b % 10;
    }


    public String endUp(String str) {
        if (str.length() < 3) {
            return str.toUpperCase();
        }
        int length = str.length();

        return str.substring(0, length-3) + str.substring(length-3).toUpperCase();
    }


    public String everyNth(String str, int n) {
        String result = str.substring(0,1);

        for (int i = n; i < str.length(); i+=n) {
            result += str.charAt(i);
        }

        return result;
    }
}
