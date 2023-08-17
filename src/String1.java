public class String1 {
    public String helloName(String name) {
        return "Hello " + name + "!";
    }


    public String makeAbba(String a, String b) {
        return a + b + b + a;
    }


    public String makeTags(String tag, String word) {
        return "<" + tag + ">" + word + "</" + tag + ">";
    }


    public String makeOutWord(String out, String word) {
        int middle = out.length() / 2;
        return out.substring(0, middle) + word + out.substring(middle);
    }


    public String extraEnd(String str) {
        String end = str.substring(str.length() - 2);
        return end + end + end;
    }


    public String firstTwo(String str) {
        if (str.length() < 2) {
            return str;
        }
        return str.substring(0, 2);
    }


    public String firstHalf(String str) {
        return str.substring(0, str.length()/2);
    }


    public String withoutEnd(String str) {
        return str.substring(1, str.length()-1);
    }


    public String comboString(String a, String b) {
        if (a.length() < b.length()) {
            return a + b + a;
        }
        return b + a + b;
    }


    public String nonStart(String a, String b) {
        return a.substring(1) + b.substring(1);
    }


    public String left2(String str) {
        return str.substring(2) + str.substring(0, 2);
    }


    public String right2(String str) {
        return str.substring(str.length() - 2) + str.substring(0, str.length() - 2);
    }


    public String theEnd(String str, boolean front) {
        if (front) {
            return str.substring(0, 1);
        }
        return str.substring(str.length() - 1);
    }


    public String withouEnd2(String str) {
        if (str.length() < 2) {
            return "";
        }
        return str.substring(1, str.length() - 1);
    }


    public String middleTwo(String str) {
        return str.substring(str.length()/2 - 1, str.length()/2 + 1);
    }


    public boolean endsLy(String str) {
        return !(str.length() < 2) && str.substring(str.length()-2).equals("ly");
        // Or just str.endsWith("ly");
    }


    public String nTwice(String str, int n) {
        return str.substring(0, n) + str.substring(str.length() - n);
    }


    public String twoChar(String str, int index) {
        if (index < 0 || index >= str.length() - 1) {
            return str.substring(0, 2);
        }
        return str.substring(index, index+2);
    }


    public String middleThree(String str) {
        int middle = str.length() / 2;
        return str.substring(middle - 1, middle + 2);
    }


    public boolean hasBad(String str) {
        // return str.indexOf("bad") == 0 || str.indexOf("bad") == 1;
        if (str.length() <= 3 && !str.equals("bad")) return false;
        return str.substring(0, 3).equals("bad") || str.substring(1, 4).equals("bad");
    }


    public String atFirst(String str) {
        String result = str;
        while (result.length() <= 2) {
            result += "@";
        }
        return result.substring(0, 2);
    }


    public String lastChars(String a, String b) {
        String first = (a.isEmpty()) ? "@" : a.substring(0, 1);
        String second = (b.isEmpty()) ? "@" : b.substring(b.length() - 1);
        return first + second;
    }


    public String conCat(String a, String b) {
        if (a.isEmpty() || b.isEmpty()) {
            return a + b;
        }
        if (a.substring(a.length() - 1).equals(b.substring(0, 1))) {
            return a.substring(0, a.length() - 1) + b;
        }
        return a + b;
    }


    public String lastTwo(String str) {
        if (str.length() < 2) {
            return str;
        }
        String first = str.substring(str.length()-2, str.length()-1);
        String second = str.substring(str.length()-1);

        return str.substring(0, str.length()-2) + second + first;
    }


    public String seeColor(String str) {
        if (str.startsWith("red")) {
            return "red";
        }
        if (str.startsWith("blue")) {
            return "blue";
        }
        return "";
    }


    public boolean frontAgain(String str) {
        if (str.length() < 2) {
            return false;
        }
        return str.substring(0, 2).equals(str.substring(str.length()-2));
    }


    public String minCat(String a, String b) {
        if (a.length() == b.length()) {
            return a + b;
        }

        if (a.length() > b.length()) {
            return a.substring(a.length() - b.length()) + b;
        }

        return a + b.substring(b.length() - a.length());
    }


    public String extraFront(String str) {
        if (str.length() < 2) {
            return str + str + str;
        }
        String firstTwo = str.substring(0, 2);
        return firstTwo + firstTwo + firstTwo;
    }


    public String without2(String str) {
        if (str.length() < 2) {
            return str;
        }

        if (str.substring(0, 2).equals(str.substring(str.length()-2))) {
            return str.substring(2);
        }

        return str;

    }


    public String deFront(String str) {
        if (str.isEmpty()) {
            return str;
        }

        String result = "";
        if (str.charAt(0) == 'a') {
            result += "a";
        }

        if (str.length() >= 2) {
            if (str.charAt(1) == 'b') {
                result += "b";
            }
            // Not out of bounds for strings of length 2 (returns empty string)
            result += str.substring(2);
        }

        return result;
    }


    public String startWord(String str, String word) {
        if (word.length() == 1 && !str.isEmpty()) {
            return str.substring(0, 1);
        }

        if (str.indexOf(word.substring(1)) == 1) {
            return str.substring(0, 1) + word.substring(1);
        }
        return "";
    }


    public String withoutX(String str) {
        if (str.isEmpty()) {
            return str;
        }

        if (str.equals("x")) {
            return "";
        }

        String result = str;
        if (str.startsWith("x")) {
            result = result.substring(1);
        }

        if (str.endsWith("x")) {
            result = result.substring(0, result.length() - 1);
        }

        return result;
    }


    public String withoutX2(String str) {
        if (str.isEmpty()) {
            return str;
        }

        String result = "";

        for (int i = 0; i < str.length(); i++) {
            if (!(str.charAt(i) == 'x') || i > 1) {
                result += str.substring(i, i+1);
            }
        }

        return result;
    }

}
